package models.tcpConnection;

public class Connection
{
	public static final int ACK = 0;
	public ConnectionState connectionState;
	
	public Connection()
	{
		ConnectionState initialState = new ClosedState();
		this.setConnectionState(initialState);
	}
	
	protected void setConnectionState(ConnectionState connectionState)
	{
		this.connectionState = connectionState;
	}

	public void open()
	{
		connectionState.open(this);
	}

	public void close()
	{
		connectionState.close(this);
	}

	public void stop()
	{
		connectionState.stop(this);
	}

	public void start()
	{
		connectionState.start(this);
	}

	public void submit(String message)
	{
		connectionState.submit(this,message);
	}

	public void receive(int response)
	{
		connectionState.receive(this,response);
	}

	public State getState()
	{
		return connectionState.getState();
	}

}
