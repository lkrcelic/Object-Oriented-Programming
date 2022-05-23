package fifth.laboratoy.exam.pravi.prvi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		List<Match> matches = new ArrayList();
		Map<String, Player> mplayers = new HashMap();    // key = player name, value = Player object

		// Popunjavanje mape s igračima i liste partija
		mplayers.put("Caruana", new Player("Caruana", 2820));
		mplayers.put("Carlsen", new Player("Carlsen", 2847));
		mplayers.put("Radjabov", new Player("Radjabov", 2765));

		matches.add(new Match("Carlsen", "Radjabov", Result.RESULT_WHITE_WIN));
		matches.add(new Match("Caruana", "Carlsen", Result.RESULT_BLACK_WIN));
		matches.add(new Match("Caruana", "Radjabov", Result.RESULT_DRAW));
		matches.forEach((match) -> {
			
						 
							if(match.getResult() == Result.RESULT_WHITE_WIN) {
								double curr = mplayers.get(match.getWhitePlayer()).getPoints();
								mplayers.get(match.getWhitePlayer()).setPoints(curr + 1);
							}
							else if(match.getResult() == Result.RESULT_BLACK_WIN) {
								double curr = mplayers.get(match.getBlackPlayer()).getPoints();
								mplayers.get(match.getBlackPlayer()).setPoints(curr + 1);
							}
							else if(match.getResult() == Result.RESULT_DRAW) {
								double curr1 = mplayers.get(match.getBlackPlayer()).getPoints();
								mplayers.get(match.getBlackPlayer()).setPoints(curr1 + 0.5);
								double curr2 = mplayers.get(match.getWhitePlayer()).getPoints();
								mplayers.get(match.getWhitePlayer()).setPoints(curr2 + 0.5);
							}
							
						
					});
		
//		matches.forEach(new Consumer<Match>() {
//
//			@Override
//			public void accept(Match match) {
//				if(match.getResult() == Result.RESULT_WHITE_WIN) {
//					double curr = mplayers.get(match.getWhitePlayer()).getPoints();
//					mplayers.get(match.getWhitePlayer()).setPoints(curr + 1);
//				}
//				else if(match.getResult() == Result.RESULT_BLACK_WIN) {
//					double curr = mplayers.get(match.getBlackPlayer()).getPoints();
//					mplayers.get(match.getBlackPlayer()).setPoints(curr + 1);
//				}
//				else if(match.getResult() == Result.RESULT_DRAW) {
//					double curr1 = mplayers.get(match.getBlackPlayer()).getPoints();
//					mplayers.get(match.getBlackPlayer()).setPoints(curr1 + 0.5);
//					double curr2 = mplayers.get(match.getWhitePlayer()).getPoints();
//					mplayers.get(match.getWhitePlayer()).setPoints(curr2 + 0.5);
//				}
//				
//			}
//		});

		for(Entry<String, Player> entry : mplayers.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue().getPoints());
		}
	}

}
