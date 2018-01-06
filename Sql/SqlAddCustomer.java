package com.javalab.qaTest;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SqlAddCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ConnectionTest db = new ConnectionTest();
			
			db.addCustomer(CustomerID, CustomerName, CustomerAddress, CustomerCity, CustomerPostalCode);
			
			ResultSet rs = db.getCustomer();
				
			while(rs.next()){
					System.out.println(rs.getString("CUSTOMERID") + " " + rs.getString("CUSTOMERNAME") + " " + rs.getString("CUSTOMERADDRESS")+ 
						" " + rs.getString("CUSTOMERPOSTALCODE") + " " + rs.getString("CUSTOMERCITY") );
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			System.out.println("Data added to Customer Table");

		}

}
