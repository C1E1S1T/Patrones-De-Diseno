package controllers.operation;

import controllers.GunControllerVisitor;
import controllers.OperationGunController;
import models.Ammo;
import models.Gun;

public class ShootController extends OperationGunController
{

	public ShootController(Gun gun)
	{
		super(gun);
	}
	
	public ShootController()
	{
		
	}

	@ Override
	public Ammo control() throws UnsupportedOperationException
	{
		return getGun().shoot();
	}

	@ Override
	public void accept(GunControllerVisitor gunControllerVisitor)
	{
		gunControllerVisitor.visit(this);
	}


	@Override
	public String toString()
	{
		return " dispara Municion: ";
	}
	
}
