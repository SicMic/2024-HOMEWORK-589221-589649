package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando {
	private String messaggio;
	
	public ComandoInteragisci(IO io) {
		super("interagisci",io);
	}
	
	public ComandoInteragisci() {
		this(null);
	}
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.messaggio = personaggio.agisci(partita);
			this.getIo().mostraMessaggio(this.messaggio);

		} else this.getIo().mostraMessaggio("con chi vuoi interagire");
	}
	public String getMessaggio() {
		return this.messaggio;
	}
}
