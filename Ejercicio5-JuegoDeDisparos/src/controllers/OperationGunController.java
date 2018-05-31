package controllers;

import models.Ammo;
import models.Gun;
import models.Nullgun;

public abstract class OperationGunController implements GunController
{
	public static Gun gun = new Nullgun();

	public OperationGunController()
	{
		
	}
	
	public OperationGunController(Gun gun)
	{
		setGun(gun);
	}
	
	protected static void setGun(Gun gun)
	{
		if(gun != null)
		{
			OperationGunController.gun=gun;
		}
	}
	
	public Gun getGun()
	{
		return gun;
	}
	
	public abstract Ammo control();
		
	public abstract String toString();
	
}
