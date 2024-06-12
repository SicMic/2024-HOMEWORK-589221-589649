package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Set;

import it.uniroma3.diadia.properties.CaricatoreProperties;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerPeso;
import it.uniroma3.diadia.attrezzi.ComparatorePerPesoENome;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = CaricatoreProperties.getPesoMax();
	private Map<String,Attrezzo> attrezzi;
	private int pesoMax;
	private int pesoCorrente;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String,Attrezzo>();
		this.pesoCorrente = 0;
	}

	/**
	 * Aggiunge un attrezzo alla borsa dopo aver controllato che 
	 * l'aggiunta non faccia superare il peso massimo disponibile
	 * @param attrezzo
	 * @return true in caso di aggiunta false altrimenti
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo==null) return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.pesoCorrente+=attrezzo.getPeso();
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	/**
	 * Cerca nella borsa l'attrezzo con il nome passato come 
	 * parametro, in caso lo trovi lo restituisce in uscita
	 * @param nomeAttrezzo
	 * @return l'attrezzo cercato o null in caso non venga trovato
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	public int getPeso() {
		return this.pesoCorrente;
	}

	/*+
	 * controlla se la borsa sia vuota
	 */
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	/**
	 * Controlla se all'interno della borsa esista 
	 * un attrezzo con il nome passato per parametro
	 * @param nomeAttrezzo
	 * @return true se esiste false altrimenti
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
	 * cerca l'attrezzo dal nome e in caso sia presente lo rimuove dalla borsa ritornandolo
	 * @param nomeAttrezzo
	 * @return l'attrezzo cercato o null in caso non sia presente
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo cercato = null;
		if(this.attrezzi.containsKey(nomeAttrezzo)) {
			this.pesoCorrente-=this.attrezzi.get(nomeAttrezzo).getPeso();
			cercato = this.attrezzi.get(nomeAttrezzo);
			this.attrezzi.remove(nomeAttrezzo);
			this.attrezzi.keySet().remove(nomeAttrezzo);
		}
		return cercato;
	}

	/**
	 * Restituisce una stringa con all'interno una descrizione del contenuto della borsa
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (this.isEmpty()) {
			s.append("Borsa vuota");
			return s.toString();
		}
		s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
		for(Attrezzo a : this.attrezzi.values())
			s.append(a.toString()+" ");
		return s.toString();
	}

	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> ordinata = new ArrayList<Attrezzo>(this.attrezzi.values());
		ComparatorePerPeso comparatore = new ComparatorePerPeso();
		Collections.sort(ordinata, comparatore);
		return ordinata;
	}

	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<Attrezzo>(attrezzi.values());
	}

	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		int pesoAttrezzo=-1;
		Attrezzo a;
		List<Attrezzo> attrezziSet = new ArrayList<Attrezzo>();
		List<Attrezzo> ordinata = new ArrayList<Attrezzo>(this.attrezzi.values());
		ComparatorePerPeso comparatore = new ComparatorePerPeso();
		Collections.sort(ordinata, comparatore);
		ListIterator<Attrezzo> iteratore = ordinata.listIterator();
		Map<Integer,Set<Attrezzo>> mappa = new TreeMap<Integer,Set<Attrezzo>>();
		while(iteratore.hasNext()) {
			a=iteratore.next();
			if(a.getPeso()==pesoAttrezzo || pesoAttrezzo==-1) {
				pesoAttrezzo=a.getPeso();
				attrezziSet.add(a);
			} else {
				attrezziSet.removeAll(attrezzi.values());
				pesoAttrezzo=a.getPeso();
				attrezziSet.add(a);
			}
			SortedSet<Attrezzo> setOrdinatoPerNome = new TreeSet<Attrezzo>(attrezziSet);
			mappa.put(pesoAttrezzo, setOrdinatoPerNome);
		}
		return mappa;
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatorePerPesoENome comparatore = new ComparatorePerPesoENome();
		SortedSet<Attrezzo> ordinato = new TreeSet<Attrezzo>(comparatore);
		ordinato.addAll(attrezzi.values());
		return ordinato;
	}
}