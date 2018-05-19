package models;

public class NumberLeaft<T extends Number> extends ExpressionMathematical
{

	private T number;

	public NumberLeaft(T number)
	{
		this.number = number;
	}

	@ Override
	public String toString()
	{
		return number.toString();
	}

}
