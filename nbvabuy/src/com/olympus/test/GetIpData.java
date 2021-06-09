package com.olympus.test;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/getipdata")
public class GetIpData extends HttpServlet {
	/****************************************************************************************************************************************************/
	public static void displayDataMapStr(Map<String, String> map, String tag) {

		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("*** "  +  tag + "-- Key:" + entry.getKey() + " --> Value:" + entry.getValue() + "--");
		}
		System.out.println("*****************************************************************************************************");

	}
	/****************************************************************************************************************************************************/

	private Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {

        Map<String, String> rtnResult = new HashMap<>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            rtnResult.put(key, value);
        }

        return rtnResult;
    }
	
	/****************************************************************************************************************************************************/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String, String> result = new HashMap<>();

		result = getRequestHeadersInMap(request);
		displayDataMapStr(result, "DisplayResult");
		
	}
	/****************************************************************************************************************************************************/

	/****************************************************************************************************************************************************/

	

}
