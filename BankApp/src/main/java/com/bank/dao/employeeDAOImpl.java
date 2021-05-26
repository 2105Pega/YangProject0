package com.bank.dao;

import java.util.List;
import java.util.Properties;

import BankApp.ConnectionUtils;
import model.Account;
import model.Customer;

import java.io.FileInputStream;
import java.sql.*;

public class employeeDAOImpl implements employeeDAO {

	@Override
	public boolean approveAccount(int cusID,int accountNum) {
		try (Connection conn = ConnectionUtils.getConnection()){
			String sql="update account set status='active' where account_id=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, accountNum);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try (Connection conn = ConnectionUtils.getConnection()){
			String sql="insert into record (customer_id,account_id) values(?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, cusID);
			statement.setInt(2, accountNum);
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteAccount(Account acct) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean depositAccount(Customer cus, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdrawAccount(Customer cus, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loginAccount(String id, String pin) {
		String username = "";
		String password = "";
		try {
			FileInputStream file = new FileInputStream("../BankApp/src/test/resources/PropertyFile.properties");
			Properties prop = new Properties();
			prop.load(file);
			username = prop.getProperty("Emp_Username");
			password = prop.getProperty("Emp_Password");
			if(id.trim().equals(username)&&pin.trim().equals(password))
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
