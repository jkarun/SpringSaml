package com.demo.site.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onelogin.saml2.Auth;
import com.onelogin.saml2.exception.Error;
import com.onelogin.saml2.exception.SettingsException;
import com.onelogin.saml2.exception.XMLEntityException;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}

	@RequestMapping("/dologin")
	public String signIn(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SettingsException, Error {

		return "dologin";
	}

	@RequestMapping("/samlConsumer")
	public String samlConsumer() {
		return "samlConsumer";
	}

	@RequestMapping(value = "/dologout", produces = "text/html; charset=UTF-8")
	public String signOut(HttpServletRequest request, HttpServletResponse response)
			throws IOException, XMLEntityException, SettingsException, Error {
		return "dologout";
	}

	@RequestMapping(value = "/sls", produces = "text/html; charset=UTF-8")
	public String signOutConsumer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "sls";
	}
	
	@RequestMapping(value = "/dologin", produces = "text/html; charset=UTF-8")
	public void dologin(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			e.printStackTrace();
		} catch (Error e) {
			e.printStackTrace();
		}
	}
}
