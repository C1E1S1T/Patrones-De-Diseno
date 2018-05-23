package models.tcpConnection;

public class StoppedState extends ConnectionState
{

	public StoppedState()
	{
		setDefaultState(State.STOPPED);
	}
	
	@ Override
	public void open(Connection connection)
	{
		throw new UnsupportedOperationException();
	}

	@ Override
	public void close(Connection connection)
	{
		throw new UnsupportedOperationException();
	}

	@ Override
	public void stop(Connection connection)
	{
		
	}

	@ Override
	public void start(Connection connection)
	{
		connection.setConnectionState(new OpenState());
	}

	@ Override
	public void submit(Connection connection, String sumbit)
	{
		throw new UnsupportedOperationException();
	}

	@ Override
	public void receive(Connection connection, int response)
	{
		throw new UnsupportedOperationException();
	}

	@ Override
	public void setDefaultState(State state)
	{
		this.setState(state);	
	}

}
