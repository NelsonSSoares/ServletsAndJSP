package com.nelson.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUsewrServlet
 */
@WebServlet("/updateServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection connection;
	
	
	public void init() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "12345");
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("update user set password='"+password+"', email='"+email+"' where email='"+email+"' ");
			PrintWriter out = response.getWriter();
			if(result > 0) {
				out.print("<h1>PASSWORD UPDATED!!</h1>");
			}else {
				out.print("<h1>ERROR CREATING THE USER</h1>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
