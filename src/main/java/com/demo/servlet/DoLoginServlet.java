package com.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onelogin.saml2.Auth;
import com.onelogin.saml2.exception.Error;
import com.onelogin.saml2.exception.SettingsException;

public class DoLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Auth auth;
		try {
			System.out.println("parameter: "+request.getParameter("a1"));
			auth = new Auth(request, response);
			if (request.getParameter("userId") == null) {
				auth.login();
			} else {
				/*
				 * If authendicated successfully, it will redirect to Eapp Inbox
				 * page
				 */
				String x = request.getPathInfo();
				auth.login("/Eapp_Saml/attrs.jsp");
			}
		} catch (SettingsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Error e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
