package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import models.Account;
import models.CreditCart;
import models.Debit;
import models.TypeBankAccountFactory;
import models.TypeBankAccountSigleton;

public abstract class TypeBankAccountTest
{

	protected TypeBankAccountSigleton typeBankAccount;

	public TypeBankAccountTest()
	{
		TypeBankAccountSigleton.setFactory(defineFactory());
		typeBankAccount = TypeBankAccountSigleton.getInstance();
	}

	public abstract TypeBankAccountFactory defineFactory();

	@ Test
	void testShow_caseAccount()
	{
		Account account = typeBankAccount.getAccount();
		String actual = account.show();
		String expected = testShow_caseAccount_defineExpected();
		assertEquals(expected, actual);
	}

	public abstract String testShow_caseAccount_defineExpected();

	@ Test
	void testShow_caseDebit()
	{
		Debit debit = typeBankAccount.getDebit();
		String actual = debit.show();
		String expected = testShow_caseDebit_defineExpected();
		assertEquals(expected, actual);
	}

	public abstract String testShow_caseDebit_defineExpected();

	@ Test
	void testShow_caseCreditCard()
	{
		CreditCart creditCart = typeBankAccount.getCreditCard();
		String actual = creditCart.show();
		String expected = testShow_caseCreditCard_defineExpected();
		assertEquals(expected, actual);
	}

	public abstract String testShow_caseCreditCard_defineExpected();

}