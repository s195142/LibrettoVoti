package it.polito.tdp.libretto;

import java.util.*;

public class Libretto {
	
	private List<Voto> voti;

	public Libretto() {
		super();
		this.voti = new ArrayList<Voto>();
	}
	
	/**
	 * Aggiunge nuvo voto a libretto
	 * 
	 * @param v il {@link Voto} da aggiungere
	 * @return {@code true} nel caso normale, {@code false} se non riesce ad aggiungwre il voto
	 */
	public boolean add(Voto v) {
		if(!this.esisteGiaVoto(v) && !this.votoConflitto(v)) {
		voti.add(v);
		return true;
		}
		else {
			return false;
		}
			
	}
	
//	public void StampaVoti(int voto) {}
//	
//	public String StampaVoti2(int voto) {}
//	meglio il 3° metodo:
	public List<Voto> cercaVoti(int punti) {
		List<Voto> result = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			if(v.getVoto()==punti)
				result.add(v);
		}
		return result;
	}
	
	
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui è specificato il nome
	 * 
	 * @param nomeEsame nome del corso da ricercare
	 * @return 
	 */
	public Voto cercaEsame(String nomeEsame) {
		Voto voto = new Voto(0, nomeEsame, null);
		int pos = this.voti.indexOf(voto);
		if(pos==-1)
			return null;
		else
			return this.voti.get(pos); // non uso più for each
	}
	
	/**
	 * Dato un Voto, determina se esiste già un voto con uguale corso e punteggio.
	 * 
	 * @param nomeEsame del corso da ricercare
	 * @return {@code true} se trova corso e punteggio uguali,
	 * {@code false} se non trova il corso o lo trova con voto diverso
 	 */
	public boolean esisteGiaVoto(Voto v) {
		
		int pos = this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else 
			return v.getVoto()==this.voti.get(pos).getVoto();
		
//		Voto trovato = this.cercaEsame(v.getCorso());
//		if(trovato==null)
//			return false;
//		if(trovato.getVoto()==v.getVoto())
//			return true;
//		else
//			return false; 
	}
	
	/**
	 * Mi dice se {@link Voto} {@code v} è in conflitto con uno dei voti esistenti. se il voto non esiste, non c'è conflitto, se esiste e ha punteggio diverso si.
	 * 
	 * @param v
	 * @return {@code true} se voto esiste con punteggio diverso
	 * {@code false} se non esiste
 	 */
	public boolean votoConflitto(Voto v) {
		
		int pos = this.voti.indexOf(v);
		if(pos==-1)
			return false;
		else 
			return v.getVoto()!=this.voti.get(pos).getVoto();
	}
	
	public String toString() {
		return this.voti.toString();
	}
	
	public Libretto librettoMigliorato() {
		Libretto nuovo = new Libretto();
		for(Voto v : this.voti) {
			nuovo.add(v.clone());
		}
		for(Voto v : nuovo.voti) {
			int punti = v.getVoto();
			if(punti<24)
				punti = punti +1;
			else if(punti<=28)
				punti = punti +2;
			v.setVoto(punti);
		}
		return nuovo;
	}

}
