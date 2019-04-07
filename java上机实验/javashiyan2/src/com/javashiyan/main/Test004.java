package com.javashiyan.main;

import java.util.Random;

class StopWatch{
	private long startTime;
	private long endTime;
	public StopWatch() {
		this.startTime=System.currentTimeMillis();
	}
	public void start() {
		this.startTime=System.currentTimeMillis();
	}
	public void stop() {
		this.endTime=System.currentTimeMillis();
	}
	public long getElapsedTime() {
		return (endTime-startTime);
	}
}
public class Test004 {

	public static void main(String[] args) {
		StopWatch time=new StopWatch();
		long[] a=new long[100000];
		Random random1=new Random(1);
		for(int h=0;h<2;h++) {
			for(int k=0;k<50000;k++) {
			    a[k]=random1.nextInt(10000);
			}
		}
		for(int i=0;i<a.length;i++) {
			int t=i;
			for(int j=t+1;j<a.length;j++) {
				if(a[j]<a[t]) {
					t=j;
				}
			}
			if(i!=t) {
				long temp=a[i];
				a[i]=a[t];
				a[t]=temp;
			}
		}
		time.stop();
		System.out.println("time:"+time.getElapsedTime());

	}

}
