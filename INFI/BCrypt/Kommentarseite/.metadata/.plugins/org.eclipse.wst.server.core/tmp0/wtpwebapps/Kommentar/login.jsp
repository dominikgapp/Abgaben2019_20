
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body bgcolor="#FAE5D3">

<h3>Login</h3>

<% 
String msg = (String) request.getAttribute("MSG"); 
if (msg != null){
	out.append("<p style = 'color: red;'>" + msg + "</p>"); 
}
%>

<form method="post" action ="Servlet"> 

<input type ="text" placeholder="enter username" name = "username">
<input type ="password" placeholder="password" name = "password">  

<button type = "submit">Login</button>

</form>
<br></br>

<a href="registrieren.jsp">Registrieren </a>

</body>
</html>