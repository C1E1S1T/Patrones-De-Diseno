package models;

public interface TypeBankAccountFactory
{
	public Debit createDebit();
	public Account createAccount();
	public CreditCart createCreditCart();
}
