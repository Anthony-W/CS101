public class Cat extends Animal {
	public Cat() {
		super("meow", true, false, false);
	}
	
	@Override
	public int numberOfLegs()
	{
		return 4;
	}
	
	@Override
	public int numberOfWings()
	{
		throw new RuntimeException("Cats don't have wings.");
	}
	
	@Override
	public void breatheUnderwater()
	{
		throw new RuntimeException("Cats can't breathe underwater.");
	}
}
