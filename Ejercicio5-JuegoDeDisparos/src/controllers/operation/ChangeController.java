package controllers.operation;

import controllers.GunController;
import controllers.GunControllerVisitor;
import controllers.OperationGunController;
import models.Gun;


public class ChangeController implements GunController
{

	public ChangeController(Gun gun)
	{
		OperationGunController.setGun(gun);
	}
	
	public ChangeController()
	{
		
	}

	public void change(Gun gun)
	{
		OperationGunController.setGun(gun);
	}

	@ Override
	public void accept(GunControllerVisitor gunControllerVisitor)
	{
		gunControllerVisitor.visit(this);
	}

}
