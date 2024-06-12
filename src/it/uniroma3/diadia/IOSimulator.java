package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class IOSimulator implements IO{
	private List<String> input;
	private List<String> output;
	private Iterator<String> countIN;
	private Iterator<String> countOUT;
	
	public void setInput(List<String> comandi) {
		this.input=comandi;
	}
	
	public List<String> getOutput() {
		return output;
	}
	
	public Iterator<String> getCountOUT() {
		return countOUT;
	}
	
	@Override
	public String leggiRiga() {
		String riga = null;

		if(countIN.hasNext()) riga = countIN.next();
		return riga;
	}
	
	@Override
	public void mostraMessaggio(String messaggio) {
		this.output.add(messaggio);
	}
	
	public IOSimulator() {
		this.input = new ArrayList<String>();
		this.countIN = input.iterator();
		this.output = new ArrayList<String>();
		this.countOUT = output.iterator();
	}
	
	public IOSimulator(List<String> righeDaLeggere) {
		this.input = righeDaLeggere;
		this.countIN = input.iterator();
		this.output = new ArrayList<String>();
		this.countOUT = output.iterator();
	}
}
