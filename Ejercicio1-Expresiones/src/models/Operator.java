package models;

public enum Operator
{
	ADD("+")
	{
		@ Override
		public Double perform(Double operand1, Double operand2)
		{
			return operand1+operand2;
		}
	},
	SUBSTRACT("-")
	{
		@ Override
		public Double perform(Double operand1, Double operand2)
		{
			return operand1-operand2;
		}
	},
	MULTIPLY("*")
	{
		@ Override
		public Double perform(Double operand1, Double operand2)
		{
			return operand1*operand2;
		}
	},
	DIVIDE("/")
	{
		@ Override
		public Double perform(Double operand1, Double operand2)
		{
			return operand1/operand2;
		}
	};

	private final String operator;

	Operator(String operator)
	{
		this.operator = operator;
	}

	public String getOperator()
	{
		return operator;
	}

	public abstract Double perform(Double number1, Double number2);
}