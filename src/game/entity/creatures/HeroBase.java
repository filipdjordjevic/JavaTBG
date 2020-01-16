package game.entity.creatures;

public class HeroBase extends CreatureBase{
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

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 5;
	}
	
	
	
}
