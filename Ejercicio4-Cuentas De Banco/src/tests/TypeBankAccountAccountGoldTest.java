package tests;

import models.TypeBankAccountFactory;
import models.TypeBankAccountGold;

class TypeBankAccountAccountGoldTest extends TypeBankAccountTest
{

	@ Override
	public TypeBankAccountFactory defineFactory()
	{
		return new TypeBankAccountGold();
	}

	@ Override
	public String testShow_caseAccount_defineExpected()
	{
		return "2.0%";
	}

	@ Override
	public String testShow_caseDebit_defineExpected()
	{
		return "5 E";
	}

	@ Override
	public String testShow_caseCreditCard_defineExpected()
	{
		return "20 Euros Max. 4000 E";
	}

}
