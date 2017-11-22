public class Bird extends Animal {
	public Bird() {
		super("tweet", true, true, false);
	}
	
	@Override
	public int numberOfLegs()
	{
		return 2;
	}
	
	@Override
	public int numberOfWings()
	{
		return 2;
	}
	
	@Override
	public void breatheUnderwater()
	{
		throw new RuntimeException("Birds can't breathe underwater.");
	}
}
