package models;

public abstract class Gun
{

	private Ammo ammo;

	public Gun()
	{
		ammo = new Ammo(0,0);
	}
	
	public Gun(Ammo ammo)
	{
		setAmmo(ammo);
	}

	public Ammo reload()
	{
		ammo.reload();
		return ammo;
	}

	public Ammo shoot()
	{
		ammo.substract();
		return ammo;
	}

	public abstract String toString();

	public Ammo reload(int cartridges)
	{
		ammo.reload(cartridges);
		return ammo;
	}

	public void setAmmo(Ammo ammo)
	{
		if(ammo != null)
		{
			this.ammo = ammo;
		}
	}
	
}
