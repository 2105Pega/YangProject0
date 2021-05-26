package com.bank.dao;
import java.util.List;

import BankApp.ConnectionUtils;
import model.Account;
import model.Customer;
import java.sql.*;

public class customerDAOImpl implements customerDAO{

	@Override
	public List<Account> getListOfAccount(Customer cus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createAccount() {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "insert into account(balance,status)"+"values(?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, 0);
			statement.setString(2, "applied");
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAccount(Account acct) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "delete from account where status=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, acct.getStatus());
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean depositAccount(Customer cus, double amount) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "Update account set balance = balance + ? " +
		    " where account_id=(select account_id from customer join record on customer.customer_id=record.customer_id where customer.username=?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, amount);
			statement.setString(2, cus.getUserName());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean withdrawAccount(Customer cus, double amount) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "Update account set balance = balance - ? " + "where account_id = ("
					+ "select record.account_id from record join customer on record.customer_id=customer.customer_id " + "	where customer.username = ?) and status='active'";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, amount);
			statement.setString(2, cus.getUserName());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean loginAccount(Customer cus) {
		try (Connection conn = ConnectionUtils.getConnection()){
			String sql="select * from customer where username=? and password=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, cus.getUserName());
			statement.setString(2, cus.getPassWord());
			ResultSet result=statement.executeQuery();
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean registerUser(Customer cus) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql = "insert into customer(fname, lname, username, password)"+"values(?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, cus.getFirstName());
			statement.setString(2, cus.getLastName());
			statement.setString(3, cus.getUserName());
			statement.setString(4, cus.getPassWord());
			statement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
