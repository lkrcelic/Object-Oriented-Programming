package fourth.laboratoy.exam.pripremni;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution prviRaz = new Solution();
		prviRaz.addStudentScores("Mateo", 4, 3, 2);
		prviRaz.addStudentScores("Mateo", 4, 3, 2);
		prviRaz.addStudentScores("Luka", 4, 3, 2);
		prviRaz.addStudentScores("Marko", 4, 3, 2);
		//print(prviRaz);
		
		List<String> names = (LinkedList<String>)prviRaz.getInsertionOrderedStudents();
		for(String name : names) {
			System.out.println(name);
		}
		ArrayList<Integer> grades = (ArrayList<Integer>)prviRaz.getNaturallySortedPointsForStudent("Mateo");
		for(Integer grade : grades) {
			System.out.printf("%d, ", grade);
		}
		
		
	}

	public static void print(Solution solution) {
		
		for(String name : solution.getInsertionOrderedStudents()) {
			System.out.println(name);
		}
	}

}
