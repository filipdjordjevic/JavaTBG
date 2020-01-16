package game.entity.items;

public abstract class ArmorBase extends ItemBase {
	int armor;
	
	public ArmorBase(String name, int requiredLevel, int armor) {
		super(name, requiredLevel);
		this.armor = armor;
	}
	
	public int getArmor() {
		return armor;
	}
	
}
