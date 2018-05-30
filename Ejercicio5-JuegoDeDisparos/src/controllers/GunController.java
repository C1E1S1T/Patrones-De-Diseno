package controllers;

import models.Gun;
import models.Nullgun;

public abstract class GunController
{
	public static Gun gun = new Nullgun();

	public GunController()
	{
		
	}
	
	public GunController(Gun gun)
	{
		setGun(gun);
	}
	
	protected void setGun(Gun gun)
	{
		if(gun != null)
		{
			GunController.gun=gun;
		}
	}
	
	public Gun getGun()
	{
		return gun;
	}
	
	
	public abstract void accept(GunControllerVisitor gunControllerVisitor);
	
	
}
