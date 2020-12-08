<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.io.OutputStream"%>   
<%@ page import="java.io.File"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*, com.olympus.olyutil.*" %>


<%@ page import="java.sql.*"%>


<% 
  	 String title =  "Olympus FIS Run SQL Test"; 	 




%>



<%!
public void readHeader(String filePath) throws IOException {
	
	
}
  Statement stmt = null;
  Connection con = null;
  ResultSet res  = null;
 
  String s = null;
  PreparedStatement statement;
  String propFile = "C:\\Java_Dev\\props\\unidata.prop";
  ArrayList<String> dateArr = new ArrayList<String>();

//static String sqlFile = "C:\\Java_Dev\\props\\sql\\NBVAassetList_V4.sql";
//static String hdrFile = "C:\\Java_Dev\\props\\headers\\NBVA_Hdr_V4.txt";

 String sqlFile = "C:\\Java_Dev\\props\\sql\\NBVAbuy\\NBVA_assetBuy_getCommDate.sql";
  
  
  
 //System.out.println("**** Load Driver");
 
	 
	public ArrayList<String> getDbData(String id, String sqlQueryFile) throws IOException {
		String commDate = "";
		FileInputStream fis = null;
		FileReader fr = null;
		String s = new String();
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

dateArr = getDbData("101-0010311-004", sqlFile);
 Olyutil.printStrArray(dateArr);
	String[] strSplitArr = Olyutil.splitStr(dateArr.get(0), ";");
	System.out.println("*** ARR=" + strSplitArr[0] + "--");
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>