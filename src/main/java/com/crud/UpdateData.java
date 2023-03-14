package com.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.MyConnection;
import com.poso.DataFields;

public class UpdateData {
	
	
	public String Update(DataFields datafields) {
		MyConnection myConnection = new MyConnection();
		myConnection.loadDriver();
		Connection con = myConnection.getConnection();

		String result = "data updated successfully";
		
		String sql = "update winter_internship set invoice_currency=?,cust_payment_terms=? where sl_no=?";
		
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, datafields.getInvoice_currency());
			ps.setString(2, datafields.getCust_payment_terms());
			ps.setInt(3, datafields.getSl_no());
			
			ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
			result= "data not updated";
			
		}
		
		myConnection.closeConnection(con);
		
		return result;
	}
	
}
