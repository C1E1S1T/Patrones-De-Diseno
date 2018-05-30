package views.soldier;

class NullgunHandler extends ShootHandler
{

	public NullgunHandler(String name)
	{
		super(name);
	}

	@ Override
	public void processShoot()
	{
		try
		{
			setAmmo(getShootController().shoot());
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
