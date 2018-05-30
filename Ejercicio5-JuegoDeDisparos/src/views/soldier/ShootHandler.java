package views.soldier;

import com.IO;

import controllers.ShootController;
import models.Ammo;

public abstract class ShootHandler
{
	protected ShootHandler nextShootHandler;
	private static ShootController shootController;
	private String name;
	private static Ammo ammo;
	private boolean isCapturedEvent;
	private String message;
	
	public ShootHandler(String name)
	{
		this.name = name;
		setAmmo(null);
		setShootController(null);
		this.isCapturedEvent = false;
	}

	protected ShootHandler getNextShootHandler()
	{
		return this.nextShootHandler;
	}

	public void setNextShootHandler(ShootHandler nextShootHandler)
	{
		this.nextShootHandler = nextShootHandler;
	}

	public void handleRequest()
	{
		processShoot();
		if (isHandlerCapturedEvent())
		{
			IO io = new IO();
			io.write(request());
		}
		else
		{
			this.getNextShootHandler().handleRequest();
		}
	}

	protected boolean isHandlerCapturedEvent()
	{
		return isCapturedEvent;
	}

	protected abstract String request();

	protected String request(String message)
	{
		return getName() + " dice: " + message;
	}
	
	protected void setMessage(String message)
	{
		this.message = message;
	}
	
	protected String getMessage()
	{
		return message;
	}
	
	protected abstract void processShoot();

	protected void setIsCapturedEvent(boolean isCapturedEvent)
	{
		this.isCapturedEvent = isCapturedEvent;
	}

	protected ShootController getShootController()
	{
		return shootController;
	}

	protected String getName()
	{
		return name;
	}

	protected Ammo getAmmo()
	{
		return ammo;
	}

	public void setAmmo(Ammo ammo)
	{
		ShootHandler.ammo = ammo;
	}

	public void setShootController(ShootController shootController)
	{
		ShootHandler.shootController = shootController;
	}

	public static void __destruct()
	{
		ShootHandler.shootController=null;
		ShootHandler.ammo=null;
	}
	
}
