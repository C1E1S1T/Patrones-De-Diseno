package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import models.Ammo;
import models.Gun;
import models.Nullgun;
import models.Shotgun;

class GunTest
{

	@ Test
	void testShoot_caseShotgun()
	{
		Gun gun = new Shotgun(new Ammo(2,10));
		int expected = new Ammo(2,9).getTotalBullets();
		int actual = gun.shoot().getTotalBullets();
		assertEquals(expected,actual);
	}
	
	@ Test
	void testReload_caseShotgun()
	{
		Gun gun = new Shotgun(new Ammo(2,10));
		int expected = new Ammo(1,10).getTotalBullets();
		int actual = gun.reload().getTotalBullets();
		assertEquals(expected,actual);
	}
	
	@ Test
	void testShoot_caseNullgun()
	{
		Gun gun = new Nullgun(new Ammo(2,10));
		Executable shoot = () ->
		{
			gun.shoot();
		};
		assertThrowsUnsupportedOperationException(shoot);
	}
	
	@ Test
	void testReload_caseNullgun()
	{
		Gun gun = new Nullgun(new Ammo(2,10));
		Executable shoot = () ->
		{
			gun.reload();
		};
		assertThrowsUnsupportedOperationException(shoot);
	}

	private void assertThrowsUnsupportedOperationException(Executable operation)
	{
		Class<UnsupportedOperationException> expectedException = UnsupportedOperationException.class;
		assertThrows(expectedException, operation);
	}
	
}
