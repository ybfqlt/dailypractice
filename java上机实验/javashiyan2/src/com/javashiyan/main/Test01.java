package com.javashiyan.main;

import java.util.*;
import java.io.*;
import java.text.*;

class Account{
	private int id;
	private double balance;  ///余额
	private String kaihutime;
	public String name;
	public int password;
	private double annualInterestRate;
	Date dataCreated;
	Account(){
		this.id=0;
		this.balance=0;
		this.annualInterestRate=0;
	}
	public void Account(String name,int password,String time,int id,int balance){
		this.name=name;
		this.password=password;
		this.kaihutime=time;
		this.id=id;
		this.balance=balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getbalance() {
		return balance;
	}
	public void setbalance(double balance) {
		this.balance=balance;
	}
	public double getannualInterestRate(){
		return annualInterestRate;
	}
	public void setannualInterestRate(double bannualInterestRate) {
		this.annualInterestRate=bannualInterestRate/100.0;
	}
	public String gettime() {
		dataCreated = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(dataCreated);
		return dateString;
	}
	public double getMonthlyInterestRate() {
		return (balance*(annualInterestRate/12));
	}
	public void withDraw(int m) {
		while(true){
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入密码:");
			int mima=sc.nextInt();
			if(mima==password) {
				if(m<=balance) {
					balance= balance-m;
					System.out.println("此次取款:"+m);
					System.out.println("余额为：" +balance);
				}else {
					System.out.println("当前余额不足!");
				}
				break;
			}else{
				System.out.println("你输入的密码有误，请重新输入！");
			}
		}
	}
	public void deposit(int moneys) {
		balance=balance+moneys;
		System.out.println("此次存款为:"+ moneys);
		System.out.println("账户余额为:"+ balance);	
	}
	public void show() {
		System.out.println("ID:"+id+"    名字:"+name+"      余额"+balance+"     开户时间:"+kaihutime);
	}
}
public class Test001 {
	public static void main(String[] args) {
		
		Account acc = new Account();
	    String time=acc.gettime();
	    acc.Account("阿甜",123,time,1122,20000);
	    acc.setannualInterestRate(4.5);
	    Scanner sc = new Scanner(System.in);
	    int s;
		System.out.println("***银行账户信息***");
		acc.show();
		System.out.println("***取款操作***");
		acc.withDraw(2500);
		System.out.println("***存款操作***");
		acc.deposit(3000);
	    System.out.println("月利息:"+acc.getMonthlyInterestRate());
	}
}
