package fourth.laboratoy.exam.pravi;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class TataSteel {
//	U mapi Map<Integer, Map<String, Double>> nalaze se rezultati glavnog dijela 
//	turnira po godinama. Ključ mape je godina odigravanja turnira (Integer), 
//	dok je vrijednost nova mapa, u kojoj je ključ prezime igrača (String), 
//	a vrijednost broj bodova koje je taj igrač ostvario na turniru (Double).
	
	public List<String> getAllParticipants(Map<Integer, Map<String, Double>> tataSteelStandings) {
//		Koja će primiti mapu s rezultatima turnira (opisanu ranije) i vratiti 
//		novu listu koja sadrži sve igrače koji su do sada nastupali na Tata Steel 
//		turnirima, BEZ DUPLIKATA. Lista treba biti sortirana po abecedi (od A do Z)
		LinkedList<String> names = new LinkedList<>();
		Set<String> set = new TreeSet<>();
		for(Map<String, Double> map : tataSteelStandings.values()) {
			for(String name : map.keySet()) {
				set.add(name);
			}	
		}
		names.addAll(set);
		return names;
	}
}
