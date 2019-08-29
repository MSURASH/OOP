package org;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;



public class RandomNum {
	
	private int num;
	private Connection con = null;
	private UUID uuid;
	public int getRandNum() {
		
		uuid = UUID.randomUUID();
		
		//num = 1;
		
		int uuids = uuid.hashCode();
		String val = Integer.toString(uuids);

		String val1 = val.substring(0, 1);
		if(val1.equals("-")) {
			getRandNum();

		}else {
			 num = (int) uuid.hashCode();
		}
		
		return num;
		
	}
	
	public int singleFetch(int uuid){
		
		
		try {
			con = connect();
			Statement st = con.createStatement();
			String query  = "select doco from team where doco = '"+uuid+"'";
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) 
			 {
				return rs.getInt("doco");
			 } 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
 
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }
		return 0;
		

	}
	
	public String insert() throws ClassNotFoundException, SQLException {
		int uuid = getRandNum();
		int num = singleFetch(uuid);
		
		if(num == 0) {
	
		con = connect();
		Statement st = con.createStatement();
        String sql = "insert into team(doco, lnid, teams, city) "
        + "values('" +uuid+ "', '" +1000+ "', '" +"SEAHAWKS"+ "', '" +"SEATTLE"+ "')"; 
        int rows = st.executeUpdate(sql); 
        if (rows > 0) {
    		System.out.println(rows);

            con.close(); 
    		return "Insert Successful";
        }             
        else  {
        	con.close(); 
    		return "Insert Failed";

        }   
        
		}else {
			insert();
		}
		return null;
        
	}
	 
	
		private Connection connect() throws SQLException, ClassNotFoundException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/orcl.rev.global.pvt";
		String user = "JDE";
		String password = "jde01";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println("Database Ready...");

		return con;
	}
	
}
