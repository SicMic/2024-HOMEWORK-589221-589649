package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

	@Override
	public AbstractComando costruisciComando(String istruzione, IO io) {
		try (Scanner scanner = new Scanner(istruzione)) {
			String nomeComando = null;
			String parametro = null;
			AbstractComando comando = null;

			if (scanner.hasNext())
				nomeComando = scanner.next();
			if (scanner.hasNext())
				parametro = scanner.next();

			try {
				StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
				nomeClasse.append(Character.toUpperCase(nomeComando.charAt(0)));
				nomeClasse.append(nomeComando.substring(1));
				comando = (AbstractComando)Class.forName(nomeClasse.toString()).newInstance();
				comando.setIO(io);
				comando.setParametro(parametro);
			} catch (Exception e) {
				comando = new ComandoNonValido(io);
			}
			return comando;
		}
	}

}