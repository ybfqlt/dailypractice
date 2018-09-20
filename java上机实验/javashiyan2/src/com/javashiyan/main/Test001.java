package com.javashiyan.main;

import java.util.*;
import java.io.*;
import java.text.*;

class Account{
	private String account;//账户
	private int id;
	private double balance;  ///余额
	private String kaihutime;
	public String name;
	public int password;
	private double annualInterestRate;
	Date dataCreated;
	Account(String account,String name,int password){
		this.account=account;
		this.name=name;
		this.password=password;
	}
	public void Account(String account,String name,int password,String time,int id,int balance){
		this.account=account;
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
		this.annualInterestRate=annualInterestRate;
	}
	public String gettime() {
		dataCreated = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    String dateString = formatter.format(dataCreated);
		return dateString;
	}
	public double getMonthlyInterestRate() {
		return balance*((annualInterestRate/100)/12.0);
	}
	public void withDraw() {
		while(true){
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入密码:");
			int mima=sc.nextInt();
			if(mima==password) {
				System.out.println("请输入取款金额:");
				int quqian=sc.nextInt();
				if(quqian<=balance) {
					balance= balance-quqian;
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
		System.out.println("账户:"+account+"    名字:"+name+"      余额"+balance+"     开户时间:"+kaihutime);
	}
}
public class Test001 {
	public static void main(String[] args) {
		
		Account acc = new Account("10010","阿桦",123);
	    String time=acc.gettime();
	    acc.Account("10010","阿桦",123,time,1,0);
	    Scanner sc = new Scanner(System.in);
	    int s;
		do {
		    System.out.println("请输入需要执行的操作");
		    System.out.println("***1银行账户信息***");
		    System.out.println("***2取款操作***");
		    System.out.println("***3存款操作***");
		    System.out.println("***4退出系统***");
		    s = sc.nextInt();
			switch(s) {
			case 1:
				System.out.println("***银行账户信息***");
				acc.show();
				break;
			case 2:
				System.out.println("***取款操作***");
				acc.withDraw();
				break;
			case 3:
				System.out.println("***存款操作***");
				acc.deposit(1000);
				break;
			case 4:
				System.exit(0);
				break;
			}
	    }while(s!=4);
	}
}
