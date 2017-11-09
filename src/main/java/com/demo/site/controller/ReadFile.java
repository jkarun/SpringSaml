package com.demo.site.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//readFile1();
		readFile2();
		
	}
	
	public static void readFile1() {
		Properties prop = new Properties();
		InputStream input = null;
	
		try {
 
			input = new FileInputStream("C:\\Users\\sudhakarr\\Desktop\\onelogin.saml.properties");

			prop.load(input);

			System.out.println(prop.getProperty("onelogin.saml2.idp.single_logout_service.url"));
			System.out.println(prop.getProperty("onelogin.saml2.sp.privatekey"));

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void readFile2() throws IOException {
		
		FileInputStream is = null;
		try {

	        FileInputStream fis;
			try {
				/*fis = new FileInputStream("C:\\Users\\sudhakarr\\Desktop\\Centrify_SHA256_Signing_Certificate.cer");
			
	        BufferedInputStream bis = new BufferedInputStream(fis);
	        CertificateFactory cf = CertificateFactory.getInstance("X.509");
	        while (bis.available() > 0) {
	           Certificate cert = cf.generateCertificate(bis);
	           System.out.println(cert.toString());
	        }*/
	        
	        
	        FileInputStream fis1 = new FileInputStream("C:\\Users\\arunprasathk\\Desktop\\privatekey.txt");
	        CertificateFactory cf1 = CertificateFactory.getInstance("X.509");
	        Collection c = cf1.generateCertificates(fis1);
	        Iterator i = c.iterator();
	        while (i.hasNext()) {
	           Certificate cert = (Certificate)i.next();
	           System.out.println(cert);
	        }
	        
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    } catch (java.security.cert.CertificateException e) {
	        e.printStackTrace();
	    } 
	}

}

