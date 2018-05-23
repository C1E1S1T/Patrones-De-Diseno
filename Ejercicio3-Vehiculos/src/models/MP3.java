package models;

public class MP3 extends Decorator
{

	public MP3(Component component)
	{
		super(component);
	}

	@ Override
	public int definePrice()
	{
		return 500;
	}

	@ Override
	public String defineDescription()
	{
		return "[MP3]";
	}

}
