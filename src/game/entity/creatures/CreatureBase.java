package game.entity.creatures;


public abstract class CreatureBase {
	//Creature name
	String name;
	
	//Creature health points
	int hp;
	int currentHp;
	
	//Creature level
	int level;
	
	//Basic creature stats
	int strength;
	int dexterity;
	int constitution;
	int wisdom;
	int intelligence;
	int charisma;
	
	
	public CreatureBase(
			String name,
			int level,
			int strength,
			int dexterity,
			int constitution,
			int wisdom,
			int intelligence,
			int charisma
			) {
		this.name = name;
		this.level = level;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.wisdom = wisdom;
		this.intelligence = intelligence;
		this.charisma = charisma;
		
		this.hp = this.level * this.constitution;
		this.currentHp = this.hp;
	}
	
	//getters
	public String getName() {
		return this.name;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public int getHp() {
		return this.currentHp;
	}
	
	public int getMaxHp() {
		return this.hp;
	}
	
	public int getStrength() {
		return strength;
	}

	public int getDexterity() {
		return dexterity;
	}


	public int getConstitution() {
		return constitution;
	}

	public int getWisdom() {
		return wisdom;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getCharisma() {
		return charisma;
	}

	public abstract int getArmor();
	
	public int getInitiative() {
		return this.dexterity;
	}
	
	//actions
	public abstract int attack();
	
	public void reduceHp(int damage) {
		this.currentHp -= damage;
	}
	
}
