package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
	
	private IO console;
	
	public ComandoGuarda(IO console) {
		this.console = console;
	}

	@Override
	public void esegui(Partita partita) {
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		console.mostraMessaggio("Numero CFU : " + partita.getGiocatore().getCfu());
		console.mostraMessaggio(partita.getGiocatore().getBorsa().toString());		
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
