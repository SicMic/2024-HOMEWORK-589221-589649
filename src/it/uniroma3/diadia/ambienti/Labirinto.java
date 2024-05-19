package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaFinale;

	public Labirinto() {
		this.creaStanze();
	}
	
	public void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza aulaN12 = new StanzaMagica("Aula N12", 2);
		Stanza aulaN9 = new StanzaBuia("Aula N9", "lanterna");
		Stanza aulaN8 = new StanzaBloccata("Aula N8", "est");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		
		/* aggiunta stanza magica */
		aulaN12.impostaStanzaAdiacente("sud", aulaN11);
		aulaN11.impostaStanzaAdiacente("nord", aulaN12);
		
		/* aggiunta stanza buia*/
		aulaN9.impostaStanzaAdiacente("nord", aulaN10);
		laboratorio.impostaStanzaAdiacente("sud", aulaN9);
		aulaN10.impostaStanzaAdiacente("sud", aulaN9);
		aulaN11.impostaStanzaAdiacente("sud", aulaN9);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
        stanzaIniziale = atrio;  
		stanzaFinale = biblioteca;
    }
	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}
	
	public void setStanzaFinale(Stanza stanzaFinale){
		this.stanzaFinale = stanzaFinale;
	}
	
	public Stanza getStanzaFinale() {
		return this.stanzaFinale;
	}
	
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
}
