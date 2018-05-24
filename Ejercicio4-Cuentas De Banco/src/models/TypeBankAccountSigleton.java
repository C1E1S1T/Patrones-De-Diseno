package models;

public class TypeBankAccountSigleton
{
	private static TypeBankAccountFactory factory;
	private static TypeBankAccountSigleton sigleton;
	
	private TypeBankAccountSigleton()
	{
	
	}

	public static void setFactory(TypeBankAccountFactory factory)
	{
		TypeBankAccountSigleton.factory=factory;
	}
	
	public static TypeBankAccountSigleton getInstance()
	{
		if( sigleton == null  )
		{
			sigleton = new TypeBankAccountSigleton();
		}
		return sigleton;
	}
	
	public Debit getDebit()
	{
		return factory.createDebit();
	}
	
	public CreditCart getCreditCard()
	{
		return factory.createCreditCart();
	}
	
	public Account getAccount()
	{
		return factory.createAccount();
	}
	
}
