package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Account;
import models.CreditCart;
import models.Debit;
import models.TypeBankAccountYoung;
import models.TypeBankAccountSigleton;

class TypeBankAccountYoungTest
{
	private TypeBankAccountSigleton typeBankAccount;

	@ BeforeEach
	void setUp()
	{
		TypeBankAccountSigleton.setFactory(new TypeBankAccountYoung());
		typeBankAccount = TypeBankAccountSigleton.getInstance();
	}

	@ Test
	void testShow_caseAccountYoung()
	{
		Account account = typeBankAccount.getAccount();
		String actual = account.show();
		String expected = "1%";
		assertEquals(expected, actual);
	}

	@ Test
	void testShow_caseDebitYoung()
	{
		Debit debit = typeBankAccount.getDebit();
		String actual = debit.show();
		String expected = "Gratuita";
		assertEquals(expected, actual);
	}

	@ Test
	void testShow_caseCreditCardYoung()
	{
		CreditCart creditCart = typeBankAccount.getCreditCard();
		String actual = creditCart.show();
		String expected = "Gratuita Max. 600";
		assertEquals(expected, actual);
	}

}
