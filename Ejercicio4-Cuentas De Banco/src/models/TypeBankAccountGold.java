package models;

public class TypeBankAccountGold implements TypeBankAccountFactory
{

	@ Override
	public Debit createDebit()
	{
		return new DebitGold();
	}

	@ Override
	public Account createAccount()
	{
		return new AccountGold();
	}

	@ Override
	public CreditCart createCreditCart()
	{
		return new CreditCartGold();
	}

}
