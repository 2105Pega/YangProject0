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
			System.out.print("\nPlease enter user name=>");
			Scanner un5 = new Scanner(System.in);
			userName = un5.nextLine();
			find = false;
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("Customer.txt"));
				customers = (ArrayList<Customer>) in.readObject();
				for (Customer c : customers) {
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
				customers = (ArrayList<Customer>) in.readObject();
				for (Customer c : customers) {
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
					customers = (ArrayList<Customer>) in.readObject();
					for (Customer c : customers) {
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
		System.out.print("Are you going to sign out as a customer? y/n=> ");
		Scanner un8 = new Scanner(System.in);
		answer1 = un8.nextLine();
		if (answer1.trim().toLowerCase().equals("y")) {
			userName=null;
			System.out.println("You are signed out");
		//Register employee
			System.out.print("Are you going to register as an employee? y/n=> ");
			Scanner un12 = new Scanner(System.in);
			answer1 = un12.nextLine();
			find=false;
			if (answer1.trim().toLowerCase().equals("y")) {
				Employee emp = new Employee();
				System.out.print("Please enter user name=>");
				Scanner un13 = new Scanner(System.in);
				empName = un13.nextLine();
				for (Employee e : employees) {
					if (e.getUserName().equals(empName.trim())) {
						System.out.println("User name already exists!");
						find = true;
						break;
					}
				}
				if (find == false) {
					System.out.print("Please enter first name=>");
					Scanner un14 = new Scanner(System.in);
					firstName = un14.nextLine();
					System.out.print("Please enter last name=>");
					Scanner un15 = new Scanner(System.in);
					lastName = un15.nextLine();
					System.out.print("Please enter password=>");
					Scanner un16 = new Scanner(System.in);
					password = un16.nextLine();
					emp.setUserName(empName);
					emp.setFirstName(firstName);
					emp.setLastName(lastName);
					emp.setPassWord(password);
					employees.add(emp);
					try {
						FileOutputStream file = new FileOutputStream("Employee.txt");
						ObjectOutputStream output = new ObjectOutputStream(file);
						output.writeObject(employees);
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
			//Employee login
			System.out.print("Are you going to login as an employee? y/n=> ");
			Scanner un17 = new Scanner(System.in);
			answer1 = un17.nextLine();
			if (answer1.trim().toLowerCase().equals("y")) {
				System.out.print("Please login as an employee! ");
				System.out.print("Please enter user name=>");
				Scanner un18 = new Scanner(System.in);
				empName = un18.nextLine();
				find = false;
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("Employee.txt"));
					employees = (ArrayList<Employee>) in.readObject();
					for (Employee e : employees) {
						if (e.getUserName().trim().equals(empName.trim())) {
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
				Scanner un19 = new Scanner(System.in);
				password = un19.nextLine();
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("Employee.txt"));
					employees = (ArrayList<Employee>) in.readObject();
					for (Employee e : employees) {
						if (e.getPassWord().trim().equals(password.trim())) {
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
				System.out.println("Welcome to Bank App " + empName+"!");
				// Approve an account
				System.out.print("Are you going to approve an account? y/n=> ");
				Scanner un20 = new Scanner(System.in);
				answer1 = un20.nextLine();
				if (answer1.trim().toLowerCase().equals("y")) {
					String cusName, acctNum;
					find=false;
					System.out.println("Please enter a customer's user name=>");
					Scanner un21= new Scanner(System.in);
					cusName=un21.nextLine();
					if(cusName.trim().isEmpty())
					{
						System.out.println("Please enter a valid customer's user name!");
					}
					System.out.println("Please enter an account number=>");
					Scanner un22= new Scanner(System.in);
					acctNum=un22.nextLine();
					if(acctNum.trim().isEmpty())
					{
						System.out.println("Please enter a valid account number!");
					}
					try {
						ObjectInputStream in = new ObjectInputStream(new FileInputStream("Account.txt"));
						accts = (ArrayList<Account>) in.readObject();
						for (Account a : accts) {
							if (a.getUserName().equals(cusName.trim())&&a.getAccountNum()==null) {
								int i=accts.indexOf(a);
								a.setAccountNum(acctNum);
								a.setStatus("active");
								accts.set(i, a);
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
				//deny an account
				System.out.print("Are you going to deny an account? y/n=> ");
				Scanner un23 = new Scanner(System.in);
				answer1 = un23.nextLine();
				if (answer1.trim().toLowerCase().equals("y")) {
					String cusName;
					find=false;
					System.out.println("Please enter a customer's user name=>");
					Scanner un24= new Scanner(System.in);
					cusName=un24.nextLine();
					if(cusName.trim().isEmpty())
					{
						System.out.println("Please enter a valid customer's user name!");
					}		
					try {
						ObjectInputStream in = new ObjectInputStream(new FileInputStream("Account.txt"));
						accts = (ArrayList<Account>) in.readObject();
						for (Account a : accts) {
							if (a.getUserName().equals(cusName.trim())&&a.getAccountNum()==null) {
								int i=accts.indexOf(a);
								a.setStatus("rejected");
								accts.set(i, a);
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
				//cancel an account
				System.out.print("Are you going to cancel an account? y/n=> ");
				Scanner un24 = new Scanner(System.in);
				answer1 = un24.nextLine();
				find=false;
				if (answer1.trim().toLowerCase().equals("y")) {
					String cusName, acctNum;
					find=false;
					System.out.println("Please enter a customer's user name=>");
					Scanner un25= new Scanner(System.in);
					cusName=un25.nextLine();
					if(cusName.trim().isEmpty())
					{
						System.out.println("Please enter a valid customer's user name!");
					}
					System.out.println("Please enter an account number=>");
					Scanner un26= new Scanner(System.in);
					acctNum=un26.nextLine();
					if(acctNum.trim().isEmpty())
					{
						System.out.println("Please enter a valid account number!");
					}
					try {
						ObjectInputStream in = new ObjectInputStream(new FileInputStream("Account.txt"));
						accts = (ArrayList<Account>) in.readObject();
						for (Account a : accts) {
							if (a.getUserName().equals(cusName.trim())&&a.getAccountNum().equals(acctNum.trim())) {
								int i=accts.indexOf(a);
								find=true;
								accts.remove(i);
								in.close();
								System.out.println("Account "+acctNum+" was cancelled.");
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
						System.out.println("The corresponding account was not found!");
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
				//View a customer's information
				System.out.print("Are you going to view a customer's information? y/n=> ");
				Scanner un30 = new Scanner(System.in);
				answer1 = un30.nextLine();
				find=false;
				if (answer1.trim().toLowerCase().equals("y")) {
					String user;
					System.out.print("please enter a customer's user name=> ");
					Scanner un31 = new Scanner(System.in);
					user = un31.nextLine();
					if(user.trim().isEmpty())
					{
						System.out.println("Please enter a valid user name!");
					}
					try {
						ObjectInputStream in = new ObjectInputStream(new FileInputStream("Account.txt"));
						accts = (ArrayList<Account>) in.readObject();
						ObjectInputStream in1=new ObjectInputStream(new FileInputStream("Customer.txt"));
						customers=(ArrayList<Customer>)in1.readObject();
						for (Account a : accts) {
							if (a.getUserName().equals(user.trim())) {
								find=true;
								System.out.print("Account "+a+" ");
								for(Customer c:customers)
								{
									if(c.getUserName().equals(user.trim())) {
										System.out.println(c);
									}
								}
							}
						}
						in.close();
						in1.close();
					} catch (Exception e) {
						e.getStackTrace();
						System.exit(0);
					}
					if(find==false)
					{
						System.out.println("Please enter a valid user name!");
						System.exit(0);
					}
				}
				else if (answer1.trim().toLowerCase().equals("n")) {

				} else {
					System.out.println("please enter either \"y\" or \"n\"");
					System.exit(0);
				}	
			} else if (answer1.trim().toLowerCase().equals("n")) {

			} else {
				System.out.println("please enter either \"y\" or \"n\"");
				System.exit(0);
			}	
		}
		else if (answer1.trim().toLowerCase().equals("n")) {
          //deposit
			System.out.print("Are going to deposit to an account? y/n=> ");
			Scanner un9 = new Scanner(System.in);
			answer1 = un9.nextLine();
			if (answer1.trim().toLowerCase().equals("y"))
			{
				String acctNum;
				System.out.print("Please enter an account number=> ");
				Scanner un10 = new Scanner(System.in);
				acctNum = un10.nextLine();
				if(acctNum.trim().isEmpty()==true)
				{
					System.out.println("Please enter a valid account number!");
					System.exit(0);
				}
				int i;
				double amount=0;
				System.out.print("Please enter the amount=>");
				Scanner scAmount=new Scanner(System.in);
				find=false;
				try
				{
					amount=scAmount.nextDouble();
				}
				catch(Exception e)
				{
					System.out.println("Please enter a valid amount!");
					e.getStackTrace();
					System.exit(0);
				}
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("Account.txt"));
					accts = (ArrayList<Account>) in.readObject();
					for(Account acc:accts)
					{
						if(acc.getUserName().equals(userName.trim())&&acc.getAccountNum().equals(acctNum.trim())&&acc.getStatus().toLowerCase().equals("active"))
						{
						  i=accts.indexOf(acc);	
						  acc.deposit(amount);
						  accts.set(i,acc);
						  find=true;
						  System.out.println("Successfully deposited $"+amount);
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
					System.out.println("Please enter a valid account number!");
					System.exit(0);
				}
				else
				{
					try {
						ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Account.txt"));
						output.writeObject(accts);
						output.close();
					} catch (Exception e) {
						e.getStackTrace();
						System.exit(0);
					}
				}
			}
			else if (answer1.trim().toLowerCase().equals("n")) {

			} else {
				System.out.println("please enter either \"y\" or \"n\"");
				System.exit(0);
			}
			//Withdraw
			System.out.print("Are going to withdraw some money? y/n=> ");
			Scanner un11 = new Scanner(System.in);
			answer1 = un11.nextLine();
			if (answer1.trim().toLowerCase().equals("y"))
			{
				String acctNum;
				System.out.print("Please enter an account number=> ");
				Scanner un12 = new Scanner(System.in);
				acctNum = un12.nextLine();
				if(acctNum.trim().isEmpty()==true)
				{
					System.out.println("Please enter a valid account number!");
					System.exit(0);
				}
				int i;
				double amount=0;
				System.out.print("Please enter the amount=>");
				Scanner scAmount=new Scanner(System.in);
				find=false;
				try
				{
					amount=scAmount.nextDouble();
				}
				catch(Exception e)
				{
					System.out.println("Please enter a valid amount!");
					e.getStackTrace();
					System.exit(0);
				}
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("Account.txt"));
					accts = (ArrayList<Account>) in.readObject();
					for(Account acc:accts)
					{
						if(acc.getUserName().equals(userName.trim())&&acc.getAccountNum().equals(acctNum.trim())&&acc.getStatus().toLowerCase().equals("active"))
						{
						  i=accts.indexOf(acc);	
						  acc.withdraw(amount);
						  accts.set(i,acc);
						  find=true;
						  System.out.println("Successfully withdrawed $"+amount);
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
					System.out.println("Please enter a valid account number!");
					System.exit(0);
				}
				else
				{
					try {
						ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Account.txt"));
						output.writeObject(accts);
						output.close();
					} catch (Exception e) {
						e.getStackTrace();
						System.exit(0);
					}
				}
			}
			else if (answer1.trim().toLowerCase().equals("n")) {

			} else {
				System.out.println("please enter either \"y\" or \"n\"");
				System.exit(0);
			}
			//Transfer to another account
			System.out.print("Are going to transfer to an account? y/n=> ");
			Scanner un30 = new Scanner(System.in);
			answer1 = un30.nextLine();
			if (answer1.trim().toLowerCase().equals("y"))
			{
				String acctNum;
				double amount=0;
				System.out.print("Please enter your account number=> ");
				Scanner un10 = new Scanner(System.in);
				acctNum = un10.nextLine();
				if(acctNum.trim().isEmpty()==true)
				{
					System.out.println("Please enter a valid account number!");
					System.exit(0);
				}
				int i;
				System.out.print("Please enter the amount=> ");
				Scanner scAmount=new Scanner(System.in);
				find=false;
				try
				{
					amount=scAmount.nextDouble();
				}
				catch(Exception e)
				{
					System.out.println("Please enter a valid amount!");
					e.getStackTrace();
					System.exit(0);
				}
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("Account.txt"));
					accts = (ArrayList<Account>) in.readObject();
					for(Account acc:accts)
					{
						if(acc.getAccountNum().equals(acctNum.trim())&&acc.getStatus().toLowerCase().equals("active"))
						{
						  i=accts.indexOf(acc);	
						  acc.withdraw(amount);
						  accts.set(i,acc);
						  find=true;
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
					System.out.println("Please enter a valid account number!");
					System.exit(0);
				}
				try {
					ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Account.txt"));
					output.writeObject(accts);
					output.close();
				} catch (Exception e) {
					e.getStackTrace();
					System.exit(0);
				}
				String acctNum1;
				System.out.print("Please enter the destination account number=> ");
				Scanner un31 = new Scanner(System.in);
				acctNum1 = un31.nextLine();
				if(acctNum1.trim().isEmpty()==true)
				{
					System.out.println("Please enter a valid account number!");
					System.exit(0);
				}
				find=false;
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("Account.txt"));
					accts = (ArrayList<Account>) in.readObject();
					for(Account acc:accts)
					{
						if(acc.getAccountNum().equals(acctNum1.trim())&&acc.getStatus().toLowerCase().equals("active"))
						{
						  i=accts.indexOf(acc);	
						  acc.deposit(amount);
						  accts.set(i,acc);
						  find=true;
						  System.out.println("Successfully transfered $"+amount);
						  break;
						}
					}
					in.close();
				} catch (Exception e) {
					System.out.println("Please enter a valid account number!");
					System.exit(0);
				}
					
				if(find==false)
				{
					System.out.println("Please enter a valid account number!");
					try {
						ObjectInputStream in = new ObjectInputStream(new FileInputStream("Account.txt"));
						accts = (ArrayList<Account>) in.readObject();
						for(Account acc:accts)
						{
							if(acc.getAccountNum().equals(acctNum.trim())&&acc.getStatus().toLowerCase().equals("active"))
							{
							  i=accts.indexOf(acc);	
							  acc.deposit(amount);
							  accts.set(i,acc);
							  break;
							}
						}
						in.close();
					} catch (Exception e) {
						e.getStackTrace();
						System.exit(0);
					}
					System.exit(0);
				}
				else
				{
					try {
						ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Account.txt"));
						output.writeObject(accts);
						output.close();
					} catch (Exception e) {
						e.getStackTrace();
						System.exit(0);
					}
				}
			}
			else if (answer1.trim().toLowerCase().equals("n")) {

			} else {
				System.out.println("please enter either \"y\" or \"n\"");
				System.exit(0);
			}
		} else {
			System.out.println("please enter either \"y\" or \"n\"");
			System.exit(0);
		}	
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Account.txt"));
			accts = (ArrayList<Account>) in.readObject();
			for(Account acc:accts)
			{
				System.out.println(acc);
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
	}
}
