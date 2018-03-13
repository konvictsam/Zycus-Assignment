package com.sameer.testerclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

import com.sameer.account.Account;
import com.sameer.account.AccountUtilities;
/**
 * 
 * @author Sameer A. Gaware
 *
 */
public class AccountTest{

	public static void main(String[] args) {
		
		System.out.println("**************Welcome*********************"); 
		System.out.println("Enter Student Id :");
		Scanner sc = new Scanner(System.in); 
		String studentId = sc.nextLine();
		List<Double> interestSet = new ArrayList<>();

		int zeroInterestAccountCount = 0;

		final int N = AccountUtilities.getLargestDigit(studentId); 

		for(int accountCount = 1 ; accountCount <= N ; accountCount++)
		{

			System.out.println("Enter the amount for account number "+accountCount+": "); 
			int amount = sc.nextInt();

			Account acc = new Account();

			double interest = acc.interest(amount);
			System.out.println("The interest for account number "+accountCount+" is $"+interest); 

			int interestTypeVal = acc.interestType(interest);

			if(interestTypeVal == 0)
				zeroInterestAccountCount += 1;

			interestSet.add(interest);
		}

		Collections.sort(interestSet); 
		double totalInterest = AccountUtilities.getTotalInterest(interestSet); 
		double averageInterest = AccountUtilities.getAverageInterest(interestSet);

		System.out.println("--------------------------------------------------Interest Details-----------------------------"); 
		System.out.println("Total Interest: $"+totalInterest);
		System.out.println("Lowest Interest: $"+interestSet.get(0));
		System.out.println("Highest Interest: $"+interestSet.get(interestSet.size()-1)); 
		System.out.println("Average Interest: $"+averageInterest);
		System.out.println("Number of accounts with no interest: "+zeroInterestAccountCount);  


		sc.close();
	}

	

}
