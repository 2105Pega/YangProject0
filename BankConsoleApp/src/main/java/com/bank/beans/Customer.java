package com.bank.beans;

import com.bank.beans.*;
import java.io.*;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;

	public Customer() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		if (userName.trim().isEmpty()) {
			System.out.println("Please enter a non empty user name!");
			System.exit(0);
		} else
			this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		if (passWord.trim().isEmpty()) {
			System.out.println("Please enter a non empty password!");
			System.exit(0);
		} else
			this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.trim().isEmpty()) {
			System.out.println("Please enter a non empty first name!");
			System.exit(0);
		} else
			this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.trim().isEmpty()) {
			System.out.println("Please enter a non empty last name!");
			System.exit(0);
		} else
			this.lastName = lastName;
	}

	public void applyAccount(Account acct) {
		acct.setUserName(this.userName);
		acct.setBalance(0);
		acct.setStatus("applied");
	}

	@Override
	public String toString() {
		return "Customer name: [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
