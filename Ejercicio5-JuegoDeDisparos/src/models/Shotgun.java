package models;

public class Shotgun extends Gun
{	

	public Shotgun(Ammo ammo)
	{
		super(ammo);
	}
	
	public Shotgun()
	{
		super();
	}
	
	@Override
	public String toString()
	{
		return "Escopeta";
	}
	
}
