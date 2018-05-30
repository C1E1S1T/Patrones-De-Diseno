package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import models.Ammo;

class AmmoTest
{

	@ ParameterizedTest (name = "{index} => cartridges={0}, bulletsPerCartridge={1}, expected={2}")
	@ CsvSource ({ "2, 10, 20", "-2, 10, 0" })
	void testGetTotalBullets_casesBoundary(int cartridges, int bulletsPerCartridge,
	               int expected)
	{
		Ammo ammo = new Ammo(cartridges, bulletsPerCartridge);
		int actual = ammo.getTotalBullets();
		assertEquals(expected, actual);
	}

	@ ParameterizedTest (name = "{index} => cartridges={0}, bulletsPerCartridge={1}, expected={2}")
	@ CsvSource ({ "2, 10, 10", "0,10,0" })
	void testReload_casesBoundary(int cartridges, int bulletsPerCartridge, int expected)
	{
		Ammo ammo = new Ammo(cartridges, bulletsPerCartridge);
		ammo.reload();
		int actual = ammo.getTotalBullets();
		assertEquals(expected, actual);
	}

	@ ParameterizedTest (name = "{index} => cartridges={0}, bulletsPerCartridge={1}, expected={2}")
	@ CsvSource ({ "0, 10, 0","0,0,0"})
	void testReload_casesRepetitionBoundary(int cartridges, int bulletsPerCartridge, int expected)
	{
		Ammo ammo = new Ammo(cartridges, bulletsPerCartridge);
		ammo.reload();
		ammo.reload();
		int actual = ammo.getTotalBullets();
		assertEquals(expected, actual);
	}

	@ ParameterizedTest (name = "{index} => cartridges={0}, bulletsPerCartridge={1}, expected={2}")
	@ CsvSource ({ "2, 10, 18","0,0,0", "0,1,0", "1,0,0"})
	void testSubstract_casesBoundary(int cartridges, int bulletsPerCartridge, int expected)
	{
		Ammo ammo = new Ammo(cartridges, bulletsPerCartridge);
		ammo.substract();
		int actual = ammo.getTotalBullets();
		assertEquals(expected, actual);
	}
	
}
