package tests;

import models.TypeBankAccount10;
import models.TypeBankAccountFactory;

class TypeBankAccount10Test extends TypeBankAccountTest
{

	@ Override
	public TypeBankAccountFactory defineFactory()
	{
		return new TypeBankAccount10();
	}

	@ Override
	public String testShow_caseAccount_defineExpected()
	{
		return "1.5%";
	}

	@ Override
	public String testShow_caseDebit_defineExpected()
	{
		return "Gratuita";
	}

	@ Override
	public String testShow_caseCreditCard_defineExpected()
	{
		return "10 Euros Max. 2000 E";
	}

}
