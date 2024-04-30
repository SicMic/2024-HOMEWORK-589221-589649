package it.uniroma3.diadia;

import java.util.Scanner;

public class IOSimulator implements IO{
	
	private static final int messaggiMax = 100;
	
	private String messaggi[] = new String[messaggiMax];
	private int numeroMessaggi = 0;
	private Scanner scannerDiLinee;
	
	public IOSimulator(String comandi) {
		scannerDiLinee = new Scanner(comandi).useDelimiter("\n");
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		messaggi[this.numeroMessaggi] = messaggio;
		this.numeroMessaggi += 1;
	}

	@Override
	public String leggiRiga() {
		String riga = "";
		if (scannerDiLinee.hasNext())
			riga = scannerDiLinee.nextLine();
		
		//scannerDiLinee.close();
		
		return riga;
	}
	
	public String getMessaggio(int indice) {
		return this.messaggi[indice];
	}

}
