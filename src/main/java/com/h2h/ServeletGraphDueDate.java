package com.h2h;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.DeleteData;
import com.crud.GraphDueDate;
import com.google.gson.Gson;
import com.poso.DataFields;

/**
 * Servlet implementation class ServeletGraphDueDate
 */
@WebServlet("/ServeletGraphDueDate")
public class ServeletGraphDueDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServeletGraphDueDate() {
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
		response.addHeader("Access-Control-Allow-Origin", "*");
		GraphDueDate graphDueDate = new GraphDueDate();
		HashMap<String, String> map = new LinkedHashMap<>();
		ArrayList<String> fields = new ArrayList<String>();

		fields.add("start_due_in_date");
		fields.add("end_due_in_date");
		fields.add("start_clear_date");
		fields.add("end_clear_date");
		fields.add("start_baseline_create_date");
		fields.add("end_baseline_create_date");
//		fields.add("invoice_currency");
//		fields.add("CAD");
//		fields.add("USD");
		for (int i = 0; i < fields.size(); i = i + 2) {
			if (i < 5) {

				String temp, temp1;
				temp = request.getParameter(fields.get(i));
				temp1 = request.getParameter(fields.get(i + 1));
				if (temp.length() != 0 && temp1.length() != 0) {

					String finalTemp = temp + " " + temp1;

					String f = fields.get(i);
					int len = f.length();
					if (f.charAt(0) == 's') {
						f = f.substring(6, len);

					} else {
						f = f.substring(4, len);
					}

					if (finalTemp.length() != 0) {
						map.put(f, finalTemp);
					}
				}
			} else {
				break;
			}

		}

		String invoice = request.getParameter("invoice_currency");
		if (invoice.length() != 0) {
			String[] strSplit = invoice.split(" ");

			ArrayList<String> store = new ArrayList<String>(Arrays.asList(strSplit));
			String temp1 = "";
			for (String s : store) {
				String temp = (String.valueOf(s));
				temp1 = temp1 + temp +" ";

				// map.put("invoice_currency", temp);

			}
			map.put("invoice_currency", temp1);
		}

		// String startDate = "2019-05-21" ;
		//String startDate = request.getParameter("start_date");
	//	String endDate = "2019-09-23";
		// String endDate = request.getParameter("end_date");

		ArrayList<DataFields> allData = graphDueDate.getData(map);
		Gson gson = new Gson();
		String respData = gson.toJson(allData);
		System.out.println(respData);
		response.getWriter().print(respData);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
