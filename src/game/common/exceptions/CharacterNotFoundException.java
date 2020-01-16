package game.common.exceptions;

public class CharacterNotFoundException extends Exception {
	public CharacterNotFoundException(String character) {
		super(String.format("Character not found: %s", character));
	}
}
