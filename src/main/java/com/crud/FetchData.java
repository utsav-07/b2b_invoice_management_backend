package com.crud;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.connection.MyConnection;
import com.poso.DataFields;

public class FetchData {
	
	public ArrayList<DataFields> getData(){
		ArrayList<DataFields> allData = new ArrayList<DataFields>();
		MyConnection myConnection = new MyConnection();
		myConnection.loadDriver();
		Connection con = myConnection.getConnection();
		//String result = "data fetched successfully";
//		String sql = "select * from winter_internship limit 50";
		String sql = "SELECT * FROM winter_internship w  NATURAL JOIN customer c   NATURAL JOIN business b";
		 int sl_no , cust_number , posting_id , invoice_id , isOpen , is_deleted ;
		
		 String business_code   , doc_id , 
		 invoice_currency,document_type,area_business,
		cust_payment_terms ,aging_bucket;
		 
		 
		String baseline_create_date , clear_date ,posting_date ,  document_create_date ,document_create_date1 ,due_in_date , business_name , name_customer  ;
		int buisness_year;
		
		
		 double total_open_amount;
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
		
			
			
			while(rs.next()) {
				DataFields dataFields	= new DataFields();
				sl_no = rs.getInt("sl_no");
				cust_number = rs.getInt("cust_number");
				posting_id  = rs.getInt("posting_id");
				invoice_id = rs.getInt("invoice_id");
				isOpen = rs.getInt("isOpen");
				is_deleted = rs.getInt("is_deleted");
				business_code = rs.getString("business_code");
				
					clear_date  = rs.getString("clear_date");
				
			
				
				buisness_year = rs.getInt("buisness_year");
				doc_id = rs.getString("doc_id");
				posting_date  = rs.getString("posting_date");
				document_create_date = rs.getString("document_create_date");
				document_create_date1 = rs.getString("document_create_date1");
				due_in_date = rs.getString("due_in_date");
				invoice_currency = rs.getString("invoice_currency");
				document_type = rs.getString("document_type");
				area_business = rs.getString("area_business");
				cust_payment_terms = rs.getString("cust_payment_terms");
				total_open_amount = rs.getDouble("total_open_amount");
				aging_bucket = rs.getString("aging_bucket");
				baseline_create_date = rs.getString("baseline_create_date");
				name_customer = rs.getString("name_customer");
				business_name  = rs.getString("business_name");
				
				
				
				dataFields.setSl_no(sl_no);
				dataFields.setCust_number(cust_number);
				dataFields.setPosting_id(posting_id);
				dataFields.setInvoice_id(invoice_id);
				dataFields.setIsOpen(isOpen);
				dataFields.setIs_deleted(is_deleted);
				dataFields.setBusiness_code(business_code);
				dataFields.setClear_date(clear_date);
				dataFields.setBuisness_year(buisness_year);
				dataFields.setDoc_id(doc_id);
				dataFields.setPosting_date(posting_date);
				dataFields.setDocument_create_date(document_create_date);
				dataFields.setDocument_create_date1(document_create_date1);
				dataFields.setDue_in_date(due_in_date);
				dataFields.setInvoice_currency(invoice_currency);
				dataFields.setDocument_type(document_type);
				dataFields.setArea_business(area_business);
				dataFields.setCust_payment_terms(cust_payment_terms);
				dataFields.setTotal_open_amount(total_open_amount);
				dataFields.setName_customer(name_customer);
				dataFields.setBusiness_name(business_name);
				if(aging_bucket == null) {
					dataFields.setAging_bucket("");
				}
				else {
					dataFields.setAging_bucket(aging_bucket);
				}
				
				dataFields.setBaseline_create_date(baseline_create_date);
				

				
				allData.add(dataFields);
			
			}
			

		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("some error");
		}
		
		myConnection.closeConnection(con);
		
		
		//System.out.print(allData.size());
		
		return allData;
	}
	

}
