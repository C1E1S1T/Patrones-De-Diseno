package models;

public abstract class InfixExpression
{

	public abstract PostFixExpression toPostFix();

	public abstract String toString();

	public abstract boolean isValid();

	public abstract Type getType();

}
