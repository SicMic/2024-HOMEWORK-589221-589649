package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOSimulator implements IO{
	
	private static final int messaggiMax = 100;
	
	
	private List<String> messaggi;
	private Scanner scannerDiLinee;
	
	public IOSimulator(String comandi) {
		this.messaggi = new ArrayList<>();
		scannerDiLinee = new Scanner(comandi).useDelimiter("\n");
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggi.add(messaggio);
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
		return this.messaggi.get(indice);
	}

}
