package models;

public class OperatorLeaft extends InfixExpression
{
	private Operator operator;

	public OperatorLeaft(Operator operator)
	{
		this.operator = operator;
	}

	public Double evaluate(Double number1, Double number2)
	{
		return operator.perform(number1, number2);
	}

	@ Override
	public String toString()
	{
		return operator.getOperator();
	}

	@ Override
	public PostFixExpression toPostFix()
	{
		return null;
	}

	@ Override
	public boolean isValid()
	{
		return false;
	}

	@ Override
	public Type getType()
	{
		return Type.OPERATOR;
	}

}
