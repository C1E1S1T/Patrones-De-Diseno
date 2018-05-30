package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.ShootController;
import models.Ammo;
import models.Shotgun;
import views.soldier.ShootHandler;
import views.soldier.SoldierView;

class SoldierViewTest
{
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private SoldierView soldierView;
	
	@ BeforeEach
	public void setUp()
	{
		soldierView = new SoldierView("Pedro");
		System.setOut(new PrintStream(outContent));
	}

	@ AfterEach
	public void setDown()
	{
		System.setOut(System.out);
		ShootHandler.__destruct();
		System.gc();
	}

	@ Test
	public void testVisitShootController_caseNullgun()
	{
		soldierView.visit(new ShootController());
		String expected = "Soldado Pedro dice: Imposible Disparar. No tengo arma";
		assertEquals(expected, outContent.toString());
	}

	@ Test
	public void testVisitShootController_caseShootGunAndWithoutAmmo()
	{
		soldierView.visit(new ShootController(new Shotgun()));
		String expected = "Soldado Pedro dice: no hay municiones";
		assertEquals(expected, outContent.toString());
	}
	
	@ Test
	public void testVisitShootController_caseShootGunAndWithAmmo_1Shoot()
	{
		soldierView.visit(new ShootController(new Shotgun(new Ammo(2,10))));
		String expected = "Soldado Pedro dispara Municion: 9/2";
		assertEquals(expected, outContent.toString());
	}

	
}
