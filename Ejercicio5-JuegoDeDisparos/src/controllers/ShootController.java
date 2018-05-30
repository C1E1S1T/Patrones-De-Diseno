package controllers;

import models.Ammo;
import models.Gun;

public class ShootController extends GunController
{

	public ShootController(Gun gun)
	{
		super(gun);
	}
	
	public ShootController()
	{
		
	}

	public Ammo shoot() throws UnsupportedOperationException
	{
		return getGun().shoot();
	}

	@ Override
	public void accept(GunControllerVisitor gunControllerVisitor)
	{
		gunControllerVisitor.visit(this);
	}
	
}
