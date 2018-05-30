package views.soldier;

import controllers.ChangeController;
import controllers.GunControllerVisitor;
import controllers.ReloadController;
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
		

	}

	@ Override
	public void visit(ReloadController reloadController)
	{
		
	}

	@ Override
	public void visit(ShootController shootController)
	{
		new ShootView(shootController).interact(name);
	}

}
