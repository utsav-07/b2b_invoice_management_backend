package com.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.MyConnection;
import com.poso.DataFields;

public class InsertData {

	public String Insert(DataFields datafields) {
		MyConnection myConnection = new MyConnection();
		myConnection.loadDriver();
		Connection con = myConnection.getConnection();
		// null check on con
		String result = "data inserted successfully";
		String sql = "INSERT INTO winter_internship values (? , ?, ? , ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
		// cust_number is foreign key so we have to first store the cust_number in
		// customer table
		//String sqlCustomerTable = "INSERT INTO customer values (?  , ?)";
		String sqlCustomerTable = "INSERT INTO customer SELECT * FROM (SELECT ?, ?) AS tmp WHERE NOT EXISTS ( SELECT * FROM customer WHERE cust_number = ?)";
		String sqlBusinessTable = "INSERT INTO business SELECT * FROM (SELECT ?, ?) AS tmp WHERE NOT EXISTS ( SELECT * FROM business WHERE business_code = ?)";
//		boolean res = false;
//		try {
//			PreparedStatement ps = con.prepareStatement(sqlCustomerTable);
//			ps.setInt(1, datafields.getCust_number());
//			ps.setString(2, datafields.getName_customer());
//			ps.executeUpdate();
//			res = true;
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			res = false;
//		}
		boolean x=false , y =false;
		try {
			PreparedStatement ps = con.prepareStatement(sqlCustomerTable);
			ps.setInt(1, datafields.getCust_number());
			ps.setString(2, datafields.getName_customer());
			ps.setInt(3, datafields.getCust_number());
			ps.executeUpdate();
			x=true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			result = "data not inserted";
			x=false;
		}
		
		
			if (x) {
				try {
					PreparedStatement ps = con.prepareStatement(sqlBusinessTable);
					ps.setString(1, datafields.getBusiness_code());
					ps.setString(2, datafields.getBusiness_name());
					ps.setString(3, datafields.getBusiness_code());
					ps.executeUpdate();
					y=true;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					result = "data not inserted";
					y=false;
				} 
			}
			if (x && y) {
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, datafields.getSl_no());
					ps.setString(2, datafields.getBusiness_code());
					ps.setInt(3, datafields.getCust_number());
					ps.setString(4, datafields.getClear_date());
					ps.setInt(5, datafields.getBuisness_year());
					ps.setString(6, datafields.getDoc_id());
					ps.setString(7, datafields.getPosting_date());
					ps.setString(8, datafields.getDocument_create_date());
					ps.setString(9, datafields.getDocument_create_date1());
					ps.setString(10, datafields.getDue_in_date());
					ps.setString(11, datafields.getInvoice_currency());
					ps.setString(12, datafields.getDocument_type());
					ps.setInt(13, datafields.getPosting_id());
					ps.setString(14, datafields.getArea_business());
					ps.setDouble(15, datafields.getTotal_open_amount());
					ps.setString(16, datafields.getBaseline_create_date());// base line create date
					ps.setString(17, datafields.getCust_payment_terms());
					ps.setInt(18, datafields.getInvoice_id());
					ps.setInt(19, datafields.getIsOpen());
					ps.setString(20, datafields.getAging_bucket()); // aging bucket
					ps.setInt(21, datafields.getIs_deleted());

					ps.executeUpdate();

				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
					result = "data not inserted";
				} 
			}
			
			myConnection.closeConnection(con);
		return result;
	}

}
