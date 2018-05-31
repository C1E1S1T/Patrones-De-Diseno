package controllers;

import controllers.operation.ChangeController;
import controllers.operation.ReloadBulletsController;
import controllers.operation.ShootController;

public interface GunControllerVisitor
{
	public void visit(ChangeController changeController);
	public void visit(ReloadBulletsController reloadController);
	public void visit(ShootController shootController);
}
