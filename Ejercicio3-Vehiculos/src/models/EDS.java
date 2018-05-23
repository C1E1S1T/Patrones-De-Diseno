package models;

public class EDS extends Decorator
{
	public EDS(Component component)
	{
		super(component);
	}

	@ Override
	public int definePrice()
	{
		return 200;
	}

	@ Override
	public String defineDescription()
	{
		return "[EDS]";
	}
	

}
