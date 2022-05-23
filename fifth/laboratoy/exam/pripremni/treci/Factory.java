package fifth.laboratoy.exam.pripremni.treci;

public class Factory extends Game {
	
	
	public Factory(String name, int score) {
		super(name);
		setRating(score);
	}

	public static Game createGame(String name, int score) {
		return new Factory(name, score);
	}
	
}
