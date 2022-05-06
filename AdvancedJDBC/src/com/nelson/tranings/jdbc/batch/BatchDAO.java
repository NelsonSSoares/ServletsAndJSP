package com.nelson.tranings.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDAO {
	public static void main (String[] args) {
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root","12345");
				Statement stmt = con.createStatement();
				) {
				
			stmt.addBatch("insert  into account values(1,'Sousa','Nelson',10000)");
			stmt.addBatch("insert  into account values(2,'Sousa','Noeme', 10000)");
			
			int[] result = stmt.executeBatch();
			
			for(int i = 0; i< result.length; i++) {
				System.out.println(result[i]);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
