package views.soldier;

public class WithoutAmmoHandler extends GunHandler
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
	public void process()
	{
		if (getAmmo().gunWithoutAmmo())
		{
			this.setMessage("no hay municiones");
			this.setIsCapturedEvent(true);
		}
	}

}
