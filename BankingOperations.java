package com.edu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class MyException extends Exception{
	MyException(String s){
		super(s);
	}
}


public class BankingOperations {
	
	static Connection myconn = null;
	static ResultSet rs = null;
	static Statement st = null;
	static Scanner sc = new Scanner(System.in);
	static String Acc_no;
	static String name;
	static String Acc_type;
	static String mobno;
	static int balance;
	
	public static void createAccount() {
		try {
			myconn = DbConnect.getConnection();
			st = myconn.createStatement();
			sc = new Scanner(System.in);
	
			String sql = "select * from banklogin where Acc_no = "+Acc_no;
			rs = st.executeQuery(sql);
			
			if(!rs.next()) {
				System.out.println("Enter the Account Number :");
				Acc_no = sc.next();
				System.out.println("Enter the Name ");
				name = sc.next();
				System.out.println("Enter the Account type ");
				Acc_type = sc.next();
				System.out.println("Enter Mobile Number ");
				mobno = sc.next();
				
				String ins = "insert into banklogin values("+Acc_no+",'"+name+"','"+Acc_type+"','"+mobno+"',"+balance+")";
				int i = st.executeUpdate(ins);
				if(i>0){
					System.out.println("Account holder Info Registerd");
				}
			}
			else {
				System.out.println("Acc_no already exists choose another id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	public static void displayAccountdetails() {	
			//1. get Connection
			try {
			myconn = DbConnect.getConnection();
			st = myconn.createStatement();
			
			String sql = "select * from banklogin";
			rs = st.executeQuery(sql);
			System.out.format("ACC_NO"+" "+"NAME"+" "+"ACC_TYPE"+" "+"MOBNO");
			System.out.println();
			while(rs.next()) {
				System.out.println(rs.getString("Acc_no")+"\t"+ rs.getString("name")+"\t"+rs.getString("Acc_type")+"\t"+rs.getString("mobno")+"\t"+rs.getString("balance"));
			}
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	public static void depositAmount() {
	   
		   System.out.println("Enter the account number you want to deposit ");
		   
		   String Acc_no = sc.next();
		   System.out.println("Enter the amount you want to deposit ");
	       int amt = sc.nextInt();
	       

		try {
			myconn = DbConnect.getConnection();
			st = myconn.createStatement();
			
			String sql = "select * from banklogin where Acc_no = "+Acc_no;
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				
				String ins = "update banklogin set balance = balance + "+amt+" where Acc_no = "+Acc_no;
				//amt = balance + amt
				int i = st.executeUpdate(ins);
				if(i>0){
					System.out.println("Amount  Deposited");
				}
			}
			else {
				System.out.println("Enter valid Amount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void withdrawAmount() {
	   System.out.println("Enter the account number you want to withdraw ");
		   
		   String Acc_no = sc.next();
		   System.out.println("Enter the amount you want to withdraw ");
	       int amt = sc.nextInt();
	       

		try {
			myconn = DbConnect.getConnection();
			st = myconn.createStatement();
			
			String sql = "select * from banklogin where Acc_no = "+Acc_no;
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				
				String ins = "update banklogin set balance = balance - "+amt+" where Acc_no = "+Acc_no;
				//amt = balance + amt
				int i = st.executeUpdate(ins);
				if(i>0){
					System.out.println("Amount  Withdrawn");
				}
			}
			else {
				System.out.println("Insufficient balance!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void displayDetailsBasedOnAccountNumber() {	
			//1. get Connection
			try {
			myconn = DbConnect.getConnection();
			st = myconn.createStatement();
			
			System.out.println("Enter your Account number to View Details");
			String Acc_no =sc.next(); 
			
			String sql = "select * from banklogin where Acc_no = "+Acc_no;
			rs = st.executeQuery(sql);
			System.out.format("ACC_NO"+" "+"NAME"+" "+"ACC_TYPE"+" "+"MOBNO"+ "BALANCE");
			System.out.println();
			while(rs.next()) {
				System.out.println(rs.getString("Acc_no")+"\t"+ rs.getString("name")+"\t"+rs.getString("Acc_type")+"\t"+rs.getString("mobno")+"\t"+rs.getString("balance"));
			}
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	
	public static void CurrentBalance() {
		//1. get Connection
		try {
		myconn = DbConnect.getConnection();
		st = myconn.createStatement();
		
		System.out.println("Enter your Account number to View Balance");
		String Acc_no =sc.next(); 
		
		String sql = "select * from banklogin where Acc_no = "+Acc_no;
		rs = st.executeQuery(sql);
		System.out.println();
		while(rs.next()) {
			System.out.println("Your Current Balance is :: "+rs.getString("balance"));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public static void Exit() {
		
		System.out.println("You Successfully Exited");
		System.exit(0);
	}

}
