package com.javashiyan.main;

class regularpolygon{
	private int n;
	private double side;
	private double x;
	private double y;
	public regularpolygon() {
		this.n=3;
		this.side=1;
		this.x=0;
		this.y=0;
	}
	public regularpolygon(int m,double side1) {
		this.n=m;
		this.side=side1;
		this.x=0;
		this.y=0;
	}
	public regularpolygon(int b,double side2,double x1,double y1) {
		this.n=b;
		this.side=side2;
		this.x=x1;
		this.y=y1;
	}
	public void setn(int c) {
		this.n=c;
	}
	public int getn() {
		return n;
	}
	public void setside(double d) {
		this.side=d;
	}
	public double getside() {
		return side;
	}
	public void setx(double f) {
		this.x=f;
	}
	public double getx() {
		return x;
	}
	public void sety(double g) {
		this.y=g;
	}
	public double gety() {
		return y;
	}	
	public double getPerimeter() {
		return (n*side);
	}
	public double getArea() {
		return ((n*side*side)/(4*Math.tan(Math.PI/n)));
	}
}
public class Test005 {

	public static void main(String[] args) {
		regularpolygon reg=new regularpolygon();
		System.out.println("无参构造下:");
		System.out.printf("周长:%.2f   面积:%.4f",reg.getPerimeter(),reg.getArea());
		System.out.println();
		reg=new regularpolygon(6,4);
		System.out.println("参数为6,4下:");
		System.out.printf("周长:%.2f   面积:%.4f",reg.getPerimeter(),reg.getArea());
		System.out.println();
		reg=new regularpolygon(10,4,5.6,7.8);
		System.out.println("参数为10,4,5.6,7.8下:");
		System.out.printf("周长:%.2f   面积:%.4f",reg.getPerimeter(),reg.getArea());
		System.out.println();
	}

}
