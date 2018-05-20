package models;

public class NumberLeaft<T extends Number> extends InfixExpression
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

	public Double getNumber()
	{
		return number.doubleValue();
	}
	
	@ Override
	public PostFixExpression toPostFix()
	{
		return null;
	}

	@ Override
	public boolean isValid()
	{
		return true;
	}

	@ Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime*result+((number==null) ? 0 : number.hashCode());
		return result;
	}
	
	@ SuppressWarnings ("rawtypes")
	@ Override
	public boolean equals(Object obj)
	{
		if (this==obj)
		{
			return true;
		}
		if (obj==null)
		{
			return false;
		}
		if (!(obj instanceof NumberLeaft))
		{
			return false;
		}
		NumberLeaft other = (NumberLeaft) obj;
		if (number==null)
		{
			if (other.number!=null)
			{
				return false;
			}
		}
		else if (!number.equals(other.number))
		{
			return false;
		}
		return true;
	}

	@ Override
	public Type getType()
	{
		return Type.NUMBER;
	}

	

}
