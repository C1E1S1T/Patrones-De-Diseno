package views.soldier;

import com.IO;

import controllers.ChangeController;
import models.Gun;

public class ChangeView
{

	private ChangeController changeController;

	public ChangeView(ChangeController changeController)
	{
		setChangeController(changeController);
	}

	private void setChangeController(ChangeController changeController)
	{
		this.changeController = changeController;
	}

	public void interact(String name)
	{
		IO io = new IO();
		int cartridges = io.readInt("Cartuchos: ");
		int bullets = io.readInt("Balas por cartucho:");
		int option = io.readInt("Ingrese el arma 1. Escopeta ");
		Gun gun = GunBuilder.getBuilder(option).build(cartridges, bullets);
		changeController.change(gun);
		io.writeln(name + " he cambiado de arma: " + gun.toString() + " con municion: " + gun.getAmmo().toString());
	}

}
