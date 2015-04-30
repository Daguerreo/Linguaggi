package card;

public enum Element {
	NONE(-1, "None"), 
	INCOLOR(0, "Incolor"), 
	AIR(1, "Air"), 
	EARTH(2, "Earth"), 
	FIRE(3, "Fire"), 
	WATER(4, "Water"), 
	LIGHT(5, "Light"), 
	DARKNESS(6,"Darkness"), 
	LIFE(7, "Life"), 
	DEATH(8, "Death"), 
	SPACE(9, "Space"), 
	TIME(10, "Time"), 
	NOUS(11, "Nous"), 
	VOID(12, "Void");

	private final int id;
	private final String name;

	Element(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
