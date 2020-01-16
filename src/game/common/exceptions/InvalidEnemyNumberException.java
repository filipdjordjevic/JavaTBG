package game.common.exceptions;

public class InvalidEnemyNumberException extends Exception {
	
	public InvalidEnemyNumberException() {	
		super("Cannot create instance with less than 1 enemy or more than 3 enemies.");
	}
}
