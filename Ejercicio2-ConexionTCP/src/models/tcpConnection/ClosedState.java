package models.tcpConnection;

public class ClosedState extends ConnectionState
{
	
	public ClosedState()
	{
		setDefaultState(State.CLOSED);
	}
	
	@ Override
	public void open(Connection connection)
	{
		connection.setConnectionState(new OpenState());
	}

	@ Override
	public void close(Connection connection)
	{		
		connection.setConnectionState(new ClosedState());
	}

	@ Override
	public void stop(Connection connection)
	{
		throw new UnsupportedOperationException();
	}

	@ Override
	public void start(Connection connection)
	{
		throw new UnsupportedOperationException();
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
