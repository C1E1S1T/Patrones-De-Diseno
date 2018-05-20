package models.tcpConnection;

abstract class ConnectionState
{
	public abstract void open(Connection connection);
	public abstract void close(Connection connection);
	public abstract void stop(Connection connection);
	public abstract void start(Connection connection);
	public abstract void submit(Connection connection, String sumbit);
	public abstract void receive(Connection connection, int response);
	public abstract State getState();
}
