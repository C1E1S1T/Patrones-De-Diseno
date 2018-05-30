package controllers;

import models.Ammo;
import models.Gun;


public class ChangeController extends GunController
{

	public ChangeController(Gun gun)
	{
		super(gun);
	}
	
	public ChangeController()
	{
		super();
	}

	public Gun change(Gun gun, Ammo ammo)
	{
		getGun().setAmmo(ammo);
		setGun(gun);
		return getGun();
	}

	@ Override
	public void accept(GunControllerVisitor gunControllerVisitor)
	{
		gunControllerVisitor.visit(this);
	}

}
