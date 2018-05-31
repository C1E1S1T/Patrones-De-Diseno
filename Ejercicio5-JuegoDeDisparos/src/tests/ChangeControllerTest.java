package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllers.OperationGunController;
import controllers.operation.ChangeController;
import models.Ammo;
import models.Gun;
import models.Shotgun;

class ChangeControllerTest
{

	@ Test
	void testChange_caseShotgun()
	{
		ChangeController controller = new ChangeController();
		controller.change(new Shotgun(new Ammo(2,10)));
		Gun actual = OperationGunController.getGun();
		assertTrue(actual instanceof Shotgun);
	}


}
