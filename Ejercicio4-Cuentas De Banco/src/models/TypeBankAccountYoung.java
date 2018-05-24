package models;

public class TypeBankAccountYoung implements TypeBankAccountFactory
{

	@ Override
	public Debit createDebit()
	{
		return new DebitYoung();
	}

	@ Override
	public Account createAccount()
	{
		return new AccountYoung();
	}

	@ Override
	public CreditCart createCreditCart()
	{
		return new CreditCardYoung();
	}


}
