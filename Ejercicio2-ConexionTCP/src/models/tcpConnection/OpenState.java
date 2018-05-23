package models.tcpConnection;

public class OpenState extends ConnectionState
{
	
	public OpenState()
	{
		setDefaultState(State.READY);
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
		connection.setConnectionState(new StoppedState());
	}

	@ Override
	public void start(Connection connection)
	{
		// TODO Auto-generated method stub

	}

	@ Override
	public void submit(Connection connection, String message)
	{
		connection.setConnectionState(new WaitingState(message));
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
