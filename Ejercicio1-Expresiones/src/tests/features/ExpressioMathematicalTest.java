package tests.features;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import models.InfixExpression;
import models.InfixExpressionComposite;
import models.NumberLeaft;
import models.Operator;
import models.OperatorLeaft;

class ExpressioMathematicalTest
{

	@ Test
	void testToString_caseOneNumber_expectedStringNumber()
	{
		InfixExpression expression = new NumberLeaft<Integer>(5);
		String actual = expression.toString();
		String expected = "5";
		assertEquals(expected, actual);
	}

	@ Test
	void testToString_caseOneOperation_expectedStringOperation()
	{
		InfixExpression number1 = new NumberLeaft<Integer>(8);
		InfixExpression number2 = new NumberLeaft<Integer>(3);
		OperatorLeaft operator = new OperatorLeaft(Operator.MULTIPLY);
		InfixExpression expression = new InfixExpressionComposite(number1, operator,
		               number2);
		String actual = expression.toString();
		String expected = "(8*3)";
		assertEquals(expected, actual);
	}

	@ Test
	void testToString_caseOneExpressionComposite_expectedStringExpressionComposite()
	{
		InfixExpression numberA = new NumberLeaft<Integer>(8);
		InfixExpression numberB = new NumberLeaft<Integer>(3);
		OperatorLeaft operatorC = new OperatorLeaft(Operator.MULTIPLY);
		InfixExpression expressionA = new InfixExpressionComposite(numberA, operatorC,
		               numberB);

		InfixExpression numberD = new NumberLeaft<Integer>(1);
		OperatorLeaft operatorD = new OperatorLeaft(Operator.ADD);
		InfixExpression expression = new InfixExpressionComposite(numberD, operatorD,
		               expressionA);

		String actual = expression.toString();

		String expected = "(1+8*3)";
		assertEquals(expected, actual);
	}

	@ Test
	void testAdd_caseOneExpressionComposite_expectedExpression()
	{
		InfixExpression numberA = new NumberLeaft<Integer>(8);
		InfixExpression numberB = new NumberLeaft<Integer>(3);
		OperatorLeaft operatorC = new OperatorLeaft(Operator.MULTIPLY);
		InfixExpression expressionA = new InfixExpressionComposite(numberA, operatorC,
		               numberB);

		InfixExpression numberD = new NumberLeaft<Integer>(1);
		OperatorLeaft operatorD = new OperatorLeaft(Operator.ADD);
		InfixExpressionComposite expression = new InfixExpressionComposite(numberD,
		               operatorD, expressionA);

		InfixExpression number = new NumberLeaft<Integer>(2);
		OperatorLeaft operator = new OperatorLeaft(Operator.ADD);
		expression.add(operator, number);

		String actual = expression.toString();

		String expected = "(1+8*3+2)";
		assertEquals(expected, actual);
	}

	@ Test
	void testToPostFixExpression_caseOneNumber_expectedPostFixOneNumber()
	{

		InfixExpression number = new NumberLeaft<Integer>(5);
		InfixExpression infixExpression = new InfixExpressionComposite(number);
		List<InfixExpression> postfixExpression = infixExpression.toPostFix()
		               .getExpressions();

		NumberLeaft<Integer> expected = new NumberLeaft<>(5);

		assertEquals(expected, postfixExpression.get(0));

	}
	
	@ Test
	void testToPostFixExpression_caseOneOperation_expectedPostFixOperation()
	{
		InfixExpression a = new NumberLeaft<Integer>(5);
		OperatorLeaft operator = new OperatorLeaft(Operator.DIVIDE);
		InfixExpression b = new NumberLeaft<Integer>(3);
		InfixExpression infixExpression = new InfixExpressionComposite(a,operator,b);
		List<InfixExpression> postfixExpression = infixExpression.toPostFix()
		               .getExpressions();

		List<InfixExpression> expected = new ArrayList<>();
		expected.add(a);
		expected.add(b);
		expected.add(operator);
		assertArrayEquals(expected.toArray(),postfixExpression.toArray());

	}
	
	@ Test
	void testToPostFixExpression_caseTwoOperation_expectedPostFixOperations()
	{
		InfixExpression a = new NumberLeaft<Integer>(5);
		OperatorLeaft operator = new OperatorLeaft(Operator.SUBSTRACT);
		InfixExpression b = new NumberLeaft<Integer>(9);
		InfixExpressionComposite expression = new InfixExpressionComposite(a,operator,b); 
		
		OperatorLeaft operator2 = new OperatorLeaft(Operator.SUBSTRACT);
		InfixExpression c = new NumberLeaft<Integer>(2);
		
		InfixExpressionComposite infixExpression = new InfixExpressionComposite(c,operator2,expression);
		
		
		List<InfixExpression> postfixExpression = infixExpression.toPostFix()
		               .getExpressions();

		List<InfixExpression> expected = new ArrayList<>();
		expected.add(c);
		expected.add(a);
		expected.add(b);
		expected.add(operator);
		expected.add(operator2);
		assertArrayEquals(expected.toArray(),postfixExpression.toArray());
	}
	
	@ Test
	void testEvaluate_caseTwoOperations_expectedEvaluation()
	{
		InfixExpression a = new NumberLeaft<Integer>(5);
		OperatorLeaft operator = new OperatorLeaft(Operator.ADD);
		InfixExpression b = new NumberLeaft<Integer>(9);
		InfixExpressionComposite expression = new InfixExpressionComposite(a,operator,b); 
		
		OperatorLeaft operator2 = new OperatorLeaft(Operator.MULTIPLY);
		InfixExpression c = new NumberLeaft<Integer>(2);
		
		InfixExpressionComposite infixExpression = new InfixExpressionComposite(c,operator2,expression);
		
		
		Double actual = infixExpression.evaluate();

		Double expected = 28.0;
		assertEquals(expected,actual);
	}


}
