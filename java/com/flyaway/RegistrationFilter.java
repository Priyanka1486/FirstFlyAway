package com.flyaway;

import java.util.regex.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

public class RegistrationFilter implements Filter {

	public void init(FilterConfig filterconfig) {
		
	}
	
	public boolean validationCheckForFields(String value,String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		if(matcher.matches())
			return true;
		return false;		
	}
	
	public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain)
	throws ServletException, IOException {
		
		String firstName = request.getParameter("fname");
		String lastName  = request.getParameter("lname");
		String email =	request.getParameter("email");
		String password =request.getParameter("password");
		String confirmPassword = request.getParameter("confirmpassword");
		boolean proceedFlag = false;
		boolean flag = false;
		String regex;
		PrintWriter out = response.getWriter();
		
		if((firstName != null) && (firstName.isEmpty()==false)) { 
			regex = "[A-za-z]";
			flag = validationCheckForFields(firstName,regex);
			if(flag==false) 	
				out.println("Please enter alphabets");
			else 
				proceedFlag = true;
		}
		if((lastName != null) && (lastName.isEmpty()==false)) { 
			regex = "[A-za-z]";
			flag = validationCheckForFields(lastName,regex);
			if(flag==false)
				out.println("Please enter alphabets");
			else 
				proceedFlag = true;
		}
		if((email != null) && (email.isEmpty()==false)) { 
			regex = "[A-za-z]";
			flag = validationCheckForFields(email,regex);
			if(flag==false)
				out.println("Please enter valid email");
			else 
				proceedFlag = true;
		}
		if((password != null) && (password.isEmpty()==false)) { 
			regex = "[A-za-z0-9]";
			flag = validationCheckForFields(password,regex);
			if(flag==false)
				out.println("Follow the Password format");			
			else 
				proceedFlag = true;
		}	
		if((confirmPassword != null) && (confirmPassword.isEmpty()==false)) { 
			regex = "[A-za-z0-9]";
			flag = validationCheckForFields(confirmPassword,regex);
			if(flag==false)
				out.println("Follow the Password format");
			else 
				proceedFlag = true;
		}
		
		if(proceedFlag) {
			if(password.equals(confirmPassword)) {
				System.out.println("I am in Registration Filter");
				chain.doFilter(request, response);
			}else {
				out.println("Password mismatch");
				RequestDispatcher rd =  request.getRequestDispatcher("register");
				rd.forward(request, response);
			}  
		}else {
		//	HttpServletResponse res = (HttpServletResponse)response;
		//	res.sendRedirect("register");
			RequestDispatcher rd =  request.getRequestDispatcher("register");
			rd.forward(request, response);
		}
		
	}
}
