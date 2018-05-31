package controllers;

import models.Ammo;
import models.Gun;
import models.Nullgun;

public abstract class OperationGunController implements GunController
{
	private static Gun gun = new Nullgun();

	public OperationGunController()
	{
		
	}
	
	public OperationGunController(Gun gun)
	{
		setGun(gun);
	}
	
	public static void setGun(Gun gun)
	{
		if(gun != null)
		{
			OperationGunController.gun=gun;
		}
	}
	
	public static Gun getGun()
	{
		return gun;
	}
	
	public abstract Ammo control();
		
	public abstract String toString();
	
}
