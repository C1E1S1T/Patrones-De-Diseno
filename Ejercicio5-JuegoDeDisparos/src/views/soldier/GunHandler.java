package views.soldier;

import com.IO;

import controllers.OperationGunController;
import models.Ammo;

public abstract class GunHandler
{
	protected GunHandler nextShootHandler;
	private static OperationGunController gunController;
	private String name;
	private static Ammo ammo;
	private boolean isCapturedEvent;
	private String message;
	
	public GunHandler(String name, OperationGunController gunController)
	{
		this(name);
		setGunController(gunController);
	}
	
	public GunHandler(String name)
	{
		this.name = name;
		this.isCapturedEvent = false;
	}

	protected GunHandler getNextShootHandler()
	{
		return this.nextShootHandler;
	}

	public void setNextShootHandler(GunHandler nextShootHandler)
	{
		this.nextShootHandler = nextShootHandler;
	}

	public void handleRequest()
	{
		process();
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
	
	protected abstract void process();

	protected void setIsCapturedEvent(boolean isCapturedEvent)
	{
		this.isCapturedEvent = isCapturedEvent;
	}

	protected OperationGunController getGunController()
	{
		return gunController;
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
		GunHandler.ammo = ammo;
	}

	public void setGunController(OperationGunController gunController)
	{
		GunHandler.gunController = gunController;
	}

	public static void __destruct()
	{
		GunHandler.gunController=null;
		GunHandler.ammo=null;
	}
	
}
