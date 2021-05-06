package com.olympus.nbvabuy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.tuple.Pair;

import com.olympus.dateutil.DateUtil;
import com.olympus.nbva.assets.AssetData;
import com.olympus.nbva.contracts.ContractData;
import com.olympus.olyutil.Olyutil;
@WebServlet("/getdateparam")

public class GetdateParam extends HttpServlet {
	/****************************************************************************************************************************************************/

	
	public ArrayList<String> getDbData(String id, String sqlQueryFile) throws IOException {
		String propFile = "C:\\Java_Dev\\props\\unidata.prop";  
		 Statement stmt = null;
		  Connection con = null;
		  ResultSet res  = null;
		 
		  String s = null;
		  PreparedStatement statement;
		String commDate = "";
		FileInputStream fis = null;
		FileReader fr = null;
		 
		String sep = "";
    StringBuffer sb = new StringBuffer();
    ArrayList<String> strArr = new ArrayList<String>();
		try {
			fis = new FileInputStream(propFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties connectionProps = new Properties();
		connectionProps.load(fis);
		fr = new FileReader(new File(sqlQueryFile));	
		// be sure to not have line starting with "--" or "/*" or any other non alphabetical character
		BufferedReader br = new BufferedReader(fr);
		while((s = br.readLine()) != null){
		      sb.append(s);       
		}
		br.close();
		//displayProps(connectionProps);
		String query = new String();
		query = sb.toString();	
		//System.out.println( query);	 
		try {
			con = Olyutil.getConnection(connectionProps);
			if (con != null) {
				//System.out.println("Connected to the database");
				statement = con.prepareStatement(query);
				//System.out.println("***^^^*** contractID=" + contractID);
				statement.setString(1, id);
				sep = ";";	 
				res = Olyutil.getResultSetPS(statement);		 	 
				strArr = Olyutil.resultSetArray(res, sep);			
			}		
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return strArr;
	}
	/*******************************************************************************************************************************************/
/*	// fmt "yyyy-MM-dd"
	// Invoke: String date2 = dateShift("2020-10-20", "yyyy-MM-dd","MM-dd-yyyy", -10);
	public static String dateShift(String origDate, String fmtIn, String fmtOut, int offset) {
 
		DateTimeFormatter formatterIn = DateTimeFormatter.ofPattern(fmtIn);
		DateTimeFormatter formatterOut = DateTimeFormatter.ofPattern(fmtOut);
		LocalDate modDate = LocalDate.parse(origDate, formatterIn);
		LocalDate newDate = modDate.plusDays(offset);
		String rtnStr = formatterOut.format(newDate);
		
		return (rtnStr);
	}
	
	*/
/*******************************************************************************************************************************************/
	// fmt "yyyy-MM-dd"
		// Invoke: String date2 = dateShift("2020-10-20", "yyyy-MM-dd","MM-dd-yyyy", -10);
		public static String dateShift(String origDate, String fmtIn, String fmtOut, int offset) {
	 
			DateTimeFormatter formatterIn = DateTimeFormatter.ofPattern(fmtIn);
			DateTimeFormatter formatterOut = DateTimeFormatter.ofPattern(fmtOut);
			LocalDate modDate = LocalDate.parse(origDate, formatterIn);
			LocalDate newDate = modDate.plusDays(offset);
			String rtnStr = formatterOut.format(newDate);
			
			return (rtnStr);
		}
/****************************************************************************************************************************************************/
	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String dispatchJSP = "/nbvaprocess.jsp";
		HttpSession session = request.getSession(true);
		ArrayList<String> dateArr = new ArrayList<String>();
		String sqlFile = "C:\\Java_Dev\\props\\sql\\NBVAbuy\\NBVA_assetBuy_getCommDate_V2.sql";
	 
		
		// String s1 = (String) session.getAttribute("JB");
		// String dispCoveVals = request.getParameter("dispCodeArr_0");
		String id = request.getParameter("id");
		
		//System.out.println("**!!** ID=" + id + "--");
		dateArr = getDbData(id.trim(), sqlFile);
		if(dateArr.size() > 0) {
			//Olyutil.printStrArray(dateArr);
			String[] strSplitArr = Olyutil.splitStr(dateArr.get(0), ";");
			//System.out.println("*** ARR=" + strSplitArr[0] + "--");
			
			String commDate_t = strSplitArr[0];
			String newEffDate = strSplitArr[1];
			
			
			String date2 = DateUtil.dateShift(newEffDate, "yyyy-MM-dd", "yyyy-MM-dd", 30);
			
	
		 //System.out.println("**!!** ID=" + id + "--CD="  + commDate_t  +  "--NewEffDate="  + newEffDate  + "--D2=" + date2 + "--");
			String commDate = "";
			try {
				commDate = DateUtil.getNewEffectiveDate(commDate_t);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 //System.out.println("**!!** ID=" + id + "--CD_T="  + commDate_t  +  "--CommDate="   + commDate + "--NewEffDate="  + newEffDate  + "--D2=" + date2 + "--");

			//String datePlus30 = dateShift(newEffDate, "yyyy-MM-dd","yyyy-MM-dd", 30);
			
			//System.out.println("*** NewEffectiveDate=" + commDate + "-- NewEffDate="   + newEffDate  +  "--D+30="   + datePlus30  + "--");
			System.out.println("*** NewEffectiveDate=" + commDate + "-- NewEffDate="   + newEffDate  +  "--");
			request.getSession().setAttribute("commDateOrig", newEffDate);
		request.getSession().setAttribute("commDate", commDate);
		//request.getSession().setAttribute("newEffDate", newEffDate);
		
		request.getSession().setAttribute("newEffDate", commDate); // Fixed 2021-04-16 date bump 30 days
			
		} else { // date not found for ID
			dispatchJSP = "/nbvaerror.jsp";
			request.getSession().setAttribute("dateErr", "dateErr");
			//request.getSession().setAttribute("idVal2", id);
		}
		
		request.getSession().setAttribute("id", id);
		 
		request.getRequestDispatcher(dispatchJSP).forward(request, response);
 
	}  

	/****************************************************************************************************************************************************/
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
					
		
		
	}
	 
}