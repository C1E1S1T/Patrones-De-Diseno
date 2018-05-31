package views.soldier;

import com.IO;

import controllers.ChangeController;
import models.Ammo;
import models.Gun;
import models.Nullgun;
import models.Shotgun;

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
		Ammo ammo = new Ammo(cartridges, bullets);
		int option = io.readInt("Ingrese el arma 1. Escopeta ");
		Gun gun = null;
		switch(option)
		{
			case 1: gun = new Shotgun(); break;
			default: 
				gun = new Nullgun();
		}
		changeController.change(new Shotgun(), ammo);
		io.writeln(name + "he cambiado de arma: " + gun.toString() + " con municion: " + ammo.toString());
	}

}
