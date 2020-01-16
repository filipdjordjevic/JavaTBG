package game.entity.items;

public abstract class WeaponBase extends ItemBase {
	
	int damage;
	
	public WeaponBase(String name, int requiredLevel, int damage) {
		super(name, requiredLevel);
		this.damage = damage;
	}
	
	public int getDamage() {
		return damage;
	}
	
}
