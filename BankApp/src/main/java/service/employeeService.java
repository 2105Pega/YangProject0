package service;

import com.bank.dao.*;
import model.*;
import java.util.*;

public class employeeService {
	private employeeDAO empDAO = new employeeDAOImpl();

	public boolean loginAccount() {
		String id, pin;
		System.out.print("Please enter your user name=>");
		Scanner sc = new Scanner(System.in);
		id = sc.nextLine();
		System.out.print("Please enter your password=>");
		pin = sc.nextLine();
		return empDAO.loginAccount(id, pin);
	}

	public boolean approveAccount() {
		int customerID=1, accountNum=1;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the customer's ID=>");
		try {
			customerID = sc.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter a valid customer ID!");
			e.printStackTrace();
			System.exit(1);
		}
		Scanner sc1 = new Scanner(System.in);
		System.out.print("Please enter the account number=>");
		try {
			accountNum=sc1.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter a valid account number!");
			e.printStackTrace();
			System.exit(1);
		}
		return empDAO.approveAccount(customerID,accountNum);
	}
}
