package game.data;

import game.common.exceptions.CharacterNotFoundException;
import game.common.exceptions.InvalidEnemyNumberException;
import game.entity.creatures.*;

import org.json.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DataQuery {
	public static HeroBase getHero(String name) throws CharacterNotFoundException {
		String resourceName = "/data/heroes.json";
		 InputStream is = DataQuery.class.getResourceAsStream(resourceName);
	        if (is == null) {
	            throw new NullPointerException("Cannot find resource file " + resourceName);
	        }
	        JSONTokener tokener = new JSONTokener(is);
	        JSONObject object = new JSONObject(tokener);
	       
	        JSONObject stats = object.getJSONObject(name);
	        
	        switch(name) {
	        case "Warrior": 
	        	return new Warrior(
	        			name,
		        		1,
		        		stats.getInt("strength"),
		        		stats.getInt("dexterity"),
		        		stats.getInt("constitution"),
		        		stats.getInt("wisdom"),
		        		stats.getInt("intelligence"),
		        		stats.getInt("charisma")
	        			);
	        case "Archer":
	        	return new Archer(
	        			name,
		        		1,
		        		stats.getInt("strength"),
		        		stats.getInt("dexterity"),
		        		stats.getInt("constitution"),
		        		stats.getInt("wisdom"),
		        		stats.getInt("intelligence"),
		        		stats.getInt("charisma")
		        		);
	        case "Wizard":
	        	return new Wizard(
	        			name,
		        		1,
		        		stats.getInt("strength"),
		        		stats.getInt("dexterity"),
		        		stats.getInt("constitution"),
		        		stats.getInt("wisdom"),
		        		stats.getInt("intelligence"),
		        		stats.getInt("charisma")
	        			);
	        default: 
	        	throw new CharacterNotFoundException(name);
	        }
	        
	  
	}
	
	public static BasicEnemy getEnemy(String name) {
		String resourceName = "/data/enemies.json";
		 InputStream is = DataQuery.class.getResourceAsStream(resourceName);
	        if (is == null) {
	            throw new NullPointerException("Cannot find resource file " + resourceName);
	        }
	        JSONTokener tokener = new JSONTokener(is);
	        JSONObject object = new JSONObject(tokener);
	       
	        JSONObject stats = object.getJSONObject(name);
	        
	        return new BasicEnemy(
	        		name,
	        		stats.getInt("level"),
	        		stats.getInt("strength"),
	        		stats.getInt("dexterity"),
	        		stats.getInt("constitution"),
	        		stats.getInt("wisdom"),
	        		stats.getInt("intelligence"),
	        		stats.getInt("charisma")
	        		);
	}
	
	public static List<CreatureBase> getEncounter(int level) throws InvalidEnemyNumberException {
		String resourceName = "/data/encounters.json";
		 InputStream is = DataQuery.class.getResourceAsStream(resourceName);
	        if (is == null) {
	            throw new NullPointerException("Cannot find resource file " + resourceName);
	        }
	        JSONTokener tokener = new JSONTokener(is);
	        JSONObject object = new JSONObject(tokener);
	       
	        JSONArray names = object.getJSONArray(Integer.toString(level));
	        
	        List<CreatureBase> creatures = new ArrayList<CreatureBase>();
	        
	        final int length = names.length();
	        
	        if(length > 3 || length < 0) {
	        	throw new InvalidEnemyNumberException();
	        }
 	        
	        for(int i = 0; i < length ; ++i) {
	        	creatures.add(DataQuery.getEnemy(names.getString(i)));
	        }
	        
	        return creatures;
	}
}
