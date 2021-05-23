package com.bank.beans;
import java.io.*;
import com.bank.beans.*;

public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	private String accountNum;
	private String userName;
	private double balance;
	private String status;

	public Account() {
		super();
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void deposit(double amount) {
		if (amount<0)
		{
			System.out.println("Please enter a valid positive amount!");
			System.exit(0);
		}
		else
		   this.balance=this.getBalance()+ amount;
	}
    
	public void withdraw (double amount) {
		if(this.balance<amount)
		{
			System.out.println("Your balance is insufficient!");
			System.exit(0);
		}
		else if (amount<0)
		{
			System.out.println("Please enter a valid positive amount!");
			System.exit(0);
		}
		else
			this.balance=this.getBalance()-amount;
	}

	@Override
	public String toString() {
		return "Account info: [accountNum=" + accountNum + ", balance=" + balance + ", status=" + status + "]";
	}
	
}
