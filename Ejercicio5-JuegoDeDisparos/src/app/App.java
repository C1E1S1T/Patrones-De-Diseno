package app;

import views.soldier.GameView;

public class App
{

	public static void main(String[] args)
	{
		new App().start();
	}

	public void start()
	{
		new GameView().play();
	}

}
