package models;

public abstract class Decorator extends Component
{
	private Component component;
	
	public Decorator(Component component)
	{
		this.component = component;
		this.setPrice(definePrice());
		this.setDescription(defineDescription());
	}

	public abstract int definePrice();

	public abstract String defineDescription();

	public Component getComponent()
	{
		return component;
	}

	@Override
	public int getPrice()
	{
		return component.getPrice() + definePrice();
	}
	
	@Override
	public String getDescription()
	{
		return component.getDescription()+ ","+ defineDescription();
	}
	
}
