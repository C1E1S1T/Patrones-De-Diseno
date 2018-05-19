package models;

public class ExpressionMathematicalComposite extends ExpressionMathematical
{

	private ExpressionMathematical number1;
	private ExpressionMathematical operator;
	private ExpressionMathematical number2;

	public ExpressionMathematicalComposite(ExpressionMathematical number1, ExpressionMathematical operator,
	               ExpressionMathematical number2)
	{
		this.number1 = number1;
		this.operator = operator;
		this.number2 = number2;
	}

	@ Override
	public String toString()
	{
		return "("+number1.toString()+operator+number2.toString()+")";
	}

}
