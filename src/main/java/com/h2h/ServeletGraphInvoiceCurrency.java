package com.h2h;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.FetchData;
import com.crud.GraphInvoiceCurrency;
import com.google.gson.Gson;
import com.poso.DataFields;

/**
 * Servlet implementation class ServeletGraphInvoiceCurrency
 */
@WebServlet("/ServeletGraphInvoiceCurrency")
public class ServeletGraphInvoiceCurrency extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletGraphInvoiceCurrency() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		GraphInvoiceCurrency graphInvoiceCurrency = new GraphInvoiceCurrency();
		HashMap<Object , Object> allData = graphInvoiceCurrency.getData();
		Gson gson = new Gson(); 
		String respData = gson.toJson(allData);
		//System.out.print(respData);
		response.getWriter().print(respData);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
