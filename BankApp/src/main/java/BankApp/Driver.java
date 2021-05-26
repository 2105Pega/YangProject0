package BankApp;

import BankApp.*;
import java.sql.*;
import java.util.Scanner;

import model.*;
import service.*;

public class Driver {
	public static void main(String[] args) {
		customerService cus = new customerService();
		employeeService emp=new employeeService();
		String answer;
		System.out.println("==================================================================");
		System.out.println("====================Welcome to bank app!==========================");
		System.out.println("==================================================================");
		System.out.print("Are going to register as a customer? y/n=> ");
		Scanner un = new Scanner(System.in);
		answer=un.nextLine();
		if (answer.trim().toLowerCase().equals("y")) {
			if(cus.registerUser()) {
				System.out.println("You successfully registered!");
			}
		}
		else if (answer.trim().toLowerCase().equals("n")) {

		} else {
			System.out.println("please enter either \"y\" or \"n\"");
			System.exit(0);
		}
	
		System.out.print("Are going to login as a customer? y/n=> ");
		Scanner un2 = new Scanner(System.in);
		answer=un2.nextLine();
		if (answer.trim().toLowerCase().equals("y")) {
			if(cus.loginAccount())
			{
				System.out.println("Successfully logged in!");
			}
			else
			{
				System.out.println("Please enter a valid username and password!");
				System.exit(0);
			}
			System.out.print("Are going to apply for an account? y/n=> ");
			Scanner un1 = new Scanner(System.in);
			answer=un1.nextLine();
			if (answer.trim().toLowerCase().equals("y")) {
				if(cus.createAccount()) {
					System.out.println("You successfully applied for an account!");
				}
			}
			else if (answer.trim().toLowerCase().equals("n")) {

			} else {
				System.out.println("please enter either \"y\" or \"n\"");
				System.exit(0);
			}
			System.out.print("Are going to deposit? y/n=> ");
			Scanner un6 = new Scanner(System.in);
			answer=un6.nextLine();
			if (answer.trim().toLowerCase().equals("y")) {
				cus.depositMoney();
				System.out.println("Deposit succeeded!");
			}
			else if (answer.trim().toLowerCase().equals("n")) {

			} else {
				System.out.println("please enter either \"y\" or \"n\"");
				System.exit(0);
			}
			System.out.print("Are going to withdraw money? y/n=> ");
			Scanner un7 = new Scanner(System.in);
			answer=un7.nextLine();
			if (answer.trim().toLowerCase().equals("y")) {
				cus.withdrawMoney();
				System.out.println("Withdraw succeeded!");
			}
			else if (answer.trim().toLowerCase().equals("n")) {

			} else {
				System.out.println("please enter either \"y\" or \"n\"");
				System.exit(0);
			}
		}
		else if (answer.trim().toLowerCase().equals("n")) {

		} else {
			System.out.println("please enter either \"y\" or \"n\"");
			System.exit(0);
		}
		System.out.print("Are going to login as an employee? y/n=> ");
		Scanner un3 = new Scanner(System.in);
		answer=un3.nextLine();
		if (answer.trim().toLowerCase().equals("y")) {
			if(emp.loginAccount())
			{
				System.out.println("Successfully logged in!");
				System.out.print("Are going to approve an employee? y/n=> ");
				Scanner un4 = new Scanner(System.in);
				answer=un4.nextLine();
				if (answer.trim().toLowerCase().equals("y")) {
					if(emp.approveAccount())
						System.out.println("The account has been successfully approved!");
					else
						System.out.println("Approval failure!");
				}
				else if (answer.trim().toLowerCase().equals("n")) {

				} else {
					System.out.println("please enter either \"y\" or \"n\"");
					System.exit(0);
				}
			}
			else
			{
				System.out.println("Please enter a valid username and password!");
				System.exit(0);
			}
		}
		else if (answer.trim().toLowerCase().equals("n")) {

		} else {
			System.out.println("please enter either \"y\" or \"n\"");
			System.exit(0);
		}
		System.out.print("Are you going to log out? y/n=>");
		Scanner sc=new Scanner(System.in);
		answer=sc.nextLine();
		if (answer.trim().toLowerCase().equals("y")) {
			System.exit(0);
		}
		else if (answer.trim().toLowerCase().equals("n")) {

		} else {
			System.out.println("please enter either \"y\" or \"n\"");
			System.exit(0);
		}
	}
}
