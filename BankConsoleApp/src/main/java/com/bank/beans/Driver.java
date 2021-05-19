package com.bank.beans;

import com.bank.beans.*;
import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class Driver {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		ArrayList<Account> accts = new ArrayList<Account>();
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Customer cus = new Customer();
		Account acct = new Account();
		Employee emp = new Employee();
		String userName = null, empName=null,password, firstName, lastName, answer1;
		System.out.println("==================================================================");
		System.out.println("====================Welcome to bank app!==========================");
		System.out.println("==================================================================");
		System.out.print("Are you a customer? y/n=> ");
		Scanner un2 = new Scanner(System.in);
		answer1 = un2.nextLine();
		if (answer1.trim().toLowerCase().equals("y")) {
			System.out.println("Press 1 to register, press 2 to login");
			String option = null;
			boolean login = false;
			while (login == false) {
				option = MainMenu();
				switch (option) {
				case "1": {
					System.out.print("Please enter user name=>");
					Scanner un3 = new Scanner(System.in);
					userName = un3.nextLine();
					System.out.print("Please enter first name=>");
					Scanner un = new Scanner(System.in);
					firstName = un.nextLine();
					System.out.print("Please enter last name=>");
					Scanner un1 = new Scanner(System.in);
					lastName = un1.nextLine();
					System.out.print("Please enter password=>");
					Scanner un4 = new Scanner(System.in);
					password = un4.nextLine();
					cus.setUserName(userName);
					cus.setFirstName(firstName);
					cus.setLastName(lastName);
					cus.setPassWord(password);
					customers.add(cus);
				}
					break;

				case "2": {
					try {
						FileOutputStream file = new FileOutputStream("Customer.txt");
						ObjectOutputStream output = new ObjectOutputStream(file);
						output.writeObject(customers);
						output.close();
					} catch (Exception e) {
						e.getStackTrace();
						System.exit(0);
					}
					userName = loginCustomer();
					login = true;
				}
					break;

				case "3":
				{
					login = true;
				}
					break;
				}
			}
		} else if (answer1.trim().toLowerCase().equals("n")) {

		} else {
			System.out.println("please enter either \"y\" or \"n\"");
			System.exit(0);
		}
		//apply for account
		System.out.print("Do you want to apply for an account? y/n=> ");
		Scanner un6 = new Scanner(System.in);
		answer1 = un6.nextLine();
		if (answer1.trim().toLowerCase().equals("y"))
		{
		   cus.applyAccount(acct);
		   accts.add(acct);
		}
		else if (answer1.trim().toLowerCase().equals("n")) {

		} else {
			System.out.println("please enter either \"y\" or \"n\"");
			System.exit(0);
		}
		//Register employee
		System.out.print("Are you an employee? y/n=> ");
		Scanner un7 = new Scanner(System.in);
		answer1 = un7.nextLine();
		if (answer1.trim().toLowerCase().equals("y")) {
			System.out.println("Press 1 to register, press 2 to login");
			String option = null;
			boolean login = false;
			while (login == false) {
				option = employeeMenu();
				switch (option) {
				case "1": {
					System.out.print("Please enter user name=>");
					Scanner un3 = new Scanner(System.in);
					empName = un3.nextLine();
					System.out.print("Please enter first name=>");
					Scanner un = new Scanner(System.in);
					firstName = un.nextLine();
					System.out.print("Please enter last name=>");
					Scanner un1 = new Scanner(System.in);
					lastName = un1.nextLine();
					System.out.print("Please enter password=>");
					Scanner un4 = new Scanner(System.in);
					password = un4.nextLine();
					emp.setUserName(empName);
					emp.setFirstName(firstName);
					emp.setLastName(lastName);
					emp.setPassWord(password);
					employees.add(emp);
				}
					break;

				case "2": {
					try {
						FileOutputStream file = new FileOutputStream("Employee.txt");
						ObjectOutputStream output = new ObjectOutputStream(file);
						output.writeObject(employees);
						output.close();
					} catch (Exception e) {
						e.getStackTrace();
						System.exit(0);
					}
					loginEmployee();
					System.out.print("Are going to approve an account? y/n=> ");
					Scanner un8 = new Scanner(System.in);
					answer1 = un8.nextLine();
					if (answer1.trim().toLowerCase().equals("y"))
					{
						String acctNum, name;
						System.out.print("Please enter a user name y/n=> ");
						Scanner un9 = new Scanner(System.in);
						name = un9.nextLine();
						if(name.trim().isEmpty()==true)
						{
							System.out.println("Please enter a valid user name");
							System.exit(0);
						}
						System.out.print("Please enter an account number y/n=> ");
						Scanner un10 = new Scanner(System.in);
						acctNum = un10.nextLine();
						if(acctNum.trim().isEmpty()==true)
						{
							System.out.println("Please enter a valid user name");
							System.exit(0);
						}
						for(Account acc:accts)
						{
							int i;
							if(acc.getUserName().equals(name.trim())&&acc.getStatus().toLowerCase().equals("applied"))
							{
								i=accts.indexOf(acc);
								accts.remove(i);
								acct.setUserName(name);
								acct.setAccountNum(acctNum);
								acct.setBalance(0);
								acct.setStatus("active");
								accts.add(i, acct);
								break;
							}
						}
					}
					else if (answer1.trim().toLowerCase().equals("n")) {

					} else {
						System.out.println("please enter either \"y\" or \"n\"");
						System.exit(0);
					}
					System.out.print("Are going to deny an account? y/n=> ");
					Scanner un12 = new Scanner(System.in);
					answer1 = un12.nextLine();
					if (answer1.trim().toLowerCase().equals("y"))
					{
						String acctNum, name;
						System.out.print("Please enter a user name y/n=> ");
						Scanner un9 = new Scanner(System.in);
						name = un9.nextLine();
						if(name.trim().isEmpty()==true)
						{
							System.out.println("Please enter a valid user name");
							System.exit(0);
						}
						for(Account acc:accts)
						{
							int i;
							if(acc.getUserName().equals(name.trim())&&acc.getStatus().toLowerCase().equals("applied"))
							{
								i=accts.indexOf(acc);
								accts.remove(i);
								acct.setUserName(name);
								acct.setAccountNum(null);
								acct.setBalance(0);
								acct.setStatus("rejected");
								accts.add(i, acct);
								break;
							}
						}
					}
					else if (answer1.trim().toLowerCase().equals("n")) {

					} else {
						System.out.println("please enter either \"y\" or \"n\"");
						System.exit(0);
					}
					System.out.print("Are going to cancel an account? y/n=> ");
					Scanner un13 = new Scanner(System.in);
					answer1 = un13.nextLine();
					if (answer1.trim().toLowerCase().equals("y"))
					{
						String acctNum, name;
						System.out.print("Please enter a user name y/n=> ");
						Scanner un14 = new Scanner(System.in);
						name = un14.nextLine();
						if(name.trim().isEmpty()==true)
						{
							System.out.println("Please enter a valid user name");
							System.exit(0);
						}
						System.out.print("Please enter an account number y/n=> ");
						Scanner un15 = new Scanner(System.in);
						acctNum = un15.nextLine();
						if(acctNum.trim().isEmpty()==true)
						{
							System.out.println("Please enter a valid user name");
							System.exit(0);
						}
						int i;
						double balance;
						for(Account acc:accts)
						{
							if(acc.getUserName().equals(name.trim())&&acc.getAccountNum().equals(acctNum.trim()))
							{
								i=accts.indexOf(acc);
								balance=acc.getBalance();
								accts.remove(i);
								acct.setUserName(name);
								acct.setAccountNum(acctNum);
								acct.setBalance(balance);
								acct.setStatus("cancelled");
								accts.add(i, acct);
								break;
							}
						}
					}
					else if (answer1.trim().toLowerCase().equals("n")) {

					} else {
						System.out.println("please enter either \"y\" or \"n\"");
						System.exit(0);
					}
					System.out.print("Are going to deposit to an account? y/n=> ");
					Scanner un15 = new Scanner(System.in);
					answer1 = un15.nextLine();
					if (answer1.trim().toLowerCase().equals("y"))
					{
						String acctNum, name;
						System.out.print("Please enter a user name y/n=> ");
						Scanner un17 = new Scanner(System.in);
						name = un17.nextLine();
						if(name.trim().isEmpty()==true)
						{
							System.out.println("Please enter a valid user name");
							System.exit(0);
						}
						System.out.print("Please enter an account number y/n=> ");
						Scanner un18 = new Scanner(System.in);
						acctNum = un18.nextLine();
						if(acctNum.trim().isEmpty()==true)
						{
							System.out.println("Please enter a valid user name");
							System.exit(0);
						}
						int i;
						double balance=0;
						System.out.print("Please enter the amount=>");
						Scanner scAmount=new Scanner(System.in);
						try
						{
							balance=scAmount.nextDouble();
						}
						catch(Exception e)
						{
							System.out.println("Please enter a valid amount!");
							e.getStackTrace();
							System.exit(0);
						}
						for(Account acc:accts)
						{
							if(acc.getUserName().equals(name.trim())&&acc.getAccountNum().equals(acctNum.trim())&&acc.getStatus().toLowerCase().equals("active"))
							{
							  i=accts.indexOf(acc);	
							  deposit(acc,balance);
							  accts.set(i,acc);
							  break;
							}
						}
					}
					else if (answer1.trim().toLowerCase().equals("n")) {

					} else {
						System.out.println("please enter either \"y\" or \"n\"");
						System.exit(0);
					}
					System.out.print("Are going to withdraw some money? y/n=> ");
					Scanner un18 = new Scanner(System.in);
					answer1 = un18.nextLine();
					if (answer1.trim().toLowerCase().equals("y"))
					{
						String acctNum, name;
						System.out.print("Please enter a user name y/n=> ");
						Scanner un17 = new Scanner(System.in);
						name = un17.nextLine();
						if(name.trim().isEmpty()==true)
						{
							System.out.println("Please enter a valid user name");
							System.exit(0);
						}
						System.out.print("Please enter an account number y/n=> ");
						Scanner un20 = new Scanner(System.in);
						acctNum = un20.nextLine();
						if(acctNum.trim().isEmpty()==true)
						{
							System.out.println("Please enter a valid user name");
							System.exit(0);
						}
						int i;
						double balance=0;
						System.out.print("Please enter the amount=>");
						Scanner scAmount=new Scanner(System.in);
						try
						{
							balance=scAmount.nextDouble();
						}
						catch(Exception e)
						{
							System.out.println("Please enter a valid amount!");
							e.getStackTrace();
							System.exit(0);
						}
						for(Account acc:accts)
						{
							if(acc.getUserName().equals(name.trim())&&acc.getAccountNum().equals(acctNum.trim())&&acc.getStatus().toLowerCase().equals("active"))
							{
							  i=accts.indexOf(acc);	
							  withdraw(acc,balance);
							  accts.set(i,acc);
							  break;
							}
						}
					}
					else if (answer1.trim().toLowerCase().equals("n")) {

					} else {
						System.out.println("please enter either \"y\" or \"n\"");
						System.exit(0);
					}
					
				}
					break;

				case "3":
				{
					login=true;
				}
					break;
				}
			}
		} else if (answer1.trim().toLowerCase().equals("n")) {

		} else {
			System.out.println("please enter either \"y\" or \"n\"");
			System.exit(0);
		}
		try {
			FileOutputStream file = new FileOutputStream("Account.txt");
			ObjectOutputStream output = new ObjectOutputStream(file);
			output.writeObject(accts);
			output.close();
		} catch (Exception e) {
			e.getStackTrace();
			System.exit(0);
		}
	}

	public static String MainMenu() {
		String choice = null;
		boolean valid;
		valid = false;
		System.out.println("==============================================================");
		System.out.println("=====================Register account=========================");
		System.out.println("=======================Customer MENU==========================");
		System.out.println("==============================================================");

		System.out.println("1. Register an account");
		System.out.println("2. Login");
		System.out.println("3. <Return>");
		do {
			System.out.print("\nPlease select an option [1-3], and press ENTER=> ");
			Scanner ch = new Scanner(System.in);
			choice = ch.nextLine();
			switch (choice) {
			case "1":
				valid = true;
				break;
			case "2":
				valid = true;
				break;
			case "3":
				valid = true;
				break;
			default:
				valid = false;
				System.out.println("\nYou entered an invalid choice: " + choice);
				break;
			}
		} while (valid == false);
		return choice;
	}

	public static String loginCustomer() {
		String userName, password;
		System.out.print("Please enter user name=>");
		Scanner un3 = new Scanner(System.in);
		userName = un3.nextLine();
		boolean find = false;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Customer.txt"));
			ArrayList<Customer> cust = new ArrayList<Customer>();
			cust = (ArrayList<Customer>)in.readObject();
			for (Customer c : cust) {
				if (c.getUserName().trim().equals(userName.trim())) {
					find = true;
					break;
				}
			}
			in.close();
		} catch (Exception e) {
			e.getStackTrace();
			System.exit(0);
		}
		if(find==false)
		{
			System.out.println("Invalid username!");
			System.exit(0);
		}
		find=false;
		System.out.print("Please enter password=>");
		Scanner un4 = new Scanner(System.in);
		password = un4.nextLine();
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Customer.txt"));
			ArrayList<Customer> cust = new ArrayList<Customer>();
			cust = (ArrayList<Customer>)in.readObject();
			for (Customer c : cust) {
				if (c.getPassWord().trim().equals(password.trim())) {
					find = true;
					break;
				}
			}
			in.close();
		} catch (Exception e) {
			e.getStackTrace();
			System.exit(0);
		}
		if(find==false)
		{
			System.out.println("Invalid password!");
			System.exit(0);
		}
		return userName;
	}
    public static String employeeMenu()
    {
    	String choice = null;
		boolean valid;
		valid = false;
		System.out.println("==============================================================");
		System.out.println("=====================Register account=========================");
		System.out.println("=======================Employee MENU==========================");
		System.out.println("==============================================================");

		System.out.println("1. Register an account");
		System.out.println("2. Login");
		System.out.println("3. <Return>");
		do {
			System.out.print("\nPlease select an option [1-3], and press ENTER=> ");
			Scanner ch = new Scanner(System.in);
			choice = ch.nextLine();
			switch (choice) {
			case "1":
				valid = true;
				break;
			case "2":
				valid = true;
				break;
			case "3":
				valid = true;
				break;
			default:
				valid = false;
				System.out.println("\nYou entered an invalid choice: " + choice);
				break;
			}
		} while (valid == false);
		return choice;
    }
    
    public static void loginEmployee()
    {
    	String userName, password;
		System.out.print("Please enter user name=>");
		Scanner un3 = new Scanner(System.in);
		userName = un3.nextLine();
		boolean find = false;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Employee.txt"));
			ArrayList<Employee> emps = new ArrayList<Employee>();
			emps = (ArrayList<Employee>)in.readObject();
			for (Employee e : emps) {
				if (e.getUserName().trim().equals(userName.trim())) {
					find = true;
					break;
				}
			}
			in.close();
		} catch (Exception e) {
			e.getStackTrace();
			System.exit(0);
		}
		if(find==false)
		{
			System.out.println("Invalid username!");
			System.exit(0);
		}
		find=false;
		System.out.print("Please enter password=>");
		Scanner un4 = new Scanner(System.in);
		password = un4.nextLine();
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Employee.txt"));
			ArrayList<Employee> emps = new ArrayList<Employee>();
			emps = (ArrayList<Employee>)in.readObject();
			for (Employee e : emps) {
				if (e.getPassWord().trim().equals(password.trim())) {
					find = true;
					break;
				}
			}
			in.close();
		} catch (Exception e) {
			e.getStackTrace();
			System.exit(0);
		}
		if(find==false)
		{
			System.out.println("Invalid password!");
			System.exit(0);
		}
    }
    public static void deposit(Account act, double amount)
    {
    	act.deposit(amount);
    	System.out.println("Successfully deposited $"+amount);
    }
    public static void withdraw(Account act, double amount)
    {
    	act.withdraw(amount);
    	System.out.println("Successfully withdrawed $"+amount);
    }
}
