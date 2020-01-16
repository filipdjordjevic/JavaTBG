package game.entity.items;

public abstract class ItemBase {
	
	String name;
	int requiredLevel;
	
	public ItemBase(String name, int requiredLevel) {
		this.name = name;
		this.requiredLevel = requiredLevel;
	}
	
}
