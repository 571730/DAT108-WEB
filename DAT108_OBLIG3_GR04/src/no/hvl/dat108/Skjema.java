package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;

public class Skjema {
	private String mobil;
	private String mobilFeil;
	private String fornavn;
	private String fornavnFeil;
	private String etternavn;
	private String etternavnFeil;
	private String passordEn;
	private String passordTo;
	private String passordFeil;
	private String passordFeilLikhet;
	private String kjonn;
	private String kjonnFeil;
	private Validator v;
	
	
	public Skjema(HttpServletRequest request) {
		this.mobil = request.getParameter("mobil");
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.passordEn = request.getParameter("passord");
		this.passordTo = request.getParameter("passordRepetert");
		this.kjonn = request.getParameter("kjonn");
		v = new Validator();
	}
	
	public Deltaker lagDeltaker() {
		PassordUtil hash = new PassordUtil();
		passordEn = hash.krypterPassord(passordEn);
		
		return new Deltaker(fornavn, etternavn, kjonn, mobil, passordEn);
	}
	
	public boolean isAllInputGyldig() {
		return v.isFornavnValid(fornavn) && v.isEtternavnGyldig(etternavn) && 
				v.isMobilGyldig(mobil) && v.isPassordGyldig(passordEn, passordTo)
				&& v.isKjonnGyldig(kjonn);
	}
	
	public void settOppFeilmeldinger() {
		
		if (!v.isFornavnValid(fornavn)) {
			fornavn = "";
			fornavnFeil = "Ugyldig navn!";
		}
		if (!v.isEtternavnGyldig(etternavn)) {
			etternavn = "";
			etternavnFeil = "Ugyldig etternavn!";
		}
		if (!v.isMobilGyldig(mobil)) {
			mobil = "";
			mobilFeil = "Ugyldig mobiltelefonnummer!";
		}
		if(!v.isKjonnGyldig(kjonn)) {
			kjonn = "";
			kjonnFeil = "Du må velge kjønn!";
		}
		if (!v.isPassordGyldig(passordEn, passordTo)) {
			passordFeil = "Ugyldig passord!";
		}
		gjemPassord();
		
	}
	
	public void gjemPassord() {
		passordEn = "";
		passordTo = "";
	}
		
	public String getMobil() {
		return mobil;
	}

	public String getMobilFeil() {
		return mobilFeil;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getFornavnFeil() {
		return fornavnFeil;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getEtternavnFeil() {
		return etternavnFeil;
	}

	public String getPassordEn() {
		return passordEn;
	}

	public String getPassordTo() {
		return passordTo;
	}

	public String getPassordFeil() {
		return passordFeil;
	}

	public String getPassordFeilLikhet() {
		return passordFeilLikhet;
	}

	public String getKjonn() {
		return kjonn;
	}

	public String getKjonnFeil() {
		return kjonnFeil;
	}
	
	public void setMobil(String feil) {
		mobil = feil;
	}
	
	
	
}
