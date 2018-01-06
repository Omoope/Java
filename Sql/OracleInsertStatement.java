package com.javalab.qaTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class OracleInsertStatement {

	

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
	
		System.out.println("Statement created");
		
			String sql = "INSERT INTO CUSTOMER_T(CustomerID, CustomerNAME,CustomerCITY, CustomerAddress, CustomerPostalCode)"
				+ " VALUES (4, 'JAMES OPE', 'ALLENTOWN PA','566 REHOBOTH STREET', '18102')";
		
			String sql2 = " INSERT INTO OREDER(ORDERID, CUSTOMERID,  PRODUCT) VALUES(4, 4, 'BATHROOM TUB')"; 
		
		
			ResultSet rec = st.executeQuery(sql);
		
			rec = st.executeQuery(sql2);
			
			rec = st.executeQuery("SELECT CUSTOMERNAME, CUSTOMERCITY, CUSTOMERADDRESS, CUSTOMERPOSTALCODE, ORDERID, PRODUCT "
					+ "FROM CUSTOMER_T, OREDER");
			
			while(rec.next()){
				System.out.println(rec.getString("CUSTOMERNAME") + "   " + rec.getString("CUSTOMERADDRESS") + 
						"    " + rec.getString("CUSTOMERPOSTALCODE") + "   " + rec.getString("ORDERID")+ "   "+ rec.getString("PRODUCT"));
			}
			
		
		System.out.println("Statement Executed");
		
		st.close();
		conn.close();

		}  catch(Exception e){
		System.out.println(e);
		}

	}
}
