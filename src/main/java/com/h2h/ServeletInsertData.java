package com.h2h;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.InsertData;
import com.poso.DataFields;

/**
 * Servlet implementation class ServeletInsertData
 */
@WebServlet("/ServeletInsertData")
public class ServeletInsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServeletInsertData() {
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
		// doGet(request, response);
		System.out.print("-----------------------hit");
		response.addHeader("Access-Control-Allow-Origin", "*");
		int sl_no, cust_number, posting_id, invoice_id, isOpen, is_deleted;
 
		String business_code, doc_id, invoice_currency, document_type, area_business, cust_payment_terms, aging_bucket = null;

		String baseline_create_date, clear_date, posting_date, document_create_date, document_create_date1, due_in_date , business_name , name_customer;
		int buisness_year;
		double total_open_amount;
		
//	
		sl_no = Integer.parseInt(request.getParameter("sl_no"));
		cust_number = Integer.parseInt(request.getParameter("cust_number"));
		posting_id = Integer.parseInt(request.getParameter("posting_id"));
		invoice_id = Integer.parseInt(request.getParameter("invoice_id"));
		isOpen = Integer.parseInt(request.getParameter("isOpen"));
		is_deleted = Integer.parseInt(request.getParameter("is_deleted"));
		business_code = request.getParameter("business_code");
		clear_date = request.getParameter("clear_date");
		buisness_year = Integer.parseInt(request.getParameter("buisness_year"));
		doc_id = request.getParameter("doc_id");
		posting_date = request.getParameter("posting_date");
		document_create_date = request.getParameter("document_create_date");
		document_create_date1 = request.getParameter("document_create_date1");
		due_in_date = request.getParameter("due_in_date");
		invoice_currency = request.getParameter("invoice_currency");
		document_type = request.getParameter("document_type");
		area_business = request.getParameter("area_business");
		cust_payment_terms = request.getParameter("cust_payment_terms");
		total_open_amount = Double.parseDouble(request.getParameter("total_open_amount"));
		baseline_create_date = request.getParameter("baseline_create_date");
		//aging_bucket = request.getParameter("aging_bucket");
		business_name = request.getParameter("business_name");
		name_customer = request.getParameter("name_customer");
		DataFields dataFields = new DataFields(sl_no, buisness_year, cust_number, posting_id, invoice_id, isOpen,
				is_deleted, business_code, doc_id, invoice_currency, document_type, area_business, cust_payment_terms,
				aging_bucket, baseline_create_date, clear_date, posting_date, document_create_date,
				document_create_date1, due_in_date, total_open_amount , business_name , name_customer);
		InsertData insertData = new InsertData();

		String result = insertData.Insert(dataFields);
		response.getWriter().print(result);

	}

}
