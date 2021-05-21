package com.bank.beans;

import com.bank.beans.*;
import java.util.*;
import java.io.*;

public class Driver {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<Account> accts = new ArrayList<Account>();
		ArrayList<Employee> employees = new ArrayList<Employee>();
		String userName = null, empName = null, password, firstName, lastName, answer1;
		boolean find = false;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Account.txt"));
			accts = (ArrayList<Account>) in.readObject();
			in.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		try {
			ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("Customer.txt"));
			customers = (ArrayList<Customer>) in1.readObject();
			in1.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		try {
			ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("Employee.txt"));
			employees = (ArrayList<Employee>) in2.readObject();
			in2.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		System.out.println("==================================================================");
		System.out.println("====================Welcome to bank app!==========================");
		System.out.println("==================================================================");
		// Register customer
		System.out.print("Are you going to register as a customer? y/n=> ");
		Scanner un = new Scanner(System.in);
		answer1 = un.nextLine();
		if (answer1.trim().toLowerCase().equals("y")) {
			Customer cus = new Customer();
			System.out.print("Please enter user name=>");
			Scanner un1 = new Scanner(System.in);
			userName = un1.nextLine();
			for (Customer c : customers) {
				if (c.getUserName().equals(userName.trim())) {
					System.out.println("User name already exists!");
					find = true;
					break;
				}
			}
			if (find == false) {
				System.out.print("Please enter first name=>");
				Scanner un2 = new Scanner(System.in);
				firstName = un2.nextLine();
				System.out.print("Please enter last name=>");
				Scanner un3 = new Scanner(System.in);
				lastName = un3.nextLine();
				System.out.print("Please enter password=>");
				Scanner un4 = new Scanner(System.in);
				password = un4.nextLine();
				cus.setUserName(userName);
				cus.setFirstName(firstName);
				cus.setLastName(lastName);
				cus.setPassWord(password);
				customers.add(cus);
				try {
					FileOutputStream file = new FileOutputStream("Customer.txt");
					ObjectOutputStream output = new ObjectOutputStream(file);
					output.writeObject(customers);
					output.close();
				} catch (Exception e) {
					e.getStackTrace();
					System.exit(0);
				}
			}
		} else if (answer1.trim().toLowerCase().equals("n")) {

		} else {
			System.out.println("please enter either \"y\" or \"n\"");
			System.exit(0);
		}
		// Customer login
		System.out.print("Are you going to login as a customer? y/n=> ");
		Scanner un6 = new Scanner(System.in);
		answer1 = un6.nextLine();
		if (answer1.trim().toLowerCase().equals("y")) {
			System.out.print("Please login as a customer! ");
			System.out.print("Please enter user name=>");
			Scanner un5 = new Scanner(System.in);
			userName = un5.nextLine();
			find = false;
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("Customer.txt"));
				ArrayList<Customer> cust = new ArrayList<Customer>();
				cust = (ArrayList<Customer>) in.readObject();
				for (Customer c : cust) {
					if (c.getUserName().trim().equals(userName.trim())) {
						find = true;
						in.close();
						break;
					}
				}
				in.close();
			} catch (Exception e) {
				e.getStackTrace();
				System.exit(0);
			}
			if (find == false) {
				System.out.println("Invalid username!");
				System.exit(0);
			}
			find = false;
			System.out.print("Please enter password=>");
			Scanner un4 = new Scanner(System.in);
			password = un4.nextLine();
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("Customer.txt"));
				ArrayList<Customer> cust = new ArrayList<Customer>();
				cust = (ArrayList<Customer>) in.readObject();
				for (Customer c : cust) {
					if (c.getPassWord().trim().equals(password.trim())) {
						find = true;
						in.close();
						break;
					}
				}
				in.close();
			} catch (Exception e) {
				e.getStackTrace();
				System.exit(0);
			}
			if (find == false) {
				System.out.println("Invalid password!");
				System.exit(0);
			}
			System.out.println("Welcome to Bank App " + userName+"!");
			// Apply for an account
			System.out.print("Are you going to apply for an account? y/n=> ");
			Scanner un7 = new Scanner(System.in);
			answer1 = un7.nextLine();
			if (answer1.trim().toLowerCase().equals("y")) {
				Account acct = new Account();
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("Customer.txt"));
					ArrayList<Customer> cust = new ArrayList<Customer>();
					cust = (ArrayList<Customer>) in.readObject();
					for (Customer c : cust) {
						if (c.getUserName().trim().equals(userName.trim())) {
							c.applyAccount(acct);
							accts.add(acct);
							in.close();
							break;
						}
					}
					in.close();
				} catch (Exception e) {
					e.getStackTrace();
					System.exit(0);
				}
				try 
				{
					ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("Account.txt"));
					output.writeObject(accts);
					output.close();
				}
				catch(Exception e)
				{
					e.getStackTrace();
					System.exit(0);
				}
			}else if (answer1.trim().toLowerCase().equals("n")) {

			} else {
				System.out.println("please enter either \"y\" or \"n\"");
				System.exit(0);
			}
			
		} else if (answer1.trim().toLowerCase().equals("n")) {

		} else {
			System.out.println("please enter either \"y\" or \"n\"");
			System.exit(0);
		}	
		System.out.print("Are you going to sign out? y/n=> ");
		Scanner un8 = new Scanner(System.in);
		answer1 = un8.nextLine();
		if (answer1.trim().toLowerCase().equals("y")) {
			userName=null;
			System.out.println("You are signed out");
		//Register employee
		}
		else if (answer1.trim().toLowerCase().equals("n")) {
          //deposit
		} else {
			System.out.println("please enter either \"y\" or \"n\"");
			System.exit(0);
		}	
		
	}
}
