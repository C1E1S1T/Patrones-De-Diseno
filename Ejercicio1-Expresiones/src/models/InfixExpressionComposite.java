package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixExpressionComposite extends InfixExpression
{
	private List<InfixExpression> expressions;

	public InfixExpressionComposite()
	{
		expressions = new ArrayList<>();
	}

	public InfixExpressionComposite(InfixExpression expressionMathematical)
	{
		this();
		add(expressionMathematical);
	}

	public InfixExpressionComposite(InfixExpression expression1, OperatorLeaft operator,
	               InfixExpression expression)
	{
		this(expression1);
		add(operator, expression);
	}

	private InfixExpressionComposite(OperatorLeaft operator, InfixExpression expression)
	{
		this();
		expressions.add(operator);
		add(expression);
	}
	
	public InfixExpressionComposite(String expression)
	{
		expressions = toInfixExpression(expression);
	}

	public void add(OperatorLeaft operator, InfixExpression expression)
	{
		InfixExpressionComposite infixExpression = new InfixExpressionComposite(operator,expression);
		expressions.add(infixExpression);
	}

	private void add(InfixExpression expression)
	{
		if (expression.isValid())
		{
			expressions.add(expression);
		}
	}

	public Double evaluate()
	{
		return toPostFix().evaluate();
	}
	
	private List<InfixExpression> toInfixExpression(String expression)
	{
		List<InfixExpression> expressions = new ArrayList<>();
		expressions.add(new NumberLeaft<Integer>(2));
		expressions.add(new OperatorLeaft(Operator.ADD));
		expressions.add(new NumberLeaft<Integer>(2));
		expressions.add(new OperatorLeaft(Operator.MULTIPLY));
		expressions.add(new NumberLeaft<Integer>(2));
		return expressions;
	}
	
	@ Override
	public PostFixExpression toPostFix()
	{
		List<InfixExpression> result = new ArrayList<>();
		Stack<OperatorLeaft> operators = new Stack<>();
		for (InfixExpression expression : expressions)
		{
			switch (expression.getType())
			{
				case OPERATION:
					result.addAll((expression.toPostFix().getExpressions()));
					break;
				case NUMBER:
					result.add(expression);
					break;
				case OPERATOR:
					operators.push((OperatorLeaft) expression);
					break;
			}
		}
		if(!operators.empty())
		{
			result.add(operators.pop());
		}
		return new PostFixExpression(result);
	}

	@ Override
	public boolean isValid()
	{
		return true;
	}

	@ Override
	public Type getType()
	{
		return Type.OPERATION;
	}

	@ Override
	public String toString()
	{
		String expression = "";
		for (InfixExpression expressionMathematical : expressions)
		{
			String auxiliar = expressionMathematical.toString();
			if(expressionMathematical.getType() == Type.OPERATION)
			{
				expression += auxiliar.substring(1, auxiliar.length()-1);
			}
			else
			{
				expression += auxiliar;
			}
		}
		return "("+expression+")";
	}

	
}
