package controllers.operation;

import controllers.GunControllerVisitor;
import controllers.OperationGunController;
import models.Ammo;
import models.Gun;

public class ReloadBulletsController extends OperationGunController
{

	public ReloadBulletsController(Gun gun)
	{
		super(gun);
	}

	public ReloadBulletsController()
	{
		super();
	}

	@Override
	public Ammo control() throws UnsupportedOperationException
	{
		return getGun().reload();
	}

	@ Override
	public void accept(GunControllerVisitor gunControllerVisitor)
	{
		gunControllerVisitor.visit(this);
	}

	@ Override
	public String toString()
	{
		return " Recargando municion ";
	}

}
