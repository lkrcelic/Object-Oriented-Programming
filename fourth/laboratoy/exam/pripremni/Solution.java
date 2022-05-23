package fourth.laboratoy.exam.pripremni;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution implements StudentScoreStatistics {
	private Map<String, ArrayList<Integer>> map = new LinkedHashMap<>();

	public Solution() {
	}

	@Override
	public void addStudentScores(String student, Integer... scores) {
		if (!map.containsKey(student)) {
			ArrayList<Integer> temp = new ArrayList<>(scores.length);
			for (Integer score : scores) {
				temp.add(score);
			}
			this.map.put(student, temp);
		} else {
			for (Integer score : scores) {
				map.get(student).add(score);
			}
			this.map.put(student, map.get(student));
		}

	}

	@Override
	public Collection<String> getInsertionOrderedStudents() {
		LinkedList<String> temp= new LinkedList<>();
		if(this.map.isEmpty())
			return temp;
		else {
			for(String name : this.map.keySet()) {
				temp.add(name);
			}
			return temp;
		}
	}

	@Override
	public Collection<Integer> getNaturallySortedPointsForStudent(String student) {
		if(!map.containsKey(student))
			return null;
		ArrayList<Integer> arr =  this.map.get(student);
		Collections.sort(arr);
	    return arr;
	}

}

/**
 * Sucelje specificira funkcionalnosti vezane uz statisticku obradu bodova
 * studenata. Jedan student moze imati vise bodova
 */

interface StudentScoreStatistics {
	/**
	 * 
	 * Za studenta biljezi bodove. Mozete pretpostaviti da ce argumenti uvijek biti
	 * valjani (nece biti null). Vazno: u praksi je moguce vise puta pozvati ovu
	 * metodu za istog studenta. Npr.: stat.addStudentScores("Luka", 4, 1, 2);
	 * stat.addStudentScores("Luka", 1, 4);
	 * 
	 * 
	 * @param student student za kojeg se biljeze bodovi
	 * @param scores  bodovi studenta
	 */
	void addStudentScores(String student, Integer... scores);

	/**
	 * 
	 * @return Vraca kolekciju zabiljezenih studenata prema redoslijedu dodavanja.
	 *         Vraca praznu kolekciju ako nema zabiljezenih studenata.
	 */
	Collection<String> getInsertionOrderedStudents();

	/**
	 * @param student
	 * @return vraca bodove za studenta, sortirane prema prirodnom poretku. Ako nema
	 *         studenta metoda vraca null.
	 */
	Collection<Integer> getNaturallySortedPointsForStudent(String student);

}