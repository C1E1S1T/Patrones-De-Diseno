package models;

public abstract class Account
{
	private double interest;
	
	public Account()
	{
		interest = defineInterest();
	}
	public abstract double defineInterest();
	
	public String show()
	{
		return interest+"%";
	}

}
