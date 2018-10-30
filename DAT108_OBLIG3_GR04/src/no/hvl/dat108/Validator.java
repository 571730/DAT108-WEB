package no.hvl.dat108;

import javax.ejb.EJB;

public class Validator {
		
	public boolean isFornavnValid(String fornavn) {
		
		if(!fornavn.matches("^[A-ZÆØÅ][A-Za-z æøåÆØÅ-]{1,20}")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean isEtternavnGyldig(String etternavn) {
		if(!etternavn.matches("^[A-ZÆØÅ][A-Za-zæøåÆØÅ-]{1,20}")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean isMobilGyldig(String mobil) {
		if(mobil == null || mobil.isEmpty()) {
			return false;
		}
		else if (!mobil.matches("^[0-9]{8}")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean isKjonnGyldig(String kjonn) {
		return kjonn != null;
	}
	
	public boolean isPassordGyldig(String pass1, String pass2) {
		return pass1 != null && pass1.equals(pass2) && pass1.length() > 4;
	}
	

}
