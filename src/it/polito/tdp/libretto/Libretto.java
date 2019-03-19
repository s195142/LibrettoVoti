package it.polito.tdp.libretto;

import java.util.*;

public class Libretto {
	
	private List<Voto> voti;

	public Libretto() {
		super();
		this.voti = new ArrayList<Voto>();
	}
	
	public void add(Voto v) {
		voti.add(v);
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

}
