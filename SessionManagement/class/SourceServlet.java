package com.nelson.trainings.servlets.sm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws IOException{
		
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i = 0; i < cookies.length ; i++) {
				System.out.println(cookies[i].getName());
				System.out.println(cookies[i].getValue());
			}
		}
		
		response.addCookie(new Cookie("security Token","12345"));
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		session.setAttribute("user", userName);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String url = "targetServlet²sessionId=123";
		out.print("<a href='"+url+"'> Click here to get the user name</a>");
		
	}
}
