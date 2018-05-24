package models;

public class TypeBankAccount10 implements TypeBankAccountFactory
{

	@ Override
	public Debit createDebit()
	{
		return new Debit10();
	}

	@ Override
	public Account createAccount()
	{
		return new Account10();
	}

	@ Override
	public CreditCart createCreditCart()
	{
		return new CreditCard10();
	}

}
