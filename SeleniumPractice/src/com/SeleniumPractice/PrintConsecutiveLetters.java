package com.SeleniumPractice;

import java.util.Scanner;

public class PrintConsecutiveLetters {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a String = ");
		String str = scan.next();
		scan.close();
		System.out.println("Entered String = "+str);
		
		int len = str.length();
		int count = 1;
		String outputString="";
		
		for(int i=0;i<len-1;i++)
		{			
				if(str.charAt(i)==str.charAt(i+1))
				{
					count++;
				}
				else
				{
					outputString = outputString + str.charAt(i) + count;
					count=1;
				}							
		}	
		outputString = outputString + str.charAt(len-1) + count;
		System.out.println(outputString);
	//***********************************************************************************************	
		outputString="";
		count=1;
		for(int i=0;i<len-1;i++)
		{			
				if(str.charAt(i)==str.charAt(i+1))
				{
					count++;
				}
				else
				{
					if(count>1)
					{
						outputString = outputString + str.charAt(i) + count;
					}
					
					count=1;
				}							
		}	
		if(count>1)
		{
			outputString = outputString + str.charAt(len-1) + count;
		}
		
		System.out.println(outputString);
		
		//***********************************************************************************************	
				
				count=1;
				String str1="";
				for(int i=0;i<len-1;i++)
				{			
						if(str.charAt(i)==str.charAt(i+1))
						{
							str1 = str1 +str.charAt(i);
							count++;
						}
						else
						{
							if(count>1)
							{
								str1 = str1 +str.charAt(i);
							}
							
							count=1;
						}							
				}	
				if(count>1)
				{
					str1 = str1 +str.charAt(len-1);
				}
				
				System.out.println(str1);
		
//***********************************************************************************************	
				
				
				
			/*	for(int i=1;i<len;i++)
				{			
						if(str.charAt(i)+0 ==str.charAt(i-1)+1)
						{
							System.out.print(str.charAt(i));
						}
						else
						{
							System.out.println(str.charAt(i));
						}							
				}	*/
			
				

	}

}
