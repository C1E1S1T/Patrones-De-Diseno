package controllers.operation;

import controllers.GunControllerVisitor;
import controllers.OperationGunController;
import models.Ammo;

public class ReloadCartridgesController extends OperationGunController
{

	@ Override
	public Ammo control()
	{
		return null;
	}

	@ Override
	public void accept(GunControllerVisitor gunControllerVisitor)
	{
		// TODO Auto-generated method stub
		
	}

	@ Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
