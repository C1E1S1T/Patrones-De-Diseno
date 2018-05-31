package views.soldier;

class NullgunHandler extends GunHandler
{

	public NullgunHandler(String name)
	{
		super(name);
	}

	@ Override
	public void process()
	{
		try
		{
			setAmmo(getGunController().control());
		}
		catch (UnsupportedOperationException exception)
		{
			this.setIsCapturedEvent(true);
			this.setMessage(exception.getMessage());
		}
	}

	@ Override
	protected String request()
	{
		return request(getMessage());
	}

}
