public abstract class Animal
{
	private String soundMade;
	private boolean hasLegs;
	private boolean hasWings;
	private boolean hasGills;
	private String type;
	
	public Animal( String soundMade, boolean hasLegs, boolean hasWings, boolean hasGills, String type )
	{
		this.soundMade = soundMade;
		this.hasLegs = hasLegs;
		this.hasWings = hasWings;
		this.hasGills = hasGills;
		this.type = type;
	}
	
	public String getType()
	{
		return type;
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

	abstract public int numberOfLegs();

	abstract public int numberOfWings();
	
	abstract public void breatheUnderwater();
}
