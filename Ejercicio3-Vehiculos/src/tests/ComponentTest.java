package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Component;
import models.EDS;
import models.GPS;
import models.MP3;
import models.Vehicle;

class ComponentTest
{
	Component component;
	
	@BeforeEach
	void init()
	{
		component = new Vehicle("modelo 2018",50000);
	}
	
	@ Test
	void testToString_caseInitial_expectedPrice()
	{
		int actual = component.getPrice();
		int expected = 50000;
		assertEquals(expected, actual);
	}

	@ Test
	void testComponent_caseComplete_expectedPrice()
	{
		Component vehicule = new GPS(component);
		vehicule = new MP3(vehicule);
		vehicule = new EDS(vehicule);
		int expected = 52700;
		int actual = vehicule.getPrice();
		assertEquals(expected, actual);
	}
	
	@ Test
	void testComponent_caseComplete_expectedDescription()
	{
		Component vehicule = new GPS(component);
		vehicule = new MP3(vehicule);
		vehicule = new EDS(vehicule);
		String expected = "[modelo 2018],[GPS],[MP3],[EDS]";
		String actual = vehicule.getDescription();
		assertEquals(expected, actual);
	}
	
	
}
