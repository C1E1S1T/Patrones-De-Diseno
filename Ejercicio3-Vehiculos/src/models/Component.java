package models;

public abstract class Component
{

	private String description;
	private int price;

	public Component()
	{
	}

	public Component(String description, int price)
	{
		setPrice(price);
		setDescription(description);
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}

	public int getPrice()
	{
		return price;
	}

}
