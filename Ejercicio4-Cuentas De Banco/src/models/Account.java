package models;

public abstract class Account
{
	private int interest;
	
	public Account()
	{
		interest = defineInterest();
	}
	public abstract int defineInterest();
	
	public String show()
	{
		return interest+"%";
	}

}
