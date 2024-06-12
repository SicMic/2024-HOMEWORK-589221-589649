package it.uniroma3.diadia.comandi;

import java.io.IOException;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {
	private IO io;
	private String nome;
	private String parametro;

	public AbstractComando(String nome, IO io) {
		this.io = io;
		this.nome = nome;
	}

	public IO getIo() {
		return io;
	}


	public void setIO(IO io) {
		this.io = io;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParametro() {
		return this.parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	public abstract void esegui(Partita partita) throws ClassNotFoundException, IOException;

}
