package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import models.Account;
import models.CreditCart;
import models.Debit;
import models.TypeBankAccountGold;
import models.TypeBankAccountSigleton;

class TypeBankAccountAccountGoldTest
{

	private static TypeBankAccountSigleton typeBankAccount;

	@ BeforeAll
	static void setUpBeforeClass() throws Exception
	{
		TypeBankAccountSigleton.setFactory(new TypeBankAccountGold());
		typeBankAccount = TypeBankAccountSigleton.getInstance();
	}
	
	@ Test
	void testShow_caseAccount()
	{
		Account account = typeBankAccount.getAccount();
		String actual = account.show();
		String expected = "2.0%";
		assertEquals(expected, actual);
	}

	@ Test
	void testShow_caseDebit()
	{
		Debit debit = typeBankAccount.getDebit();
		String actual = debit.show();
		String expected = "5 E";
		assertEquals(expected, actual);
	}

	@ Test
	void testShow_caseCreditCard()
	{
		CreditCart creditCart = typeBankAccount.getCreditCard();
		String actual = creditCart.show();
		String expected = "20 Euros Max. 4000 E";
		assertEquals(expected, actual);
	}
}
