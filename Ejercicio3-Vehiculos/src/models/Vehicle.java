package models;

public class Vehicle extends Component
{
	public Vehicle(String description, int price)
	{
		super("["+description+"]", price);
	}
	
}
