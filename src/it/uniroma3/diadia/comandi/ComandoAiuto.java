package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{
	public ComandoAiuto(IO io) {
		super("aiuto",io);
	}

	public ComandoAiuto() {
		this(null);
	}

	/**
	 * Stampa informazioni di aiuto.
	 */
	@Override
	public void esegui(Partita partita) {
		boolean primo = true;
		StringBuilder s = new StringBuilder("comandi accettati:");
		for(ElencoComandi comando : ElencoComandi.values()) {
			if(primo) {
				s.append(" "+comando);
				primo = false;
			}else
				s.append(", "+comando);
		}
		this.getIo().mostraMessaggio(s.toString());
	}
}
