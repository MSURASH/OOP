package org;

import java.sql.SQLException;

public class DB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomNum r = new RandomNum();
		//System.out.println(r.getRandNum());
		//int uuid = r.getRandNum();
		//int val = r.singleFetch(uuid);
		//System.out.println(val);
		try {
			String val = r.insert();
			System.out.println(val);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
