package fifth.laboratoy.exam.pripremni.treci;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyPlayer extends Player implements Iterable<Game> {

	private Map<Game, List<Integer>> map;
	
	public MyPlayer(String string) {
		super(string);
		map = new TreeMap<>(new Comparator<Game>() {

			@Override
			public int compare(Game g1, Game g2) {
				return g1.getName().compareTo(g2.getName());
			}
		
		});
	}

	public void addGameScore(Game game, int score) {
		if(this.map.containsKey(game)) 
			map.get(game).add(score);
			else {
				map.put(game, new ArrayList<Integer>());
				map.get(game).add(score);
			}
		
	}

	@Override
	public Iterator<Game> iterator() {
		return map.keySet().iterator();
	}

	@Override
	Iterable<Integer> getScores(Game game) {
		return this.map.get(game);
	}

	

}
