package controllers;

import models.Ammo;
import models.Gun;

public class ReloadController extends GunController
{

	public ReloadController(Gun gun)
	{
		super(gun);
	}

	public ReloadController()
	{
		super();
	}

	public Ammo reload() throws UnsupportedOperationException
	{
		return getGun().reload();
	}

	public Ammo reload(int cartridges)
	{
		return getGun().reload(cartridges);
	}
	
	@ Override
	public void accept(GunControllerVisitor gunControllerVisitor)
	{
		gunControllerVisitor.visit(this);
	}

}
