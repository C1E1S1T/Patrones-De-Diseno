package models;

public class Nullgun extends Gun
{

	public Nullgun(Ammo ammo)
	{
		super(ammo);
	}
	
	public Nullgun()
	{
		super();
	}

	@ Override
	public Ammo shoot()
	{
		String message = "Imposible Disparar. "+toString();
		throw new UnsupportedOperationException(message);
	}

	@ Override
	public Ammo reload()
	{
		throw new UnsupportedOperationException(toString());
	}

	@ Override
	public String toString()
	{
		return "No tengo arma";
	}

}
