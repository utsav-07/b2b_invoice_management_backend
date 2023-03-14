package com.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.MyConnection;

public class DeleteData {
	
	public String Delete(int sl_no) {
		MyConnection myConnection = new MyConnection();
		myConnection.loadDriver();
		Connection con = myConnection.getConnection();

		String result = "data deleted successfully";
		
		String sql = "delete from winter_internship where sl_no =? ";
		//String sql =  "delete w,c FROM winter_internship w INNER JOIN customer c ON w.cust_number = c.cust_number WHERE sl_no = ?";
		
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, sl_no);
			
			ps.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "data not deleted";
		}
		
		myConnection.closeConnection(con);
		
		return result;
	}

}
