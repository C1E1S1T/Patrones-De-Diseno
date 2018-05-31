package views.soldier;

import com.IO;

import controllers.operation.ChangeController;
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
		io.writeln(getUserMessage(name, gun));
	}

	private String getUserMessage(String name, Gun gun)
	{
		String changeGun = " he cambiado de arma: "+gun.toString();
		String withAmmo = " con municion: "+gun.getAmmo().toString();
		return name+changeGun+withAmmo;
	}

}
