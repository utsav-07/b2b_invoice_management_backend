package com.crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.connection.MyConnection;

public class GraphInvoiceCurrency {
		
	public HashMap<Object , Object> getData(){
		HashMap<Object , Object> totalData = new HashMap<Object , Object>();
		
		String sql = "SELECT invoice_currency , COUNT(invoice_currency) FROM winter_internship GROUP BY invoice_currency";
		
		MyConnection myConnection = new MyConnection();
		myConnection.loadDriver();
		Connection conn = myConnection.getConnection();
		HashMap<String , String>  total = new HashMap<String, String>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<String> name  = new ArrayList<String>(Arrays.asList("CAD" , "USD"));
			int i=0;
			while(rs.next()) {
					total.put(rs.getString("invoice_currency"), rs.getString("count(invoice_currency)"));
			}
			
			totalData.put("data", total);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("some error");
		}
		
		myConnection.closeConnection(conn);
		
		return totalData;
	}
}
