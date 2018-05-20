package models;

import java.util.List;
import java.util.Stack;

public class PostFixExpression
{

	private List<InfixExpression> expressions;

	public PostFixExpression(List<InfixExpression> expressions)
	{
		this.expressions=expressions;
	}

	@ SuppressWarnings ({ "rawtypes", "incomplete-switch" })
	public Double evaluate()
	{
		Stack <Double> result = new Stack<>();
		for(InfixExpression expression : expressions)
		{
			switch(expression.getType())
			{
				case NUMBER:
					result.push(((NumberLeaft) expression).getNumber());
					break;
				case OPERATOR:
					Double auxiliar = ((OperatorLeaft)expression).evaluate(result.pop(),result.pop());
					result.push(auxiliar);
			}
		}		
		return result.peek();
	}
	
	public List<InfixExpression> getExpressions()
	{
		return expressions;
	}

	

}
