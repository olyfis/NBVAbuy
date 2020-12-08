<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

   <!-- 
<style><%@include file="includes/css/formCheck.css"%></style>
   <link rel="stylesheet" href="includes/css/formCheck.css" />
   -->
  <!--   Order is important for following lines. validator follows core lib -->

   
   
</head>
<body>
<h2>Registration</h2>

<form id="actionform" action="" method="post">
    <p>
      <label for="id">Name <span>(required, at least 15 characters)</span></label>
      <input id="id" name="id">
    </p>
  <p>
  <!-- 
      <label for="age">Your Age <span>(minimum 18)</span></label>
      <input id="age" name="age">
    </p>
    <p>
      <label for="email">E-Mail <span>(required)</span></label>
      <input id="email" name="email">
    </p>
  <p>
    <label for="weight">Weight <span>(required if age over 50)</span></label>
    <input id="weight" name="weight">
    </p>
      -->
    <p>
      <input class="submit" type="submit" value="SUBMIT">
    </p>
   
</form>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
 
    <script type="text/javascript" src="includes/js/validateID.js"></script>
</body>
</html>