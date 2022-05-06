package com.nelson.tranings.jdbc.tm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDAO {
	public static void main(String[] args) {
		
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "12345");
			Statement stmt = con.createStatement();
			con.setAutoCommit(false);
			stmt.executeUpdate("update account set bal= bal-500 where accno=2");
			stmt.executeUpdate("update account set bal= bal+500 where accno=1");
			
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				con.close();
				con.rollback();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
