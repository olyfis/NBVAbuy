<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.io.OutputStream"%>   
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="com.olympus.olyutil.Olyutil"%>


<% 
  	String title =  "FIS NBVA error Page"; 
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> tokens = new ArrayList<String>();
	String formUrl =  (String) session.getAttribute("formUrl");
	String filePath = "C:\\Java_Dev\\props\\headers\\nbvakitHdr.txt";
	 ArrayList<String> headerArr = readHeader(filePath);
 
	ArrayList<String> list2 = new ArrayList<String>();
	list = (ArrayList<String>) session.getAttribute("strArr");
	HashMap<String, ArrayList<Integer>> errMap = new HashMap<String, ArrayList<Integer>>();
	errMap = ( HashMap<String, ArrayList<Integer>>) session.getAttribute("sqlErrMap");
	String commDate = (String) session.getAttribute("commDate");
	String termDate = (String) session.getAttribute("termDate");
	String effDate = (String) session.getAttribute("effDate");
	String naDate = (String) session.getAttribute("naDate");
	String errDate = (String) session.getAttribute("errDate");
	ArrayList<Integer> eMap = new ArrayList<>();
	String idErr = (String) session.getAttribute("id");
	String idVal = (String) session.getAttribute("id");
	String dateErr = (String) session.getAttribute("dateErr");
	String dateErr2 = (String) session.getAttribute("dateErr2");
	
	 //System.out.println("*** idErr=" + idErr + "-- errDate=" + errDate + "-- ID=" + idVal);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title><%=title%></title>
<style><%@include file="includes/css/header.css"%></style>
<style><%@include file="includes/css/table2.css"%></style>

<!-- ********************************************************************************************************************************************************* -->
</head>

<%!  
/*****************************************************************************************************************************************************************/
//String formUrl = null;
/*************************************************************************************************************************************************************/
public ArrayList<String> readHeader(String filePath) throws IOException {
	
	ArrayList<String> strArr = new ArrayList<String>();
	String header = null;
	BufferedReader reader = null;
	StringBuilder sb = null;
	String line = null;
	try {
	 	reader = new BufferedReader(new FileReader(filePath));
    	 sb = new StringBuilder();
    
	} catch (FileNotFoundException fex) {
		fex.printStackTrace();	
	}
	try { 
	    while((line = reader.readLine())!= null){
	    	strArr.add(line);
	    }	   
		reader.close();
	
	} catch (IOException ioe) {
		ioe.printStackTrace();
	}
	
	return strArr;	
}
/*************************************************************************************************************************************************************/
public String  buildHeader( JspWriter out2, ArrayList<String> dataArr   ) throws IOException {
	
	String header = "";
	String style = "b3";
	if (dataArr.size() > 0) {
		for (int k = 0; k < dataArr.size(); k++) {
			
			if (k == 1) {
				style = "b3a";
			} else {
				style = "b3";
			}
			header += "<th class=\" " + style + "  \" >" + dataArr.get(k) + " </th>";	
		}
	}
	return header;
}
/*************************************************************************************************************************************************************/

/*************************************************************************************************************************************************************/
public String  buildCells(JspWriter out, ArrayList<String> dataArr  ) throws IOException {
	String cells = "";
	String xDataItem = null;
	String color1 = "plum";
	String style1 = "font-family: sans-serif; color: white;";
	String rowEven = "#D7DBDD";
	String rowOdd = "AEB6BF";
	String excel = null;
	String rowColor = null;
	int errCode = 0;

	if (dataArr.size() > 0) {
		for (int k = 0; k < dataArr.size(); k++) {
			rowColor = (k % 2 == 0) ? rowEven : rowOdd;
			cells +="<tr bgcolor=" + rowColor + ">";
			xDataItem = dataArr.get(k);
			String token_list[] = xDataItem.split(",");
			for (int x = 0; x < token_list.length; x++) {
				cells += "<td class=\"b3\">" + token_list[x] + "</td>";
			}
			cells += "</tr >";
		}
	}
	return cells;
}
%>

<!-- ********************************************************************************************************************************************************* -->



<body>
    
    
 <%@include  file="includes/header.html" %>
 
  <h3><%=title%></h3>
 
<BR>
<!--   <h5>This page will provide an on-demand...  </h5> -->

<%
 		
%>
<BR>
<!--  action = servlet to call: http://localhost:8181/reports/olrent?id=2019-08-31   -->	 
 <!-- ************************* Inner Table ****************************************************************************** -->
 <!-- 
    <table  border="0"  width="10%"    >
  <tr>
 
    <td  valign="bottom"  >
    <form name="excelForm" enctype="multipart/form-data" method="get" action="<%=formUrl%> " \> 
    <input type="submit" value="Save Excel File" class="btn" /> 
    </form> 
	</td> 
   </tr></table>
    <!-- ****************************************************************************************************************************** -->
   <!--    
    </td>
  </tr>
</table> -->
	<div style="height: 500px; overflow: auto;">
<%

/*
out.println("<table  border=\"1\"> <thead> <tr>");
String header = buildHeader(out, headerArr); // build header from file
out.println(header);
out.println("</tr></thead>");
out.println("<tbody id=\"report\">");
String cells =  buildCells(out, list); // build data cells from file
out.println(cells);
out.println("</tbody></table>"); // Close Table

*/
if ( ! (Olyutil.isNullStr(dateErr))) {
	out.println("<h5>(Error: -37 -- ID=" +  dateErr   + " -- The Commencement Date could not be found for this ID </h5><BR>");
}

if ( ! (Olyutil.isNullStr(dateErr2))) {
	out.println("<h5>(Error: -35 -- " +  dateErr2   + "</h5><BR>");
}

if (errMap != null ) {
	if (errMap.size() > 0) {
		out.println("<h5>The following errors occurred.</h5><BR>");
		
		
		if (errMap.containsKey(idVal)) {
			 eMap = errMap.get(idVal);
	 
			int k = 0;
			int sz = eMap.size();
			//out.println("<h5>eMapSZ=" + sz +  "  -- EM="  + eMap.get(0)  +  "</h5>");
			 
			 
			for (k = 0; k < sz; k++) {
				
				System.out.println("**^^** Err=" + eMap.get(k) + "--");
			 	if (eMap.get(k) == -1) {
			 		out.println("<h5> (Error:" + eMap.get(k) +  " -- ID=" +  idVal   + ") The Effective date (<B>" +  effDate +   "</B>) occurs before the Commencement date (<B>" + commDate   + "</B>).</h5><BR>");
			 	}
				if (eMap.get(k) == -2) {
					out.println("<h5>(Error:" + eMap.get(k) +  "  -- ID=" +  idVal   + ") The day component (</B>yyyy-mm-<b>dd</b>) of the Effective date (<B>" +  effDate +   "</B>) does not match the Commencement date (<B>" + commDate   + ").</h5><BR>");
			 	}
			 	
				if (eMap.get(k) == -5) {
					out.println("<h5>(Error:" + eMap.get(k) +  " -- ID=" +  idVal   + ") The contract is no longer invoicing. </h5><BR>");
				}
				
				if (eMap.get(k) == -10) {
					out.println("<h5>(Error:" + eMap.get(k) +  " -- ID=" +  idVal   + ") The contract cannot have a Status Code set to \"<B>03</B>\" </h5><BR>");
				}
				if (eMap.get(k) == -15) {
					out.println("<h5>(Error:" + eMap.get(k) +  " -- ID=" +  idVal   + ") The Effective Date was not entered. </h5><BR>");
				}
				if (eMap.get(k) == -25) {
					out.println("<h5>(Error:" + eMap.get(k) +  " -- ID=" +  idVal   + ") The Next Aging Date (" + naDate+ ") is less than the Effective Date (" + effDate + "). </h5><BR>");
				}
				
				
				 
				
			}
		}
		//errMap.clear();
		
	}
}
      %>

 
</div>
</body>
</html>