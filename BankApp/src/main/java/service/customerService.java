package service;

import com.bank.dao.*;
import model.*;
import java.util.*;

public class customerService {
	private customerDAO cusDAO = new customerDAOImpl();

	public boolean registerUser() {
		Customer cust = new Customer();
		String firstName, lastName, userName, password;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your first name=>");
		firstName = sc.nextLine();
		System.out.print("Please enter your last name=>");
		lastName = sc.nextLine();
		System.out.print("Please enter your user name=>");
		userName = sc.nextLine();
		System.out.print("Please enter your password=>");
		password = sc.nextLine();
		cust.setFirstName(firstName);
		cust.setLastName(lastName);
		cust.setUserName(userName);
		cust.setPassWord(password);
		return cusDAO.registerUser(cust);
	}

	public boolean createAccount() {
		return cusDAO.createAccount();
	}
	
	public boolean loginAccount() {
		Customer cust = new Customer();
		String userName, password;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your user name=>");
		userName = sc.nextLine();
		System.out.print("Please enter your password=>");
		password = sc.nextLine();
		cust.setUserName(userName);
		cust.setPassWord(password);
		return cusDAO.loginAccount(cust);
	}
	
	public void depositMoney() {
		Customer cus=new Customer();
		Scanner sc=new Scanner(System.in);
		double amount;
		System.out.print("Please enter a user name=> ");
		Scanner sc1=new Scanner(System.in);
		String name;
		name=sc1.nextLine();
		cus.setUserName(name);
		System.out.print("How much money do you want to deposit?=> ");
		try {
			amount = sc.nextDouble();
			if(amount<0) {
				System.out.println("Please enter a valid amount!");
				System.exit(0);
			}
			else
				cusDAO.depositAccount(cus, amount);
		} catch (Exception e) {
			System.out.println("Please enter a valid amount!");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void withdrawMoney() {
		Customer cus=new Customer();
		Scanner sc=new Scanner(System.in);
		double amount;
		System.out.print("Please enter a user name=> ");
		Scanner sc1=new Scanner(System.in);
		String name;
		name=sc1.nextLine();
		cus.setUserName(name);
		System.out.print("How much money do you want to withdraw?=> ");
		try {
			amount = sc.nextDouble();
			if(amount<0) {
				System.out.println("Please enter a valid amount!");
				System.exit(0);
			}
			else
				cusDAO.withdrawAccount(cus, amount);
		} catch (Exception e) {
			System.out.println("Please enter a valid amount!");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}
