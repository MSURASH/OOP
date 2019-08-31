package org;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import javax.sql.PooledConnection;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;



public class RandomNum {
	
	public RandomNum() {
		try {
			con = connect();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int num;
	private Connection con = null;
	private UUID uuid;
	public int getRandNum() {
		
		uuid = UUID.randomUUID();
		
		
		int uuids = uuid.hashCode();
		String val = Integer.toString(uuids);

		String val1 = val.substring(0, 1);
		if(val1.equals("-")) {
			getRandNum();

		}else {
			 num = (int) uuid.hashCode();
		}
		
		//num = 22;

		return num;
		
	}
	
	public int singleFetch(int uuid){
		
		
		try {
			//con = connect();
			Statement st = con.createStatement();
			String query  = "select doco from team where doco = '"+uuid+"'";
			ResultSet rs = st.executeQuery(query);
			int exist = 0;
			if (rs.next()) 
			 {
				exist = rs.getInt("doco");
				if ( exist > 0 ) {
					return 1;  
					}else {
						return 0;
					}
				 
			 } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
 
//			try {
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
          }
		return 0;
		

	}
	
	public String insert() throws ClassNotFoundException, SQLException {
		int uuid = getRandNum();
		int exist = singleFetch(uuid);
		
		if(exist == 0) {
	
		//con = connect();
		Statement st = con.createStatement();
        String sql = "insert into team(doco, lnid, teams, city) "
        + "values('" +uuid+ "', '" +1000+ "', '" +"SEAHAWKS"+ "', '" +"SEATTLE"+ "')"; 
        int rows = st.executeUpdate(sql); 
        if (rows > 0) {
    		//System.out.println(rows);

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
		
//		String url = "jdbc:oracle:thin:@localhost:1521/orcl.rev.global.pvt";
//		String user = "JDE";
//		String password = "jde01";
//		Class.forName("oracle.jdbc.OracleDriver");
//		Connection con = DriverManager.getConnection(url,user,password);
//		System.out.println("Database Ready...");
			
			OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
			ds.setURL("jdbc:oracle:thin:@localhost:1521/orcl.rev.global.pvt");
			ds.setUser("JDE");
			ds.setPassword("jde01");
			PooledConnection pc = ds.getPooledConnection();
			Connection con = pc.getConnection();
		return con;
	}
	
}
