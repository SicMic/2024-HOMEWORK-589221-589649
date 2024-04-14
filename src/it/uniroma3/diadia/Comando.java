package it.uniroma3.diadia;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public class Comando {

    private String nome;
    private String parametro;

    public Comando(String istruzione) {
    	
    	String comando[] = istruzione.split(" ");
    	
    	if(comando[0] != "")
    		this.nome = comando[0];
    	
    	if(comando.length == 2)
    		this.parametro = comando[1];
    	
    }

    public String getNome() {
        return this.nome;
    }

    public String getParametro() {
        return this.parametro;
    }

    public boolean sconosciuto() {
        return (this.nome == null);
    }
}