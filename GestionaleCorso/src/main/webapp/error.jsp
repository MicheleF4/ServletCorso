<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Error Manager</title>
</head>
<body>
 <center>
  <h1>Errore, mpaddasti!</h1>
  <h2 style="color: red"><%=exception.getMessage() %><br/></h2>
 </center> 
</body>
</html>