package models;

public class OperatorLeaft extends ExpressionMathematical
{

	private String operator;

	public OperatorLeaft(String operator)
	{
		this.operator=operator;
	}

	@Override
	public String toString()
	{
		return operator;
	}
	
}
