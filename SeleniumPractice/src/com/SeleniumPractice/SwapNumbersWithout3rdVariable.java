package com.SeleniumPractice;

import java.util.Scanner;

public class SwapNumbersWithout3rdVariable {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number A = ");
		int a = scan.nextInt();
		System.out.println("Enter Number B = ");
		int b= scan.nextInt();
		scan.close();
		System.out.println("Before swapping: a = "+a+"; b = "+b);
		
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println("After swapping: a = "+a+"; b = "+b);

	}

}
