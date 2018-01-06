package com.javalab.qaTest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;



public class OracleDB_Demo {

	public static void main(String[] args){
		
		
		try{
			System.out.println("wAITING TO Connect");
		
		// Register driver command
		
		Class.forName ("oracle.jdbc.driver.OracleDriver");
		
		System.out.println(" NOT Connected YET");
		
		// open connection to the database
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:TESTSCH", "system", "oracle");
		
		System.out.println("Connected");
		
		
		Statement st =conn.createStatement(); // Create statement variable
		
		System.out.println("Statement created");
		
		String sql = "select CUSTOMER_NAME, STREET from CUSTOMER_T";
		
		ResultSet rec = st.executeQuery(sql);
		


		while( rec.next()){	
		
			 System.out.println(rec.getString(1) +" "+ rec.getString(2));
		
			 };
			 st.close();
			 conn.close();
		}catch (Exception e){
			System.out.println(e);
			
		}
			

	}

}

