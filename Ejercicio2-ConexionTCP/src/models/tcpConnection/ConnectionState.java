package models.tcpConnection;

abstract class ConnectionState
{
	
	private State state;
	
	public abstract void open(Connection connection);
	public abstract void close(Connection connection);
	public abstract void stop(Connection connection);
	public abstract void start(Connection connection);
	public abstract void submit(Connection connection, String sumbit);
	public abstract void receive(Connection connection, int response);
	
	public State getState()
	{
		return state;
	}
	
	protected void setState(State state)
	{
		this.state = state;
	}
	
	public abstract void setDefaultState(State state);
	
}
