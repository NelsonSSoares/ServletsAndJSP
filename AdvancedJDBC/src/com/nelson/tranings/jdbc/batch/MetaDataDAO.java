package com.nelson.tranings.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class MetaDataDAO {
	
	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "12345");
				Statement stmt = con.createStatement();) {
			
			ResultSet resultSet = stmt.executeQuery("select * from account");
			ResultSetMetaData resultSetMetaData = (ResultSetMetaData) resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			
			for(int i = 1; i < columnCount ; i++) {
				System.out.println(resultSetMetaData.getColumnName(i)); //pega o noma da coluna do banco
				System.out.println(resultSetMetaData.getColumnTypeName(i)); //pega o tipo da coluna
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
