package controllers.operation;

import models.Ammo;
import models.Gun;
import models.Shotgun;

public class StartController
{

	public Gun start()
	{
		Ammo ammo = new Ammo(4,12);
		Gun gun = new Shotgun(ammo);
		return gun;
	}
	
}
