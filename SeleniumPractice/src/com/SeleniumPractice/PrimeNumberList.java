package com.SeleniumPractice;

public class PrimeNumberList {

	public static void main(String[] args) {
		
		int num = 1;
		int count = 0;
		for(int j=1; count<10; j++)
		{
			boolean isPrime = true;
			num = num + 1;
			aa:
			for(int i=2; i<=num/2;i++)
			{
				if(num%i==0)
				{
					isPrime = false;
					break aa;
				}
			}
			if(isPrime)
			{
				count = count+1;
				System.out.println(num+", ");
			}
		}


	}

}
