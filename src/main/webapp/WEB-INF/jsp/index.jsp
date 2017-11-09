<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.onelogin.saml2.*,com.onelogin.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/
loose.dtd">
<html>    
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>IFBI SAML Integration POC - Home</title>
   </head>
   <body>
   		<a href="dologin?a1=de01" class="btn btn-primary">Login local</a>
   		<br><br><br>
   		<a href="http://192.168.32.19:9081/LifeEApps/ss.samldologin" class="btn btn-primary">Login Eapp</a>
   </body>
</html>

 