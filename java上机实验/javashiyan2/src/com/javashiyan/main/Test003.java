package com.javashiyan.main;

import java.util.Scanner;

class LinearEquation{
	int a,b,c,d,e,f;
	LinearEquation(int g,int h,int i,int j,int k,int l){
		a=g;
		b=h;
		c=i;
		d=j;
		e=k;
		f=l;
	}
	public int geta() {
		return a;
	}
	
	public int getb() {
		return b;
	}
	public int getc() {
		return c;
	}
	public int getd() {
		return d;
	}
	public int gete() {
		return e;
	}
	public int getf() {
		return f;
	}
	
	public boolean isSolvable() {
		if((a*d-b*c)!=0){
			return true;
		}
		return false;
	}
	public double getX() {
		return ((e*d-b*f)/(1.0*(a*d-b*c)));
	}
    public double getY() {
		return ((a*f-e*c)/(1.0*(a*d-b*c)));
	}
}

public class Test003 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		int b=input.nextInt();
		int c=input.nextInt();
		int d=input.nextInt();
		int e=input.nextInt();
		int f=input.nextInt();
		LinearEquation lin=new LinearEquation(a,b,c,d,e,f);
		if(lin.isSolvable()==true) {
			System.out.printf("x:%.2f    y:%.2f ",lin.getX(),lin.getY());
		}
		else {
			System.out.println("he equation has no solution.");
		}
		
	}
}
