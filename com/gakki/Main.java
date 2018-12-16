package com.gakki;

public class Main {

    public static void main(String[] args) {
	    System.out.print("helloworld");
	    int N = 10;
	    double a[]= new double[N];
//	    a[0] = 1;
//	    for (int i = 0; i < 10; i++)
//			a[i] = 0;
//	    a = {1,2,3,4,5,6,7,8,9,10};
		for (int i = 0; i < 10; i ++)
	    	System.out.print(a[i]+"\t");
		double b = Math.exp(a[0]);
		System.out.print("\nb="+b);

	}
}
