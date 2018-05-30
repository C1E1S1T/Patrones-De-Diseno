package views.soldier;

public class WithoutAmmoHandler extends ShootHandler
{

	public WithoutAmmoHandler(String name)
	{
		super(name);
	}

	@ Override
	public String request()
	{
		return this.request(getMessage());
	}

	@ Override
	public void processShoot()
	{
		if (getAmmo().gunWithoutAmmo())
		{
			this.setMessage("no hay municiones");
			this.setIsCapturedEvent(true);
		}
	}

}
