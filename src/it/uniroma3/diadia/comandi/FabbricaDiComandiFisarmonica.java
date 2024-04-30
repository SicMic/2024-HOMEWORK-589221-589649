package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{
	
	private IO console;
	
	private String nomeComando;
	private String parametro;
	
	public FabbricaDiComandiFisarmonica(IO console) {
		this.console = console;
	}

	@Override
	public Comando costruisciComando(String istruzione) {
		
		Comando comando = null;

		String cmd[] = istruzione.split(" ");

		if(cmd.length == 0)
			this.nomeComando = "";
		
		else if(cmd[0] != "")
			this.nomeComando = cmd[0];

		if(cmd.length == 2)
			this.parametro = cmd[1];
    	
		if (this.nomeComando == null)
			comando = new ComandoNonValido(this.console);
		else if (this.nomeComando.equals("vai"))
			comando = new ComandoVai(this.console);
		else if (this.nomeComando.equals("prendi"))
			comando = new ComandoPrendi(this.console);
		else if (this.nomeComando.equals("posa"))
			comando = new ComandoPosa(this.console);
		else if (this.nomeComando.equals("aiuto"))
			comando = new ComandoAiuto(this.console);
		else if (this.nomeComando.equals("fine"))
			comando = new ComandoFine(this.console);
		else if (this.nomeComando.equals("guarda"))
			comando = new ComandoGuarda(this.console);
		else comando = new ComandoNonValido(this.console);
		comando.setParametro(this.parametro);
		return comando;
	}
}
