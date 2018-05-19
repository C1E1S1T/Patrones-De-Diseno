package tests.features;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.ExpressionMathematical;
import models.ExpressionMathematicalComposite;
import models.NumberLeaft;
import models.OperatorLeaft;

class ExpressioMathematicalTest
{

	@ Test
	void testToString_caseOneNumber_expectedStringNumber()
	{
		ExpressionMathematical expression = new NumberLeaft<Integer>(5);
		String actual = expression.toString();
		String expected = "5";
		assertEquals(expected, actual);
	}

	@ Test
	void testToString_caseOneOperation_expectedStringOperation()
	{
		ExpressionMathematical number1 = new NumberLeaft<Integer>(8);
		ExpressionMathematical number2 = new NumberLeaft<Integer>(3);
		ExpressionMathematical operator = new OperatorLeaft("*");
		ExpressionMathematical expression = new ExpressionMathematicalComposite(number1,
		               operator, number2);
		String actual = expression.toString();
		String expected = "(8*3)";
		assertEquals(expected, actual);
	}

	@ Test
	void testToString_caseOneExpressionComposite_expectedStringExpressionComposite()
	{
		ExpressionMathematical numberA = new NumberLeaft<Integer>(8);
		ExpressionMathematical numberB = new NumberLeaft<Integer>(3);
		ExpressionMathematical operatorC = new OperatorLeaft("*");
		ExpressionMathematical expressionA = new ExpressionMathematicalComposite(numberA,
		               operatorC, numberB);
		
		ExpressionMathematical numberD = new NumberLeaft<Integer>(1);
		ExpressionMathematical operatorD = new OperatorLeaft("+");
		ExpressionMathematical expression = new ExpressionMathematicalComposite(numberD,operatorD,expressionA);
		

		String actual = expression.toString();

		String expected = "(1+(8*3))";
		assertEquals(expected, actual);
	}

}
