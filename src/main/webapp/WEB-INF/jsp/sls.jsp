<%@page import="com.onelogin.saml2.Auth,java.util.Map,java.util.Collection,java.util.HashMap,java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <meta charset="utf-8">
	 <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <meta name="viewport" content="width=device-width, initial-scale=1">
	 <title>IFBI SAML Integration POC - Sign Out </title>
	 <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
    	<h1>IFBI SAML Integration POC</h1>
    	<b>Logout</b>   	
	<%
		Auth auth = new Auth(request, response);
		auth.processSLO();
		
		List<String> errors = auth.getErrors();
		
		if (errors.isEmpty()) {
			out.println("<p>Sucessfully logged out</p>");
			out.println("<a href=\"dologin\" class=\"btn btn-primary\">Login</a>");
		} else {
			out.println("<p>");
			for(String error : errors) {
				out.println(" " + error + ".");
			}
			out.println("</p>");
		}
	%>
	</div>
</body>
</html>
