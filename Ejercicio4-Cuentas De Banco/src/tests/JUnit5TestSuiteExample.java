package tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({TypeBankAccountTest.class,TypeBankAccount10Test.class})
public class JUnit5TestSuiteExample
{
}
