package views.soldier;

import com.IO;

import controllers.ChangeController;
import controllers.ReloadBulletsController;
import controllers.ShootController;
import controllers.StartController;
import models.Gun;

public class GameView
{
	private ShootController shootController;
	private ChangeController changeController;
	private ReloadBulletsController reloadController;
	
	public GameView()
	{
		Gun gun = new StartController().start();
		
		shootController = new ShootController(gun);
		changeController = new ChangeController(gun);
		reloadController = new ReloadBulletsController(gun);
	}

	public void play()
	{
		IO io = new IO();
		boolean ok = true;
		String name = io.readString("Ingrese el nombre del soldado: ");
		SoldierView soldier = new SoldierView(name);
		do 
		{
			io.writeln("Ingrese la accion que quiere realizar");
			int option = io.readInt("1.Disparar 2.Recargar 3.Cambiar arma - ");
			switch(option)
			{
				case 1: soldier.visit(shootController);  break;
				case 2: soldier.visit(reloadController); break;
				case 3: soldier.visit(changeController); break;
				default:
					ok = false; break;
			}
			io.writeln();
			io.writeln();
		}while(ok);
	}
	
}
