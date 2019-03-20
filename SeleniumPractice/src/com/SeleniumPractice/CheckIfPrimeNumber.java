package com.SeleniumPractice;

import java.util.Scanner;

public class CheckIfPrimeNumber {

	public static void main(String[] args) {
		
		System.out.println("Enter Number = ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.close();
		
		boolean isPrime = true;
		for(int i=2; i<=num/2; i++)
		{
			if(num%2==0)
			{
				isPrime = false;
				break;
			}
		}
		if(isPrime)
		{
			System.out.println(num+" is a Prime Number");
		}
		else
		{
			System.out.println(num+" is not a Prime Number");
		}

	}

}
