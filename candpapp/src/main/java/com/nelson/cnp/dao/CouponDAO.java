package com.nelson.cnp.dao;

import com.nelson.cnp.model.Coupon;
import com.nelson.cnp.util.ConnectionUtil;

public class CouponDAO {
	public void save(Coupon coupon) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection.preparedStatement("insert into coupon (code, discount, exp_data) values(?,?,?)");
			statement.setString(1, coupon.getCode());
			statement.setBigDecimal(2, coupon.getDiscount());
			statement.setString(3, coupon.getExpDate());
			statement.executeUpdate();
		}catch(SQLExcption e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Counpon findByCode(String code) {
		Counpon coupon =  new Counpon();
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection.preparedStatement("select * from coupon where code=?");
			statement.setString(1, code);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				coupon.setId(resultSet.getInt(1));
				coupon.setCode(resultSet.getString(2));
				coupon.setDiscount(resultSet.getBigDecimal(3));
				coupon.setExpDate(resultSet.getString(4));
			}
		}catch(SQLExcption e) {
			e.printStackTrace();
		}
		return coupon;
	}
}
