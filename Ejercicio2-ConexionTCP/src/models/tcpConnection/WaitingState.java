package models.tcpConnection;

public class WaitingState extends ConnectionState
{

	private String message;
	public static final int ACK = 0;

	public WaitingState(String message)
	{
		this.message = message;
		setDefaultState(State.WAITING);
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
		ConnectionState state = null;
		switch (response)
		{
			case ACK:
				state = new OpenState();
				break;
			case ACK+1:
				state = new ClosedState();
				break;
		}
		connection.setConnectionState(state);
	}

	@ Override
	public void setDefaultState(State state)
	{
		this.setState(state);
	}
	
}
