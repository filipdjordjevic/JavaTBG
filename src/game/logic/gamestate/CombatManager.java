package game.logic.gamestate;

import java.util.ArrayList;
import java.util.List;

import game.common.exceptions.InvalidEnemyNumberException;
import game.data.DataQuery;
import game.entity.creatures.CreatureBase;
import game.entity.creatures.HeroBase;

public class CombatManager {
	List<CreatureBase> creatures;
	int currentIndex;
	HeroBase hero;
	List<CreatureBase> enemies;
	
	
	public CombatManager(HeroBase hero) {
		
		this.creatures = new ArrayList<CreatureBase>();
		this.hero = hero;
		try {
		this.enemies = DataQuery.getEncounter(hero.getLevel());
		} catch(InvalidEnemyNumberException e) {
			e.printStackTrace();
		}
		this.currentIndex = 0;
		
		
		this.creatures.add(hero);
		this.creatures.addAll(enemies);
		
		this.creatures.sort((x, y) -> y.getInitiative()-x.getInitiative());
	}
	
	public List<CreatureBase> getEnemies() {
		return this.enemies;
	}
	
	public CreatureBase getHero() {
		return this.hero;
	}
	
	public String getInitiativeInfo() {
		String output = "";
		for(CreatureBase x : this.creatures) {
			output += String.format("%s starts with initiative of %s \n", x.getName(), x.getInitiative());
		}
		return output;
	}
	
	public String playNextTurn(int target) {
		CreatureBase current = this.creatures.get(this.currentIndex);
		if(current.isDead() ) {
			current = this.creatures.get(++this.currentIndex);
		}
		if(!(current instanceof HeroBase) ) {
			int damage = current.attack();
			this.hero.reduceHp(damage);
			
			this.nextTurn();
			return String.format("%s dealt %s damage to you.", current.getName(), damage);
		}
		int damage = this.hero.attack();
		CreatureBase targetEnemy = this.enemies.get(target);
		if(targetEnemy.isDead() ) {
			return "Target is already dead.";
		}
		targetEnemy.reduceHp(damage);
		this.nextTurn();
		return String.format("You dealt %s damage to %s.", damage, targetEnemy.getName() );
	}
	
	public int checkCombatStatus() {
		if(this.hero.isDead()) {
			return -1;
		}
		int dead = 0;
		int numbers = this.enemies.size();
		for(CreatureBase enemy : this.enemies) {
			if(enemy.isDead() ) {
				dead++;
			}
		}
		if(dead == numbers) {
			return 1;
		}
		
		return 0;
	}
	
	private void nextTurn() {
		this.currentIndex = this.currentIndex >= this.creatures.size() - 1 ? 0 : this.currentIndex + 1;
	}
	

}
