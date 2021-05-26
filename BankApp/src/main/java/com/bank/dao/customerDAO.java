package com.bank.dao;
import model.*;
import java.util.List;

public interface customerDAO {
   public List<Account> getListOfAccount(Customer cus);
   public boolean createAccount();
   public boolean deleteAccount(Account acct);
   public boolean depositAccount(Customer cus, double amount);
   public boolean withdrawAccount(Customer cus, double amount);
   public boolean loginAccount(Customer cus);
   public boolean registerUser(Customer cus);
}
