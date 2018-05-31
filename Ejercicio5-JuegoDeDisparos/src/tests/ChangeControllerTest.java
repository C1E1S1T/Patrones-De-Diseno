package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllers.ChangeController;
import models.Ammo;
import models.Gun;
import models.Shotgun;

class ChangeControllerTest
{

	@ Test
	void testChange_caseShotgun()
	{
		ChangeController controller = new ChangeController();
		Gun actual = controller.change(new Shotgun(new Ammo(2,10)));
		assertTrue(actual instanceof Shotgun);
	}


}
