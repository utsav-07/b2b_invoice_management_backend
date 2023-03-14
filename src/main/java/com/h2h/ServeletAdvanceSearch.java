package com.h2h;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.AdvanceSearch;
import com.google.gson.Gson;
import com.poso.DataFields;

/**
 * Servlet implementation class ServeletAdvanceSearch
 */
@WebServlet("/ServeletAdvanceSearch")
public class ServeletAdvanceSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServeletAdvanceSearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.addHeader("Access-Control-Allow-Origin", "*");

		String doc_id , cust_number , buisness_year , invoice_id;
		HashMap<String, String> map = new HashMap<>();
		
		ArrayList<String> fields = new ArrayList<String>();
		
		fields.add("doc_id");
		fields.add("cust_number");
		fields.add("buisness_year");
		fields.add("invoice_id");
		
				
		
		
		for(int i=0;i<fields.size();i++) {
			String temp;
			
			temp = request.getParameter(fields.get(i));
			System.out.println(temp);
			if(temp.length()!=0 && temp != null) {
				map.put(fields.get(i), temp);
			}
		}
		
		System.out.println(map);
		
		AdvanceSearch advanceSearch = new AdvanceSearch();
		
		ArrayList<DataFields> allData = advanceSearch.AdvanceS(map);
		System.out.println("GE");
		response.getWriter().append(new Gson().toJson(allData)).flush();
	


	}

}
