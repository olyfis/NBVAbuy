<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.io.OutputStream"%>   
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="com.olympus.dateutil.DateUtil"%>
<%@ page import="com.olympus.olyutil.*"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*, com.olympus.olyutil.*" %>
    
    <%@ page import="java.time.format.DateTimeFormatter"%>
    <%@ page import="java.sql.*"%>
    
    <% 
	String title =  "Olympus NBVA Buyout Letter"; 	 
	ArrayList<String> tokens = new ArrayList<String>();
	String formUrl =  (String) session.getAttribute("formUrl");
	
	String currDate = java.time.LocalDate.now().toString();
	//System.out.println("** CurrDate=" + currDate);
	 /*
 
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	String newDate = DateUtil.getNewEffectiveDate("2020-03-10");
 
	System.out.println("*** NewEffectiveDate=" + newDate );
	*/
%>
<%!

 
  String propFile = "C:\\Java_Dev\\props\\unidata.prop";
  ArrayList<String> dateArr = new ArrayList<String>();

//static String sqlFile = "C:\\Java_Dev\\props\\sql\\NBVAassetList_V4.sql";
//static String hdrFile = "C:\\Java_Dev\\props\\headers\\NBVA_Hdr_V4.txt";

 String sqlFile = "C:\\Java_Dev\\props\\sql\\NBVAbuy\\NBVA_assetBuy_getCommDate.sql";
  
  
  
 //System.out.println("**** Load Driver");
 
	 
	public ArrayList<String> getDbData(String id, String sqlQueryFile) throws IOException {
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
 
	
%>
    
    
<% 
 
String id = request.getParameter("id");
System.out.println("***ID=" + id + "--");

dateArr = getDbData(id, sqlFile);
 //Olyutil.printStrArray(dateArr);
	String[] strSplitArr = Olyutil.splitStr(dateArr.get(0), ";");
	//System.out.println("*** ARR=" + strSplitArr[0] + "--");
	
	String commDate_t = strSplitArr[0];
	String commDate = DateUtil.getNewEffectiveDate(commDate_t);
	 
	//System.out.println("*** NewEffectiveDate=" + commDate );
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
 
<!--  	
http://cvyhj3a27:8181/nbvaupdate/nbvaupdate?id=101-0010311-004&eDate=2020-03-10&boDate=2020-03-31&invoice=123123123

101-0009442-019-->

<title><%=title%></title>


<!--  <link href="includes/appstyle.css" rel="stylesheet" type="text/css" /> 

<style><%@include file="includes/css/reports.css"%></style>
<style><%@include file="includes/css/table.css"%></style>
-->
<style><%@include file="includes/css/header.css"%></style>
<style><%@include file="includes/css/menu.css"%></style>
 <link rel="stylesheet" href="includes/css/calendar.css" />
    <script type="text/javascript" src="includes/scripts/pureJSCalendar.js"></script>



<!-- ********************************************************************************************************************************************** -->


<!-- ********************************************************************************************************************************************** -->

<script language="javascript" type="text/javascript">
 
//Browser Support Code
function ajaxFunction(){
	var ajaxRequest;  // The variable that makes Ajax possible!
	
	try{
		// Opera 8.0+, Firefox, Safari
		ajaxRequest = new XMLHttpRequest();
	} catch (e){
		// Internet Explorer Browsers
		try{
			ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try{
				ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e){
				// Something went wrong
				alert("Your browser broke!");
				return false;
			}
		}
	}
	// Create a function that will receive data sent from the server
	ajaxRequest.onreadystatechange = function(){
		if(ajaxRequest.readyState == 4){
			var ajaxDisplay = document.getElementById('ajaxDiv');
			ajaxDisplay.innerHTML = ajaxRequest.responseText;
		// document.actionform.actiontypeprogram.value = ajaxRequest.responseText;

		}
	}

//	var atype = document.actionform.getElementById('actiontype').value;
	var atype = document.actionform.actiontype.value;
	var date2 = document.actionform.startDate.value;
	//alert("atype=" + atype);
	
	//alert("date2=" + date2);
	//var queryString = "?atype=" + atype + "&wpm=" + wpm + "&ex=" + ex;
	var queryString = "/webreport/ajaxIL.jsp?atype=" + atype + "&date2=" + date2;
	

	  
	//alert("QS=" + queryString);
	//ajaxRequest.open("GET", "ajax.jsp" + queryString, true);
	ajaxRequest.open("POST", queryString, true);
	ajaxRequest.send(); 
}

 
</script>





<!-- ********************************************************************************************************************************************************* -->

</head>
<body>
    
    
 <%@include  file="includes/header.html" %>


<%-- Req for Salesforce Ajax menu 
<jsp:include page="/sfquery" flush="true" /> --%>
<c:out value="${strArrID}"></c:out>
 
  <c:forEach items="${strArrID}" var="id">
            ${id.id} <br />
        </c:forEach>
        
<!--   <img src="includes\images\logo.jpg" alt="logo"  height="100" width="225" align="right"> -->


<div style="padding-left:20px">

</div>

<BR>
<h5>This page will provide an on-demand NBVA Asset List Report.</h5>
<h5>Enter a valid contract ID and get a list of assets associated with that contract..</h5>




 
</h5>

<BR>


	<!--   <form name="actionform" method="get" action="nbvabuy" name=id'>  -->
<form id="actionform" name="actionform" method="post" enctype="multipart/form-data" action="nbvabuyout"   > 
<BR>


<table class="a" width="40%"  border="1" cellpadding="1" cellspacing="1">
<tr> <th class="theader"> <%=title%></th> </tr>
  <tr>
    <td class="table_cell">
    <!--  Inner Table -->
    <table class="a" width="100%"  border="1" cellpadding="1" cellspacing="1">
  <tr>
 
  <td width="60" valign="bottom"> <b>Enter Contract Number:</b> </td> 
  <td width="20" valign="bottom">  
     <% // out.println("<input name=\"startDate\" id=\"date2\" type=\"text\" value=\"Click for Calendar\" onclick=\"pureJSCalendar.open('yyyy-MM-dd', 20, 30, 7, '2017-1-1', '2025-12-31', 'date2', 20)\"   />" );
     %>
    <!--  <CENTER>  <input name="id" type="text"  value="101-0009442-019" /> </CENTER>  -->
      <CENTER>  <input name="id" type="text"  value=<%=id%> /> </CENTER>
     
  </td>
  </tr>
 <!--   
   <tr>
  <td width="20" valign="bottom"> <b>Action:</b> </td> 
  <td width="20" valign="bottom">  
      
        <select name="actiontype" onchange='ajaxFunction()' >
          <option value="0">Select Action</option>
		  <option value="15">Retrieve Contract IDs</option>    
        </select>
   
  </td>
  </tr>
  -->
   <!-- ********************************************************************************************************************************************************* -->
 <!--    <tr>
  <td width="60" valign="bottom"> <b>RollOver:</b> </td> 
  <td width="20" valign="bottom"> 
   <center>
      <select name="rotype"  >
          <option value="0">Select Action</option>
		  <option value="10">Rollover Yes</option>    
		  <option value="20">Rollover No</option>    
        </select>
        </center>
  
   </td>
  </tr>
  -->
  <!-- ********************************************************************************************************************************************************* -->
  
   <tr>
  <td width="60" valign="bottom"> <b>Effective Date: ( <font color="red">Later than: <%=currDate%> </font>)</b> </td> 
  <td width="20" valign="bottom"> 
   <center>
   <% out.println("<input name=\"eDate\" id=\"date2\" type=\"text\" value=\" " +     commDate  + "  \"   onclick=\"pureJSCalendar.open('yyyy-MM-dd', 20, 30, 7, '2017-1-1', '2025-12-31', 'date2', 20)\"   />" );
     %>
   </center>
  
   </td>
  </tr>
  <!--  
  <tr>
  <td width="20" valign="bottom"> <b>Buyout Date:</b> </td> 
  <td width="20" valign="bottom"> 
   <center>
   <% out.println("<input name=\"boDate\" id=\"date3\" type=\"text\" value=\"Click for Calendar\" onclick=\"pureJSCalendar.open('yyyy-MM-dd', 20, 30, 7, '2017-1-1', '2025-12-31', 'date3', 20)\"   />" );
     %>
   </center>
  
   </td>
  </tr>
  -->
  <!-- ********************************************************************************************************************************************************* -->
		    <!--   
		     <tr>
		  <td width="20" valign="bottom"> <b>Enter Invoice Number:</b> </td> 
		  <td width="20" valign="bottom">  
		      <CENTER>  <input name="invoice" type="text"   /> </CENTER>
		  </td>
		  </tr>
		  --> 
      <!-- ********************************************************************************************************************************************************* -->
   <!--  
      <tr>
  <td width="20" valign="bottom"> <b>Select Disposition Code Update File:</b> </td> 
  <td width="20" valign="bottom">  
      <CENTER>  <input type="file" name="file" size="25" />
     
      </CENTER>
  </td>
  </tr>
     
     -->
     
     <!-- ********************************************************************************************************************************************************* -->
     
     
     <tr>
  <td width="20" valign="bottom" COLSPAN="2">  &nbsp</td> 
   
  </tr>
  
  <!-- ********************************************************************************************************************************************************* -->
  
  
  <tr>
   <td  valign="bottom" class="a" COLSPAN="2" >
	<div id='ajaxDiv'> </div>
	<!--  </td>
	
	   <td> 
	  --> 
	 <CENTER> 
    <INPUT type="submit" value="Submit">  
     <input type="reset" value="Clear"/>
     </CENTER>
     </td>  
	
  </tr>
  </table>

</table>

 </form>
<h5>If you require access to the reports, please contact: John.Freeh@olympus.com</h5>
<h5>Note: <font color="red">Requires Javascript to be enabled.</font> <BR>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
 
    <script type="text/javascript" src="includes/js/validateID.js"></script>
</body>
</html>