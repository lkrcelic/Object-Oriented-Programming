package third.laboratoy.exam;

public class Agent<K,V extends Number> {
	private K name;
	private V value;
	public Agent(K name, V value) {
		this.name = name;
		this.value = value;
	}
	public K getName() {
		return name;
	}
	public void setName(K name) {
		this.name = name;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
	public boolean notificationHigherThanTen(Agent another) {
//	metoda vraća true ako je zbroj članskih varijabla value u objektu na koji se metoda 
//	poziva i u objektu navedenom kao argument metode veći od 10.
		if(this.value.doubleValue() + another.value.doubleValue() > 10) { // moguca greska
			return true;
		}
		return false;
	}
	
	public String nameConcatenator(Agent another) {
		if(this.getName() instanceof String && another.getName() instanceof String) {
			return this.getName() + "+" + another.getName();
		}
		return "Type Error";
	}	
	
}
