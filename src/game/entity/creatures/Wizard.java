package game.entity.creatures;

public class Wizard extends HeroBase {

	public Wizard(String name, int level, int strength, int dexterity, int constitution, int wisdom, int intelligence,
			int charisma) {
		super(name, level, strength, dexterity, constitution, wisdom, intelligence, charisma);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void levelUp() {
		this.constitution += 1;
		this.wisdom += 3;
		this.intelligence += 8;
		this.charisma += 2;
		super.levelUp();
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return this.intelligence / 8;
	}

}
