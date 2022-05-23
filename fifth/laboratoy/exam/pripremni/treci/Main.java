package fifth.laboratoy.exam.pripremni.treci;

public class Main {

	public static void main(String[] args) {
		Game g1 = Factory.createGame("Super Mario", 90);
		Game g2 = Factory.createGame("Heroes", 80);            
		MyPlayer p = new MyPlayer("Mario");
		
//		b) iteriranje po igrama i�lo po nazivu igre 
//		(prvo Heroes s 50 i 70, a onda Super Mario s 300, 400, 200 i 400), 
//		a iteriranje po ostvarenim rezultatima u igri po redoslijedu kojim je rezultat ostvaren
		
		p.addGameScore(g1, 300);
		p.addGameScore(g1, 400);
		p.addGameScore(g2, 50);
		p.addGameScore(g1, 200);
		p.addGameScore(g1, 400);
		p.addGameScore(g2, 70);
		
		for(Game g : p) {
		    for(int score : p.getScores(g)) {
		        System.out.println(score);
		    }
		}

	}
}
