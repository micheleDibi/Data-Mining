package data;

import java.util.ArrayList;
import java.util.Iterator;

public class Example {
	
	private ArrayList<Object> example;

	public Example(int size) {
		example = new ArrayList<Object>(size);
	}
	
	public void set(Object o, int index) {
		
		if(index < example.size()) {
			example.set(index, o);
		} else {
			example.add(index, o);
		}
	}
	
	public Object get(int index) {
		return example.get(index);
	}
	
	public String toString() {
		Iterator<Object> it = example.iterator();
		String s = new String("\n");
		int index = 0;
		
		while(it.hasNext()) {
			s = s + "oggetto: " + it.next().toString() + "\n";
			index++;
		}
		
		return s;
		
	}
	
	
	//scambia i valori contenuti nel campo example dell'oggetto corrente 
	//con i valori contenuti nel campo example del parametro e
	public void swap(Example e) {
		
		if (this.example.size() != e.example.size())
			throw new ExampleSizeException("Dimensione dei due esempi passati differenti");
		
		//Iterator<Object> it = example.iterator();

		
		for (int i = 0; i < this.example.size(); i++) {
			Object supp = e.get(i);		//oggetto di supporto per lo scambio
			e.set(this.get(i), i);
			this.set(supp, i);
		}
	}
	
	//calcola e restituisce la distanza di Hamming calcolata tra l’istanza di Example passata
	//come parametro e quella corrente
	double distance(Example e) {
		
		if (this.example.size() != e.example.size())
			throw new ExampleSizeException("Dimensione dei due esempi passati differenti");
		
		double distance = 0;
		
		for	(int i = 0; i < this.example.size(); i++) {
			
			if(e.get(i) instanceof String) {
				System.out.println("Sono nello string");
				if(!(e.get(i).equals(this.get(i)))) {
					distance++;
				}
			} else if(e.get(i) instanceof Double) {
				System.out.println("Sono nell double");
				distance = distance + Math.abs((Double)this.get(i) - (Double)e.get(i));
			}
			
			System.out.println("iterata: " + i + " distanza: " + distance);
			
		}
	
		//System.out.println(distance);
		return distance;
	}
	
}
