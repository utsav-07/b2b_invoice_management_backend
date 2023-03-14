package com.h2h;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.UpdateData;
import com.poso.DataFields;

/**
 * Servlet implementation class ServeletUpdateData
 */
@WebServlet("/ServeletUpdateData")
public class ServeletUpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletUpdateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.addHeader("Access-Control-Allow-Origin", "*");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.addHeader("Access-Control-Allow-Origin", "*");
		
	

		 int sl_no;
		 String cust_payment_terms , invoice_currency;
		 cust_payment_terms = request.getParameter("cust_payment_terms");
		 invoice_currency = request.getParameter("invoice_currency");
		 sl_no = Integer.parseInt((request.getParameter("sl_no")));
	
		 DataFields dataFields = new DataFields(sl_no ,cust_payment_terms ,invoice_currency );
		 
		 UpdateData updateData = new UpdateData();
		 
		 String result = updateData.Update(dataFields);
		 response.getWriter().print(result);
		 
		
	}

}
