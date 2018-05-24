package tests;

import models.TypeBankAccountFactory;
import models.TypeBankAccountYoung;

class TypeBankAccountYoungTest extends TypeBankAccountTest
{

	@ Override
	public TypeBankAccountFactory defineFactory()
	{
		return new TypeBankAccountYoung();
	}

	@ Override
	public String testShow_caseAccount_defineExpected()
	{
		return "1.0%";
	}

	@ Override
	public String testShow_caseDebit_defineExpected()
	{
		return "Gratuita";
	}

	@ Override
	public String testShow_caseCreditCard_defineExpected()
	{
		return "Gratuita Max. 600";
	}

}
