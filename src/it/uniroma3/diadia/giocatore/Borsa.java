package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziNome;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPeso;

import java.util.*;

import org.w3c.dom.Attr;

public class Borsa{

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private int pesoMax;
	private int pesoBorsa;
	
	private HashMap<String, Attrezzo> nomeAttrezzo2Attrezzo;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.pesoBorsa = 0;
		this.nomeAttrezzo2Attrezzo  = new HashMap<>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null)
			return false;
		
		if (this.pesoBorsa + attrezzo.getPeso() > this.getPesoMax())
			return false;
		
		nomeAttrezzo2Attrezzo.put(attrezzo.getNome(), attrezzo);
		this.pesoBorsa += attrezzo.getPeso();
		return true;
	}

	public int getPesoMax() {
		return this.pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) { 
		
		return nomeAttrezzo2Attrezzo.get(nomeAttrezzo);
	}


	public int getPeso() {
		
		return this.pesoBorsa;
	}

	public boolean isEmpty() {
		return this.nomeAttrezzo2Attrezzo.isEmpty();
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.nomeAttrezzo2Attrezzo.containsKey(nomeAttrezzo);
	}
	
	//in che modo si può ottimizzare la remove?
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		
		if (!this.nomeAttrezzo2Attrezzo.containsKey(nomeAttrezzo))
			return null;
		
		this.pesoBorsa -= nomeAttrezzo2Attrezzo.get(nomeAttrezzo).getPeso();
		return nomeAttrezzo2Attrezzo.remove(nomeAttrezzo);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.nomeAttrezzo2Attrezzo.keySet().isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			
			for(String nomeAttrezzo : this.nomeAttrezzo2Attrezzo.keySet())
				s.append(nomeAttrezzo2Attrezzo.get(nomeAttrezzo).toString() + " ");
			
			s.append("\n[ ");
			for(Attrezzo elemento:this.getContenutoOrdinatoPerPeso())
				s.append(elemento.getNome() + ", ");
			s.append("]\n");
			
			s.append("\n{");
			for(Attrezzo elemento : this.getContenutoOrdinatoPerNome())
				s.append(elemento.getNome() + ", ");
			s.append("}\n");
			
//			Map<Integer, Set<Attrezzo>> gruppo = this.getContenutoRaggruppatoPerPeso();
//			for (Integer pesoAttrezzo : gruppo.keySet()) {
//				Set<Attrezzo> insiemeStessoPeso = gruppo.get(pesoAttrezzo);
//				s.append("(" +  pesoAttrezzo + ":");
//				for(Attrezzo attrezzo : insiemeStessoPeso)
//					s.append(attrezzo.getNome());
//				s.append(")  ");
//			}
			
		} 
		else
			s.append("Borsa vuota");
		
		return s.toString();
	}
	

	public List <Attrezzo> getContenutoOrdinatoPerPeso(){
		
		if(this.nomeAttrezzo2Attrezzo.isEmpty())
			return null;
		
		List<Attrezzo> sortedAttrezziPeso = new ArrayList<>(this.nomeAttrezzo2Attrezzo.values());
		Collections.sort(sortedAttrezziPeso, new ComparatoreAttrezziPeso());
		return sortedAttrezziPeso;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		
		if (this.nomeAttrezzo2Attrezzo.isEmpty())
			return null;
		
		SortedSet<Attrezzo> sortedAttrezziNome = new TreeSet<>(new ComparatoreAttrezziNome());
		
		sortedAttrezziNome.addAll(this.nomeAttrezzo2Attrezzo.values());
		return sortedAttrezziNome;
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		
		if (this.nomeAttrezzo2Attrezzo.isEmpty())
			return null;
		
		Set<Attrezzo> valore;
		Set<Attrezzo> insiemeValori = (HashSet<Attrezzo>)nomeAttrezzo2Attrezzo.values();
		
		Map<Integer, Set<Attrezzo>> peso2attrezzi = new HashMap<>();
		for(Attrezzo elemento : insiemeValori) {
			valore = peso2attrezzi.get(elemento.getPeso());
			
			if (valore == null) {
				Set<Attrezzo> insiemePeso = new HashSet<>();
				insiemePeso.add(elemento);
				peso2attrezzi.put(elemento.getPeso(), insiemePeso);
			}
			else
				valore.add(elemento);
		}
		
		return peso2attrezzi;
	}
		
	// --------- Fare i test ------------
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> sorteSetPeso = new TreeSet<>(this.getContenutoOrdinatoPerPeso());
		return sorteSetPeso;
	}
}