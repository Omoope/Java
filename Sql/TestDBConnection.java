package com.javalab.qaTest;
import java.sql.*;


public class TestDBConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
		ConnectionTest db = new ConnectionTest();
		ResultSet rs = db.getCustomer();
		
		
		
			while(rs.next()){
				System.out.println(rs.getString("CUSTOMERID") + " " + rs.getString("CUSTOMERNAME") + " " + rs.getString("CUSTOMERADDRESS")+ 
						" " + rs.getString("CUSTOMERPOSTALCODE") + " " + rs.getString("CUSTOMERCITY") );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
