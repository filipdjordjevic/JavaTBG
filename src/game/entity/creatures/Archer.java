package game.entity.creatures;

public class Archer extends HeroBase {

	public Archer(String name, int level, int strength, int dexterity, int constitution, int wisdom, int intelligence,
			int charisma) {
		super(name, level, strength, dexterity, constitution, wisdom, intelligence, charisma);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void levelUp() {	
		this.strength += 1;
		this.dexterity += 5;
		this.constitution += 3;
		this.wisdom += 2;
		this.intelligence += 1;
		this.charisma += 2;
		super.levelUp();
	}

	@Override
	public int attack() {
		return 1 + this.dexterity / 10;
	}

}
