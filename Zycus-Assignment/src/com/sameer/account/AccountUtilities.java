package com.sameer.account;

import java.util.List;
import java.util.TreeSet;
/**
 * 
 * @author Sameer A. Gaware
 *
 *Handy methods to calculate the interest,get largest digit etc.
 */
public class AccountUtilities {


	/**
	 * This method calculates the interest amount based on the interest rate
	 * @param amount
	 * @param interestAmount
	 * @return
	 */
	public static double calculateInterest(int amount, double interestRate) 
	{
		double interestAmount = (amount/100)*interestRate; 
		return interestAmount; 
	}

	/**
	 * This method calculates the average of all the interest 
	 * @param List of interest  - interestList
	 * @return Average of interest  - averageInterest
	 */
	public static double getAverageInterest(List<Double> interestList) {
		double totalInterest = getTotalInterest(interestList);
		double averageInterest = totalInterest/interestList.size();

		return averageInterest;
	}

	/**
	 *This method calculates the total interest
	 * @param List of interest  - interestList
	 * @return Total of interest  - averageInterest
	 */
	public static double getTotalInterest(List<Double> interestList) {
		double totalInterest = 0 ;
		for(int index = 0 ; index < interestList.size() ; index++)
		{
			totalInterest += interestList.get(index);
		}
		return totalInterest;
	}

	/**
	 *Takes Student Id in String format & return's  the largest digit (number).
	 * @param studentId in String format
	 * @return Largest digit in number.
	 */
	public static int getLargestDigit(String studentId) {
		if(studentId == null || studentId.length() == 0)
			return 0;

		TreeSet<Integer> onlyNumbersList = new TreeSet<>();

		for(int index = 0 ; index < studentId.length() ; index++)
		{
			if((studentId.charAt(index)+"").matches("\\d"))
				onlyNumbersList.add(Integer.parseInt(studentId.charAt(index)+""));
		}

		if(onlyNumbersList.size() == 0)
			return 0;

		return onlyNumbersList.last();
	}

}

