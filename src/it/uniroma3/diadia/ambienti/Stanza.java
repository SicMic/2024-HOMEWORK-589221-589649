package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.*;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
	
	private Map<String, Stanza> direzione2stanza;
	private Map<String, Attrezzo> nomeAttrezzo2Attrezzo;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.nomeAttrezzo2Attrezzo = new HashMap<>();
        this.direzione2stanza  = new HashMap<>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
        
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
    	/* se la  direzione esiste già aggiorno soltanto la stanza, altrimenti se il numero di chiavi è minore 
    	 * del numero massimo di direzioni aggiungo la coppia direzione : stanza*/
    	
        if (stanza!=null || this.direzione2stanza.size()<NUMERO_MASSIMO_DIREZIONI || this.direzione2stanza.containsKey(direzione));
        	this.direzione2stanza.put(direzione, stanza);
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
		
		return this.direzione2stanza.get(direzione);
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
//    public Attrezzo[] getAttrezzi() {
//        return this.attrezzi;
//    }
    
    public Map<String, Attrezzo> getAttrezzi(){
    	return this.nomeAttrezzo2Attrezzo;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */

    public boolean addAttrezzo(Attrezzo attrezzo) {
    	if (attrezzo == null)
    		return false;
    	
    	if (nomeAttrezzo2Attrezzo.size() < NUMERO_MASSIMO_ATTREZZI) {
    		nomeAttrezzo2Attrezzo.put(attrezzo.getNome(), attrezzo);
    		return true;
    	}
    	return false;
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	for (String direzione : this.getDirezioni())				// va sostituito con toString ? <-------
    		risultato.append(" " + direzione);
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (String nomeAttrezzo : this.nomeAttrezzo2Attrezzo.keySet()) {
    		if(nomeAttrezzo2Attrezzo.get(nomeAttrezzo) != null)
    			risultato.append(this.nomeAttrezzo2Attrezzo.get(nomeAttrezzo).toString()+" ");
    	}
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		
		return this.nomeAttrezzo2Attrezzo.containsKey(nomeAttrezzo);
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.nomeAttrezzo2Attrezzo.get(nomeAttrezzo);
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {

		if (!this.nomeAttrezzo2Attrezzo.containsKey(attrezzo.getNome()))
			return false;
		
		return this.nomeAttrezzo2Attrezzo.remove(attrezzo.getNome()) != null;
	}


	public Set<String> getDirezioni() {
		Set<String> direzioni;
		
		direzioni = this.direzione2stanza.keySet();
		
		return direzioni;
    }

}