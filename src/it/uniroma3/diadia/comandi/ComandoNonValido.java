package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando{
	
	public ComandoNonValido(IO io) {
		super("comando non valido", io);
	}
	
	public ComandoNonValido() {
		this(null);
	}

	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Comando Sconosciuto");
		
	}

}
