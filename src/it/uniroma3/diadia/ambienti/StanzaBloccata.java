package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private Direzioni direzioneBloccata;
	private String attrezzoSbloccante;

	public StanzaBloccata(String nome, Direzioni direzioneBloccata, String attrezzoSbloccante) {
		super(nome);
		this.direzioneBloccata=direzioneBloccata;
		this.attrezzoSbloccante=attrezzoSbloccante;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzioni direzione) {
		if(direzione==null)
			return this;
		if(direzione.equals(this.direzioneBloccata)) {
			if(this.hasAttrezzo(this.attrezzoSbloccante)) {
				return super.getStanzaAdiacente(direzione);
			}else
				return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(this.attrezzoSbloccante))
			return this.toString();
		else
			return "la porta a " + this.direzioneBloccata + " è bloccata\n"
					+ "ti serve l' oggetto " + this.attrezzoSbloccante + " nella stanza per aprirla...";
	}
}
