package com.bank.dao;

import model.Account;
import model.Customer;

public interface employeeDAO {
	public boolean approveAccount(int cusNum, int accountNum);
	public boolean deleteAccount(Account acct);
	public boolean depositAccount(Customer cus, double amount);
	public boolean withdrawAccount(Customer cus, double amount);
	public boolean loginAccount(String id, String pin);
}
