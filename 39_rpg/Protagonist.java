import java.util.*;

public class Protagonist {
	private String name; 
	public int health;
	public int damage; 

	public Protagonist(setName) {
		name = setName;
	}

	public String getName() {
		return name;
	}

	public boolean isAlive() {
		return health > 0;
	}

	public int attack(Monster enemy) {
		int base = 8;
		int variation = (int) ( Math.random * base/2 );
		return base + variation;
	}

	public void specialize() {
	}

	public void normalize() {
	}
}
