package com.nelson.trainings.jsp.customtags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriveManager;
import java.sql.SQLException;


public class ResultHandler extends TagSupport{
	
	Connection con;
	PreparedStatement stmt;
	
	public ResultHandler() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://localhost/3306:/mydb", "root", "12345");
			stmt = con.prepareStatement("select * from user where email=?");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public int doStartTag() throws JspException {
		
		ServletRequest request = pageContext.getRequest();
		String email = request.getParameter("email");
		
		try {
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			
			JspWriter out = pageContext.getOut();
			
			if(rs.next()) {
				
				out.print("user details are : <br/> First Name: ");
				
				out.print(rs.getString(1));
				out.print("<br/> Last Name: ");
				out.print(rs.getString(2));
			}else {
				out.print("Invalid Email!");
			}
			
		barra /
		}catch(SQLException  | IOException e) {
			e.printStackTrace();
		}
		
		return Tag.SKIP_BODY;
	}
		
		

	@Override
	public void realese() {
		try {
			stmt.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
}
