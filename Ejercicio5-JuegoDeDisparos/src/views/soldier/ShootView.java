package views.soldier;


import controllers.ShootController;

class ShootView
{

	private ShootController shootController;

	public ShootView(ShootController shootController)
	{
		this.shootController=shootController;
	}

	public void interact(String name)
	{
		ShootHandler nullgunHandler = new NullgunHandler(name);
		ShootHandler withoutAmmoHandler = new WithoutAmmoHandler(name);
		ShootHandler gunWithAmmoHandler = new GunWithAmmoHandler(name);
		
		nullgunHandler.setNextShootHandler(withoutAmmoHandler);
		withoutAmmoHandler.setNextShootHandler(gunWithAmmoHandler);
		
		nullgunHandler.setShootController(shootController);
		nullgunHandler.handleRequest();
	}
	
}
