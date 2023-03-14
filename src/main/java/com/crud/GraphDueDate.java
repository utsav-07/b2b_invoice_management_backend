package com.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.connection.MyConnection;
import com.poso.DataFields;

public class GraphDueDate {

	public ArrayList<DataFields> getData(HashMap<String, String> map) {

		String sql = "\r\n"
				+ "SELECT COUNT(*) AS no_of_customer , SUM(total_open_amount/100000) AS sum_total_open_amount ,  business_name, clear_date FROM winter_internship w  NATURAL JOIN business b WHERE ";
				

		Iterator it = map.entrySet().iterator();
		String SqlWhereCondn = "";
		while (it.hasNext()) {
			Map.Entry entery = (Map.Entry) it.next();

			String cond = "";
			if ((String)entery.getKey() == "invoice_currency") {
				
				String temp = (String) entery.getValue();
				String[] strSplit = temp.split(" ");
				ArrayList<String> store = new ArrayList<String>(Arrays.asList(strSplit));
				
				for(String s : store) {
					SqlWhereCondn = SqlWhereCondn + " " + entery.getKey() + "\r\n" +" = \"" + s + "\" OR";
				}
				
				break;
				
				
				
			
			}
			String temp = (String) entery.getValue();
			String[] strSplit = temp.split(" ");
			ArrayList<String> store = new ArrayList<String>(Arrays.asList(strSplit));

			SqlWhereCondn = SqlWhereCondn + " " + entery.getKey() + "\r\n" + " BETWEEN \" " + store.get(0)
					+ "\" AND \" " + store.get(1) +"\" AND";

		}

		sql = sql + SqlWhereCondn;
		
		

		int index = sql.lastIndexOf(" ");

		sql = sql.substring(0, index);
		
		sql = sql + " GROUP BY business_name";

		System.out.println("final sql queru is  : " + sql);

//		String Sql2 = " SELECT COUNT(*) AS  total_invoice_currency , invoice_currency  FROM winter_internship  WHERE clear_date\r\n"
//				+ " BETWEEN \"2019-05-21\" AND \"2019-09-23\"  GROUP BY invoice_currency";
		ArrayList<DataFields> allData = new ArrayList<DataFields>();
		MyConnection myConnection = new MyConnection();
		myConnection.loadDriver();
		Connection con = myConnection.getConnection();

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			System.out.println(sql);

			while (rs.next()) {
				DataFields dataFields = new DataFields();
				dataFields.setNo_of_customer(rs.getString("no_of_customer"));
				dataFields.setSum_total_open_amount(rs.getString("sum_total_open_amount"));
				dataFields.setBusiness_name(rs.getString("business_name"));
				dataFields.setClear_date(rs.getString("clear_date"));

				allData.add(dataFields);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("some error");
		}
		
		myConnection.closeConnection(con);

		return allData;
	}

}
