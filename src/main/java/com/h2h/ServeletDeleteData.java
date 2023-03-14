package com.h2h;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.DeleteData;

/**
 * Servlet implementation class ServeletDeleteData
 */
@WebServlet("/ServeletDeleteData")
public class ServeletDeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletDeleteData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		String str;
		str = (request.getParameter("sl_no"));
		
		String[] strSplit = str.split(" ");
		 
	
		 
		  ArrayList<String> store = new ArrayList<String>(
		            Arrays.asList(strSplit));
		  for (String s : store) {
			  int sl_no = Integer.parseInt(String.valueOf(s));
//			  System.out.println(sl_no);
				DeleteData deleteData = new DeleteData();
				String result = deleteData.Delete(sl_no);
				
				response.getWriter().print(result);
		  }
	            
		
//		DeleteData deleteData = new DeleteData();
//		String result = deleteData.Delete(sl_no);
//		
//		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
