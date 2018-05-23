package models;

public class GPS extends Decorator
{

	public GPS(Component component)
	{
		super(component);
	}

	@ Override
	public int definePrice()
	{
		return 2000;
	}

	@ Override
	public String defineDescription()
	{
		return "[GPS]";
	}

}
