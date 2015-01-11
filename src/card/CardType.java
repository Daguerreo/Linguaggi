package card;

public enum CardType 
{
	PERMANENT("Permanent"),
	SPELL("Spell"),
	CREATURE("Creature");
	
	final private String name;
	
	CardType(String n)
	{
		name = n;
	}

	public String getName() {
		return name;
	}
	
	
}
