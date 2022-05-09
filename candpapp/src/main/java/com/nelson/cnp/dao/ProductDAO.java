package com.nelson.cnp.dao;

import com.nelson.cnp.model.Product;
import com.nelson.cnp.util.ConnectionUtil;

public class ProductDAO {
	public void save(Product product) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection.preparedStatement("insert into product (name, description, price) values(?,?,?)");
			
			statement.setString(1, product.getName());
			statement.setString(2, product.getDescription());
			statement.setBigDecimal(3, product.getPrice());
			statement.executeUpdate();
			
			}
		}catch(SQLExcption e) {
			e.printStackTrace();
		}
	}
}
