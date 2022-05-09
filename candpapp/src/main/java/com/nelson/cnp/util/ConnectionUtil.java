package com.nelson.cnp.util;

import org.apache.catalina.Context;
import org.apache.tomcat.jdbc.pool.DataSource;

public class ConnectionUtil {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/myds");
			connection = dataSource.getConnection()
		}catch(NamingException e) {
			e.printStackTrace();
		}catch(SQLExcpetion e) {
			e.printStackTrace();
		}
		return connection;
	}
}
