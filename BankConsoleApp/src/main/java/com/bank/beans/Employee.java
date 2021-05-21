package com.bank.beans;

import com.bank.beans.*;
import java.io.*;
import java.util.ArrayList;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;

	public Employee() {
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

	public void viewCustomerInfo(String userName) {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Account.txt"));
			ArrayList<Account> account = new ArrayList<Account>();
			account = (ArrayList<Account>) in.readObject();
			ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("Customer.txt"));
			ArrayList<Customer> cust = new ArrayList<Customer>();
			cust = (ArrayList<Customer>) in1.readObject();
			for (Account c : account) {
				if (c.getUserName().equals(userName.trim())) {
					System.out.print(c);
					System.out.print(" ");
					for(Customer cus:cust) {
						if (cus.getUserName().equals(userName.trim())) {
							System.out.println(cus);
							break;
						}
					}
				}
			}
			in.close();
		} catch (Exception e) {
			e.getStackTrace();
			System.exit(0);
		}
	}
}
