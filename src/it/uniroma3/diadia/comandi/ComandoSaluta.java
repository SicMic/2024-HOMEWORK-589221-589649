package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando{

	public ComandoSaluta(IO io) {
		super("saluta",io);
	}
	
	public ComandoSaluta() {
		this(null);
	}

	@Override
	public void esegui(Partita partita) {

		if(partita.getStanzaCorrente().getPersonaggio()==null)
			this.getIo().mostraMessaggio("non c'è nessuno da salutare...");
		else {
			if(partita.getStanzaCorrente().getPersonaggio().getClass().getSimpleName().equals("Strega"))
				partita.getStanzaCorrente().getPersonaggio().saluta();
		}
	}

}
