package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import controllers.ReloadBulletsController;
import models.Ammo;
import models.Shotgun;

class ReloadControllerTest
{

	@ Test
	void testReload_caseGun()
	{
		ReloadBulletsController controller = new ReloadBulletsController(new Shotgun(new Ammo(2,10)));
		int expected = new Ammo(1,10).getTotalBullets();
		int actual = controller.control().getTotalBullets();
		assertEquals(expected,actual);
	}

	@Test
	void testShoot_caseNullGun()
	{
		ReloadBulletsController controller = new ReloadBulletsController();
		Executable reload = () ->
		{
			controller.control();
		};
		assertThrowsUnsupportedOperationException(reload);
	}

	private void assertThrowsUnsupportedOperationException(Executable operation)
	{
		Class<UnsupportedOperationException> expectedException = UnsupportedOperationException.class;
		assertThrows(expectedException, operation);
	}
	
}
