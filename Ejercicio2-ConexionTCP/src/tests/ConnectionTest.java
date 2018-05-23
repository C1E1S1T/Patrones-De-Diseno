package tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import models.tcpConnection.Connection;
import models.tcpConnection.State;
import models.tcpConnection.WaitingState;

import static org.junit.Assert.assertEquals;

public class ConnectionTest
{

	private Connection connection;

	@ BeforeEach
	void setUp() throws Exception
	{
		this.connection = new Connection();
	}

	@ Test
	public void testInitialState()
	{
		assertEquals(State.CLOSED, this.connection.getState());
	}

	@ Test
	public void testClosedOpen()
	{
		this.connection.open();
		assertEquals(State.READY, this.connection.getState());
	}

	@ Test
	public void testClosedClose()
	{
		this.connection.close();
		assertEquals(State.CLOSED, this.connection.getState());
	}

	@ Test
	public void testClosedNotSupportedStop()
	{
		Executable closeToStop = () ->
		{
			this.connection.stop();
		};
		assertThrowsUnsupportedOperationException(closeToStop);
	}

	@ Test
	public void testClosedNotSupportedStart()
	{
		Executable closeToStart = () ->
		{
			this.connection.start();
		};
		assertThrowsUnsupportedOperationException(closeToStart);
	}

	@ Test
	public void testClosedNotSupportedSubmit()
	{
		Executable closeToSubmit = () ->
		{
			this.connection.submit("");
		};
		assertThrowsUnsupportedOperationException(closeToSubmit);
	}

	@ Test
	public void testClosedNotSupportedReceive()
	{
		Executable closeToReceive = () ->
		{
			this.connection.receive(WaitingState.ACK);
		};
		assertThrowsUnsupportedOperationException(closeToReceive);
	}

	@ Test
	public void testReadyOpen()
	{
		this.connection.open();
		this.connection.open();
		assertEquals(State.READY, this.connection.getState());
	}

	@ Test
	public void testReadyClose()
	{
		this.connection.open();
		this.connection.close();
		assertEquals(State.CLOSED, this.connection.getState());
	}

	@ Test
	public void testReadyStop()
	{
		this.connection.open();
		this.connection.stop();
		assertEquals(State.STOPPED, this.connection.getState());
	}

	@ Test
	public void testReadyStart()
	{
		this.connection.open();
		this.connection.start();
		assertEquals(State.READY, this.connection.getState());
	}

	@ Test
	public void testReadySubmit()
	{
		this.connection.open();
		this.connection.submit("testReadySubmit");
		assertEquals(State.WAITING, this.connection.getState());
	}

	@ Test
	public void testReadyNotSupportedReceive()
	{
		Executable openToReceive = () ->
		{
			this.connection.open();
			this.connection.receive(WaitingState.ACK);
		};
		assertThrowsUnsupportedOperationException(openToReceive);
	}

	@ Test
	public void testStopedNotSupportedOpen()
	{
		Executable stopToOpen = () ->
		{
			this.connection.open();
			this.connection.stop();
			this.connection.open();
		};
		assertThrowsUnsupportedOperationException(stopToOpen);
	}

	@ Test
	public void testStopedNotSupportedClose()
	{
		Executable stopToClose = () ->
		{
			this.connection.open();
			this.connection.stop();
			this.connection.close();
		};
		assertThrowsUnsupportedOperationException(stopToClose);
	}

	@ Test
	public void testStopedStop()
	{
		this.connection.open();
		this.connection.stop();
		this.connection.stop();
		assertEquals(State.STOPPED, this.connection.getState());
	}

	@ Test
	public void testStopedStart()
	{
		this.connection.open();
		this.connection.stop();
		this.connection.start();
		assertEquals(State.READY, this.connection.getState());
	}

	@ Test
	public void testStopedNotSupportedSubmit()
	{
		Executable stopToSubmit = () ->
		{
			this.connection.open();
			this.connection.stop();
			this.connection.submit("");
		};
		assertThrowsUnsupportedOperationException(stopToSubmit);
	}

	@ Test
	public void testStopedNotSupportedReceive()
	{
		Executable stopToReceive = () ->
		{
			this.connection.open();
			this.connection.stop();
			this.connection.receive(WaitingState.ACK);
		};
		assertThrowsUnsupportedOperationException(stopToReceive);
	}

	@ Test
	public void testWaitingNotSupportedOpen()
	{
		Executable waitingToOpen = () ->
		{
			this.connection.open();
			this.connection.submit("testWaitingNotSupportedOpen");
			this.connection.open();
		};
		assertThrowsUnsupportedOperationException(waitingToOpen);
	}

	@ Test
	public void testWaitingNotSupportedClose()
	{
		Executable waitingToClose = () ->
		{
			this.connection.open();
			this.connection.submit("testWaitingNotSupportedClose");
			this.connection.close();
		};
		assertThrowsUnsupportedOperationException(waitingToClose);
	}

	@ Test
	public void testWaitingNotSupportedStop()
	{
		Executable waitingToStop = () ->
		{
			this.connection.open();
			this.connection.submit("testWaitingNotSupportedStop");
			this.connection.stop();
		};
		assertThrowsUnsupportedOperationException(waitingToStop);
	}

	@ Test
	public void testWaitingNotSupportedStart()
	{
		Executable waitingToStart = () ->
		{
			this.connection.open();
			this.connection.submit("testWaitingNotSupportedOpen");
			this.connection.start();
		};
		assertThrowsUnsupportedOperationException(waitingToStart);
		
	}

	@ Test
	public void testWaitingNotSupportedSubmit()
	{
		Executable waitingToSubmit = () ->
		{
			this.connection.open();
			this.connection.submit("testWaitingNotSupportedSubmit");
			this.connection.submit("");
		};
		assertThrowsUnsupportedOperationException(waitingToSubmit);	
	}

	@ Test
	public void testWaitingReceiveACK()
	{
		this.connection.open();
		this.connection.submit("testWaitingReceiveACK");
		this.connection.receive(WaitingState.ACK);
		assertEquals(State.READY, this.connection.getState());
	}

	@ Test
	public void testWaitingReceiveError()
	{
		this.connection.open();
		this.connection.submit("testWaitingReceiveError");
		this.connection.receive(WaitingState.ACK+1);
		assertEquals(State.CLOSED, this.connection.getState());
	}

	private void assertThrowsUnsupportedOperationException(Executable operation)
	{
		Class<UnsupportedOperationException> expectedException = UnsupportedOperationException.class;
		assertThrows(expectedException, operation);
	}

	
}
