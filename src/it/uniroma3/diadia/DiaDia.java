package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca(IOConsole console) {
		String istruzione;

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do
			istruzione = console.leggiRiga();
		while (!processaIstruzione(istruzione, console));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione, IOConsole console) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if (comandoDaEseguire.getNome() != null)

			if (comandoDaEseguire.getNome().equals("fine")) {
				this.fine(console); 
				return true;
				
			} else if (comandoDaEseguire.getNome().equals("vai")) {
				this.vai(comandoDaEseguire.getParametro(), console);
				
			} else if (comandoDaEseguire.getNome().equals("aiuto")) {
				this.aiuto(console);
				
			} else if (comandoDaEseguire.getNome().equals("prendi")){
				this.prendi(comandoDaEseguire.getParametro(), console);
				
			} else if(comandoDaEseguire.getNome().equals("posa")) {
				this.posa(comandoDaEseguire.getParametro(), console);
				
			}
			else
				console.mostraMessaggio("Comando sconosciuto");
		
		if (this.partita.vinta()) {
			console.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;

	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto(IOConsole console) {
		console.mostraMessaggio("Comandi:");
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio("- "+elencoComandi[i]+" ");
		console.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione, IOConsole console) {
		if(direzione==null)
			console.mostraMessaggio("Dove vuoi andare ?");
			
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		console.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
	}
	
	private void prendi(String attrezzo, IOConsole console) {
		
		Stanza stanza = this.partita.getStanzaCorrente();
		Borsa borsa = this.partita.getGiocatore().getBorsa();
		
//		Attrezzo attrezzoDaPrendere = stanza.getAttrezzo(attrezzo);
//		
//		if(stanza.removeAttrezzo(attrezzoDaPrendere))
//			if(borsa.addAttrezzo(attrezzoDaPrendere))
//				console.mostraMessaggio("Attrezzo preso!");
//		
//		else {
//			stanza.addAttrezzo(attrezzoDaPrendere);
//			console.mostraMessaggio("Operazione non riuscita!");
//		}
		
		boolean aggiunto = false;
		boolean rimosso = false;
		
		if (borsa.addAttrezzo(stanza.getAttrezzo(attrezzo))) {
			aggiunto = true;
			if (stanza.removeAttrezzo(stanza.getAttrezzo(attrezzo)))
				rimosso = true;
		}
		
		if (aggiunto && rimosso)
			console.mostraMessaggio("Attrezzo preso!");
		
		else if(aggiunto == true && rimosso == false) {
			borsa.removeAttrezzo(attrezzo);
			console.mostraMessaggio("Operazione non riuscita");
			
		} else
			console.mostraMessaggio("Operazione non riuscita");
		
	}
	
	private void posa(String attrezzo, IOConsole console) {
		
		Stanza stanza = this.partita.getStanzaCorrente();
		Borsa borsa = this.partita.getGiocatore().getBorsa();
		
		Attrezzo attrezzoDaPosare = borsa.getAttrezzo(attrezzo);
		
		boolean rimosso = false;
		boolean aggiunto = false;

		if (attrezzoDaPosare != null) {
			if(borsa.removeAttrezzo(attrezzoDaPosare.getNome()) != null) {
				rimosso = true;
				if (stanza.addAttrezzo(attrezzoDaPosare))
					aggiunto = true;
			}
		}
		
		if (rimosso && aggiunto)
			console.mostraMessaggio("Attrezzo posato!");
		
		else if (rimosso && !aggiunto) {
			borsa.addAttrezzo(attrezzoDaPosare);
			console.mostraMessaggio("Operazione non riuscita");
			
		} else
			console.mostraMessaggio("Operazione non riuscita");
		

	}

	/**
	 * Comando "Fine".
	 */
	private void fine(IOConsole console) {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia();
		gioco.gioca(console);
	}
}