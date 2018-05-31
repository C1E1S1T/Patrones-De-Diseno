package views.soldier;

import controllers.ChangeController;
import controllers.GunControllerVisitor;
import controllers.ReloadBulletsController;
import controllers.ShootController;

public class SoldierView implements GunControllerVisitor
{
	private String name;

	public SoldierView(String name)
	{
		this.name = "Soldado "+name;
	}

	@ Override
	public void visit(ChangeController changeController)
	{
		new ChangeView(changeController).interact(name);
	}

	@ Override
	public void visit(ReloadBulletsController reloadController)
	{
		new ReloadView(reloadController).interact(name);
	}

	@ Override
	public void visit(ShootController shootController)
	{
		new ShootView(shootController).interact(name);
	}

}
