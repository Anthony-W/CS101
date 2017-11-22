public class Animal
{
	private String soundMade;
	private boolean hasLegs;
	private boolean hasWings;
	private boolean hasGills;
	
	public Animal( String soundMade, boolean hasLegs, boolean hasWings, boolean hasGills )
	{
		this.soundMade = soundMade;
		this.hasLegs = hasLegs;
		this.hasWings = hasWings;
		this.hasGills = hasGills;
	}
	
	public String getSoundMade()
	{
		return soundMade;
	}

	public boolean hasLegs()
	{
		return hasLegs;
	}

	public boolean hasWings()
	{
		return hasWings;
	}

	public boolean hasGills()
	{
		return hasGills;
	}

	public int numberOfLegs()
	{
		throw new RuntimeException("I don't know if this animal has legs.");
	}

	public int numberOfWings()
	{
		throw new RuntimeException("I don't know if this animal has wings.");
	}
	
	public void breatheUnderwater()
	{
		throw new RuntimeException("I don't know if this animal can breate underwater.");
	}
}
