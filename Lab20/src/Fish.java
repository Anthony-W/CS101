public class Fish extends Animal {
	public Fish() {
		super("blub", false, false, true, "Fish");
	}
	
	@Override
	public int numberOfLegs()
	{
		throw new RuntimeException("Fish don't have legs.");
	}
	
	@Override
	public int numberOfWings()
	{
		throw new RuntimeException("Fish don't have wings.");
	}
	
	@Override
	public void breatheUnderwater()
	{
		
	}
}
