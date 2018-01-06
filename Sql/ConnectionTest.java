package com.javalab.qaTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
	Connection conn;
	
	public void DBManager(){
		
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:TESTSCH", "system", "oracle");
		
		} catch (SQLException e) {
	
			e.printStackTrace();
		} catch (ReflectiveOperationException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	/*
	 * Add to order table
	 * 
	 */
		public int addOrder(int OrderID, int CustomerID, String Product){
		
			try{
			 
			 if(conn == null || conn.isClosed())
				
				 DBManager();
				PreparedStatement St = conn.prepareStatement("INSERT INTO OREDER VALUES (?, ?, ?, null)");
				St.setInt(1, OrderID);
				St.setInt(2, CustomerID);
				St.setString(3, Product);
				
				return St.executeUpdate();
				
				
				
		 } catch(SQLException e){
		 
		 System.out.println(e);
		
		 }
		 return 0;
		 
		
	}
		/*
		 * Add to customer_t table
		 */
		
		public int addCustomer(int CustomerID, String CustomerName , String CustomerAddress, String CustomerCity,String CustomerPostalCode){
			 try{
				 
				 if(conn == null || conn.isClosed())
					DBManager();
					PreparedStatement St = conn.prepareStatement("INSERT INTO CUSTOMER_T VALUES (?, ?, ?, ?, ?)");
					St.setInt(1, CustomerID);
					St.setString(2, CustomerName);
					St.setString(3, CustomerAddress);
					St.setString(4, CustomerCity);
					St.setString(5, CustomerPostalCode);
					
					return St.executeUpdate();
					
					
					
			 } catch(SQLException e){
			 
			 System.out.println(e);
			 }
			return 0;
		}
			 
		/*
		 * delete from table
		 */
		
		public ResultSet deleteOrder(){
			try {
				if(conn == null || conn.isClosed())
									
				 DBManager();
				
				Statement st =conn.createStatement();
				String sql = "DELETE FROM oreder WHERE product = 'kitchen stove'";
				 
				st.executeUpdate(sql);
				
				System.out.println("Data deleted Successfully");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		
		public ResultSet getCustomer(){
			
			try {
				if(conn == null || conn.isClosed())
									
				 DBManager();
				
				Statement st =conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM CUSTOMER_T");
				return rs;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		
		
		
		public ResultSet getOrder(){
			
			try {
				if(conn == null || conn.isClosed())
									
				 DBManager();
				
				Statement st =conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT ORDERID, CUSTOMERID, PRODUCT FROM OREDER");
				return rs;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		public ResultSet getJoin(){
			
			try {
				if(conn == null || conn.isClosed())
									
				 DBManager();
				
				Statement st =conn.createStatement();
				ResultSet rs = st.executeQuery("SELECT CUSTOMER_T.CUSTOMERID, CUSTOMER_T.CUSTOMERNAME, OREDER.ORDERID, OREDER.PRODUCT FROM CUSTOMER_T LEFT OUTER JOIN OREDER ON"
						+ " CUSTOMER_T.CUSTOMERID = OREDER.ORDERID ORDER BY ORDERID");
				return rs;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		
		
	
		
}
