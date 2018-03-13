package com.sameer.account;

/**
 * 
 * @author Sameer A. Gaware
 *
 */
public class Account {

	//No instance variable.
	public Account()
	{
		//Not done any initialization here  
	}

	/**
	 * This method takes input as amount and returns the interest on that amount
	 * @param amount
	 * @return interest amount
	 */
	public double interest(int amount) 
	{ 
		if(amount == 0 || amount <= 1000)
			return 0;

		else if(amount >= 1001 && amount <= 5000)
			return AccountUtilities.calculateInterest(amount,2.5);

		else if(amount >= 5001 && amount <= 10000)
			return AccountUtilities.calculateInterest(amount,5);

		return AccountUtilities.calculateInterest(amount,8);
	}
	
	/**
	 * This method determine accounts with no interest
	 * @param interest
	 * @return 0 if interest is 0
	 */
	public int interestType(double interest) 
	{ 
		if(interest == 0)
			return 0;

		return -1;
	}

}

