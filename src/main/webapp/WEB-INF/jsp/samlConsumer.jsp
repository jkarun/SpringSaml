<%@page
	import="com.onelogin.saml2.Auth,com.onelogin.saml2.servlet.ServletUtils,java.util.Collection,java.util.HashMap,
	java.util.List,java.util.Map,org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>IFBI SAML Integration POC - ACS</title>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<h1>IFBI SAML Integration POC - Assertion Consumer Service</h1>

		<!--  TODO Session support  -->

		<%
			Auth auth = new Auth(request, response);
			auth.processResponse();

			if (!auth.isAuthenticated()) {
				out.println("<div class=\"alert alert-danger\" role=\"alert\">Not authenticated</div>");
			}

			List<String> errors = auth.getErrors();

			if (!errors.isEmpty()) {
				out.println("<p>" + StringUtils.join(errors, ", ") + "</p>");
				if (auth.isDebugActive()) {
					String errorReason = auth.getLastErrorReason();
					if (errorReason != null && !errorReason.isEmpty()) {
						out.println("<p>" + auth.getLastErrorReason() + "</p>");
					}
				}
				out.println("<a href=\"dologin\" class=\"btn btn-primary\">Login</a>");
			} else {
				Map<String, List<String>> attributes = auth.getAttributes();
				String nameId = auth.getNameId();

				session.setAttribute("attributes", attributes);
				session.setAttribute("nameId", nameId);

				 Collection<String> keys1 = attributes.keySet();
					for(String name :keys1)
					{
						System.out.println(name);
						if(name.equalsIgnoreCase("userId")){
							List<String> values = attributes.get(name);
							for(String value :values) {
								System.err.println(value);
								session.setAttribute("userId", value);
							}
						}
						if(name.equalsIgnoreCase("pwd")){
							List<String> values = attributes.get(name);
							for(String value :values) {
								System.err.println(value);
								session.setAttribute("password", value);
							}
						}
					} 
				
				String relayState = request.getParameter("RelayState");

				if (relayState != null && relayState != ServletUtils.getSelfRoutedURLNoQuery(request)
						&& !relayState.contains("/dologin")) { // We don't want to be redirected to login.jsp neither
					response.sendRedirect(request.getParameter("RelayState"));
				} else {

					if (attributes.isEmpty()) {
		%>
		<div class="alert alert-danger" role="alert">You don't have any
			attributes</div>
		<%
			} else {
		%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Values</th>
				</tr>
			</thead>
			<tbody>
				<%
					Collection<String> keys = attributes.keySet();
								for (String name : keys) {
									out.println("<tr><td>" + name + "</td><td>");
									List<String> values = attributes.get(name);
									for (String value : values) {
										out.println("<li>" + value + "</li>");
									}

									out.println("</td></tr>");
								}
				%>
			</tbody>
		</table>
		<%
			}
		%>
		<!-- <a href="attrs" class="btn btn-primary">See user data stored
			at session</a>  -->
		<a href="dologout" class="btn btn-primary">Logout</a>
		<%
			}
			}
		%>
	</div>
</body>
</html>
