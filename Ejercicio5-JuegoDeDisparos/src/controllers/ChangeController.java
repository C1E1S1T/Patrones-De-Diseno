package controllers;

import models.Ammo;
import models.Gun;


public class ChangeController extends OperationGunController
{

	public ChangeController(Gun gun)
	{
		super(gun);
	}
	
	public ChangeController()
	{
		super();
	}

	public Gun change(Gun gun)
	{
		setGun(gun);
		return getGun();
	}

	@ Override
	public void accept(GunControllerVisitor gunControllerVisitor)
	{
		gunControllerVisitor.visit(this);
	}

	@ Override
	public Ammo control()
	{
		return null;
	}

	@ Override
	public String toString()
	{
		return null;
	}

}
