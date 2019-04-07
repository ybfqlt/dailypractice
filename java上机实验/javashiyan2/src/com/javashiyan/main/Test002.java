package com.javashiyan.main;

import java.util.Scanner;

class QuadraticEquation{
	int a,b,c;
	QuadraticEquation(int d,int e,int f) {
		a=d;
		b=e;
		c=f;
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
	public double getDiscriminant() {
		return (b*b-4*a*c);		
	}
	
	public double getRoot1() {
		return ((-b+Math.sqrt(b*b-4*a*c))/(2*a));
	}
	public double getRoot2() {
		return ((-b-Math.sqrt(b*b-4*a*c))/(2*a));
	}
}

public class Test002 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		int b=input.nextInt();
		int c=input.nextInt();
		QuadraticEquation qua=new QuadraticEquation(a,b,c);
		System.out.println("b^2-4*a*c = "+qua.getDiscriminant());
		if(qua.getDiscriminant()>0) {
			System.out.println("此方程有两个根:");
			System.out.println("root1 = "+qua.getRoot1());
			System.out.println("root2 = "+qua.getRoot2());
		}
		else if(qua.getDiscriminant()==0) {
			System.out.println("此方程有一个根:");
			System.out.println("Root = "+qua.getRoot1());
		}
		else {
			System.out.println("The equation has no roots.");
		}
	}

}
