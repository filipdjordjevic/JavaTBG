package game.entity.creatures;

public abstract class HeroBase extends CreatureBase{
	public HeroBase(
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
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void levelUp() {
		this.level++;
		this.currentHp = this.getMaxHp();
	}
	
	
}
