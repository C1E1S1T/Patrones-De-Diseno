package views.soldier;

class GunWithAmmoHandler extends ShootHandler
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
		setMessage(" dispara Municion: "+getAmmo().toString());
		this.setIsCapturedEvent(true);
	}

}
