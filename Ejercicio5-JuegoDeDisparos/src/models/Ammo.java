package models;

public class Ammo
{

	private int cartridges;
	private int bulletsPerCartridge;
	private int actualBulletsPerCartridge;

	public Ammo(int cartridges, int bulletsPerCartridge)
	{
		this.cartridges = filter(cartridges);
		this.bulletsPerCartridge = filter(bulletsPerCartridge);
		actualBulletsPerCartridge = this.bulletsPerCartridge;
	}

	private int filter(int ammo)
	{
		if (ammo<0)
		{
			return 0;
		}
		return ammo;
	}

	private int filter(int ammo, int result)
	{
		if (filter(ammo)==0)
		{
			return 0;
		}
		else
		{
			return result;
		}
	}

	public int getTotalBullets()
	{
		return cartridges*actualBulletsPerCartridge;
	}

	public void reload()
	{
		int cartridges = --this.cartridges;
		this.cartridges = filter(cartridges);
		this.actualBulletsPerCartridge = filter(cartridges, bulletsPerCartridge);
	}

	public void substract()
	{
		this.actualBulletsPerCartridge = filter(--actualBulletsPerCartridge);
	}

	public void reload(int cartridges)
	{
		cartridges = filter(cartridges);
	}

	public boolean gunWithoutAmmo()
	{	
		return getTotalBullets() == 0;
	}
	
	@Override
	public String toString()
	{
		return this.actualBulletsPerCartridge+"/"+this.cartridges;
	}
	
}
