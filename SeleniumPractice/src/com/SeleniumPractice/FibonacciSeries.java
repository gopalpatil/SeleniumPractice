package com.SeleniumPractice;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		int max_Num = 10;
		int previous_Num = 0;
		int next_Num = 1;	
		for(int i=0; i<max_Num; i++)
		{
			System.out.print(previous_Num+" ");
			int sum = previous_Num + next_Num;
			previous_Num = next_Num;
			next_Num = sum;
		}


	}

}
