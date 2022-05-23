package fifth.laboratoy.exam.pripremni.drugi;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class FactorialIterator implements Iterator<Integer>{
//	Potrebno je napisati klasu FactorialIterator koja implementirata sučelje java.util.Iterator<Integer>. 
//	Klasi se u konstruktoru prosljeđuje koliko brojeva će generirati. Ako se pošalje negativan broj 
//	potrebno je baciti iznimku.
//
//	Klasa ima vidljivost postavljenu na package private.
	
	private int numOfIterations;
	private int index = 0;
	private int rez = 1;
	public FactorialIterator(int numOfIterations) {
		if(numOfIterations < 0)
			throw new RuntimeException();
		this.numOfIterations = numOfIterations;
	}
	
	@Override
	public boolean hasNext() {
		return index >= numOfIterations ? false : true;
	}

	@Override
	public Integer next() {
		if(!hasNext())
			throw new NoSuchElementException();
		if(index > 1)
			rez *= (index);
		index++;
		return rez;
	}

	
	
}
