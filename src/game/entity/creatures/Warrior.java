package game.entity.creatures;

public class Warrior extends HeroBase {

	public Warrior(String name, int level, int strength, int dexterity, int constitution, int wisdom, int intelligence,
			int charisma) {
		super(name, level, strength, dexterity, constitution, wisdom, intelligence, charisma);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void levelUp() {
		this.strength += 5;
		this.dexterity += 2;
		this.constitution += 5;
		this.wisdom += 1;
		this.intelligence += 1;
		this.charisma += 1;
		super.levelUp();
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 1 + this.strength / 10;
	}

}
