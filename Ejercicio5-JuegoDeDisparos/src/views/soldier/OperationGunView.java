package views.soldier;

import controllers.OperationGunController;

public abstract class OperationGunView
{
	private OperationGunController controller;
	
	public OperationGunView(OperationGunController controller)
	{
		this.controller=controller;
	}
	
	public void interact(String name)
	{
		GunHandler nullgunHandler = new NullgunHandler(name);
		GunHandler withoutAmmoHandler = new WithoutAmmoHandler(name);
		GunHandler gunWithAmmoHandler = new GunWithAmmoHandler(name);
		
		nullgunHandler.setNextShootHandler(withoutAmmoHandler);
		withoutAmmoHandler.setNextShootHandler(gunWithAmmoHandler);
		
		nullgunHandler.setGunController(controller);
		nullgunHandler.handleRequest();
	}
	
	
}
