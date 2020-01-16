package game.entity.creatures;


public class BasicEnemy extends CreatureBase {
	
	public BasicEnemy(
			String name,
			int level,
			int strength,
			int dexterity,
			int constitution,
			int wisdom,
			int intelligence,
			int charisma
			) {
		super(
				name,
				level,
				strength,
				dexterity,
				constitution,
				wisdom,
				intelligence,
				charisma
				);
		
	}
	
	@Override
	public int getArmor() {
		int armorBase = 10;
		return armorBase + constitution / armorBase;
	}
	
	@Override
	public int attack() {
		return this.strength / 5;
	}
}
