package views.soldier;

class GunWithAmmoHandler extends GunHandler
{

	public GunWithAmmoHandler(String name)
	{
		super(name);
	}

	@ Override
	public String request()
	{
		return getName()+getMessage();
	}

	@ Override
	public void processShoot()
	{
		setMessage(getGunController().toString()+getAmmo().toString());
		this.setIsCapturedEvent(true);
	}

}
