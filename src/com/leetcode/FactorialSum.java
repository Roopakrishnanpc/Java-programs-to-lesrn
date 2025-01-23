package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FactorialSum 
{
	
	public static int factorialSum(int array_length, List<Integer> arr)
	{
		int count=0;
		for (int i=0;i<array_length;i++)
		{
			int factsum=arr.get(i);
			int sum=0;
			Set<Integer> factset=new HashSet<>();
			while(factsum >0)
			{
				int reminder=factsum%10;
				factset.add(reminder);
				sum +=reminder;
				factsum /=10;
			//System.out.println("reminder"+sum);
			}

			System.out.println(sum);
			int factSumResult=0;
			while(sum >0)
			{
				int reminder=sum%10;
				
				factSumResult +=reminder;
				sum /=10;
			//System.out.println("reminder"+sum);
			}
			System.out.println(factSumResult);
			int fact=1;
			if(factSumResult>=10)
			{
				for(int i1=1; i1<10; i1++)
				{
					//System.out.println("poda");
					fact*=i1;
				}
			}
			else if(factSumResult ==0 || factSumResult ==1)
			{
				fact=1;
			}
			else
			{
			for(int i1=1; i1<=factSumResult; i1++)
			{
				fact*=i1;
			}
			}
			System.out.println(fact);
			int result=0;
			Set<Integer> set = new HashSet<>();

			while(fact>0)
			{
				int reminder=fact%10;
				//result +=reminder;
				fact /=10;
				set.add(reminder);
			}
			System.out.println(set);
			
			
			
//			Set<Integer> set=IntStream.of(fact).filter(e ->{
//
//				return result;}).boxed().collect(Collectors.toSet());
//			}
			//System.out.println(set);

			boolean setcontains=set.containsAll(factset);
			System.out.println(setcontains);
			if(setcontains==true)
			{
				count++;
			}

			
		}

		return count;
		
	}
public static void main (String[]args)
{
    int n = 9;
    List<Integer> arr
        = Arrays.asList(833, 3055, 8521, 360, 2202, 310, 2111,122, 1892982);

    // Function Call
   // factorialSum(n, arr);
    System.out.println(factorialSum(n, arr));
 int fact = 1;
 int sum = 0;
 int i, j = 1;
 for (i = 1; i <= 20; i++)
 {
   for (j = 1; j <= i; j++)
   {
	 //  System.out.println(j);
     fact = fact * j;
 }
 sum += fact;
 System.out.println ("sum = " + sum);
 fact = 1;
 }
 for (j = 1; j <= i; j++)
 {
	 //System.out.println(i);
	 //System.out.println(j);
   fact = fact * j;
 //  System.out.println(fact);
}
 System.out.println(fact);
}
}