package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	@Override
	public AbstractComando costruisciComando(String istruzione, IO io) {
		try(Scanner scannerDiParole = new Scanner(istruzione)){
			String nomeComando = null;
			String parametro = null;
			AbstractComando comando = null;
			
			if (scannerDiParole.hasNext())
				nomeComando = scannerDiParole.next();// prima parola: nome del comando
			if (scannerDiParole.hasNext())
				parametro = scannerDiParole.next(); // seconda parola: eventuale param.
			
			if (nomeComando == null)
				comando = new ComandoNonValido(io);
			else if (nomeComando.equals("vai"))
				comando = new ComandoVai(io);
			else if (nomeComando.equals("prendi"))
				comando = new ComandoPrendi(io);
			else if (nomeComando.equals("posa"))
				comando = new ComandoPosa(io);
			else if (nomeComando.equals("aiuto"))
				comando = new ComandoAiuto(io);
			else if (nomeComando.equals("fine"))
				comando = new ComandoFine(io);
			else if (nomeComando.equals("guarda"))
				comando = new ComandoGuarda(io);
			else comando = new ComandoNonValido(io);
			comando.setParametro(parametro);
			return comando;
		}
		
	}
}
