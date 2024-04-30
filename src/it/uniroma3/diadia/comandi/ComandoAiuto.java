package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	
	private IO console;
	
	public ComandoAiuto(IO console) {
		this.console = console;
	}

	@Override
	public void esegui(Partita partita) {
		
			console.mostraMessaggio("Comandi:");
			for(int i=0; i< elencoComandi.length; i++) 
				console.mostraMessaggio("- "+elencoComandi[i]+" ");
			console.mostraMessaggio("");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String getNome() {
		return "aiuto";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
