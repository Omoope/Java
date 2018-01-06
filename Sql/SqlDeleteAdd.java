package com.javalab.qaTest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDeleteAdd {

	public static void main(String[] args) {
		try{
		ConnectionTest conn = new ConnectionTest();
		ResultSet rs = conn.getOrder();
		
		conn.deleteOrder();
		
		System.out.println("Data deleted Sucessfully");
		
		
		conn.addOrder(1, 1, "Kitchen Stove");
		
		System.out.println("Data added back successfully");
		
		while(rs.next()){
			System.out.println(rs.getString("ORDERID") + " " + rs.getString("CUSTOMERID") + " " + rs.getString("PRODUCT"));
		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		}
		System.out.println("EXECUTED PROPERLY");

	}
	

}
