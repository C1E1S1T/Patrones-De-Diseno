package controllers;

public interface GunControllerVisitor
{
	public void visit(ChangeController changeController);
	public void visit(ReloadBulletsController reloadController);
	public void visit(ShootController shootController);
}
