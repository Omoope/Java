package com.javalab.qaTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class QuaryDb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			System.out.println("wAITING TO Connect");
		
		// Register driver command
		
		Class.forName ("oracle.jdbc.driver.OracleDriver");
		
		System.out.println(" NOT Connected YET");
		
		// open connection to the database
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:TESTSCH", "system", "oracle");
		
		System.out.println("Connected");
		
		
		Statement st =conn.createStatement(); // Create statement variable
		String sql = "delete from oreder where orderid = 1";
		 st.executeUpdate(sql);
		
		System.out.println("Statement was excuted properly");
			 

			 conn.close();
		}catch (Exception e){
			System.out.println(e);		
			}
	}
}
