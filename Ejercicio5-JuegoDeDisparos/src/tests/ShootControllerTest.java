package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import controllers.operation.ShootController;
import models.Ammo;
import models.Nullgun;
import models.Shotgun;


class ShootControllerTest
{

	@ Test
	void testShoot_caseShotGun()
	{
		ShootController controller = new ShootController(new Shotgun(new Ammo(2,10)));
		int expected = new Ammo(2,9).getTotalBullets();
		int actual = controller.control().getTotalBullets();
		assertEquals(expected,actual);
	}
	
	@Test
	void testShoot_caseNullGun()
	{
		ShootController controller = new ShootController(new Nullgun(null));
		Executable shoot = () ->
		{
			controller.control();
		};
		assertThrowsUnsupportedOperationException(shoot);
	}

	private void assertThrowsUnsupportedOperationException(Executable operation)
	{
		Class<UnsupportedOperationException> expectedException = UnsupportedOperationException.class;
		assertThrows(expectedException, operation);
	}
	

	
}
