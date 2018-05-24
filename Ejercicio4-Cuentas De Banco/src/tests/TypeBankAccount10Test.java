package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import models.Account;
import models.CreditCart;
import models.Debit;
import models.TypeBankAccount10;
import models.TypeBankAccountSigleton;

class TypeBankAccount10Test
{
	private static TypeBankAccountSigleton typeBankAccount;

	@ BeforeAll
	static void setUpBeforeClass() throws Exception
	{
		TypeBankAccountSigleton.setFactory(new TypeBankAccount10());
		typeBankAccount = TypeBankAccountSigleton.getInstance();
	}
	
	@ Test
	void testShow_caseAccount()
	{
		Account account = typeBankAccount.getAccount();
		String actual = account.show();
		String expected = "1.5%";
		assertEquals(expected, actual);
	}

	@ Test
	void testShow_caseDebit()
	{
		Debit debit = typeBankAccount.getDebit();
		String actual = debit.show();
		String expected = "Gratuita";
		assertEquals(expected, actual);
	}

	@ Test
	void testShow_caseCreditCard()
	{
		CreditCart creditCart = typeBankAccount.getCreditCard();
		String actual = creditCart.show();
		String expected = "10 Euros Max. 2000 E";
		assertEquals(expected, actual);
	}

}
