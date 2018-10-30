package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;

public class LoggInnSkjema {
	private String mobil;
	private String passord;
	private String feilInnlogging;
	
	
	public LoggInnSkjema(HttpServletRequest request) {
		this.mobil = request.getParameter("mobil");
		this.passord = request.getParameter("passord");
	}
	
	public void feilMelding() {
		mobil = "";
		passord = "";
		feilInnlogging = "Feil mobilnummer eller passord!";
	}
	
	public boolean sjekkInnlogging(DeltakerEAO dEAO) {
		if(!mobil.isEmpty() && dEAO.finnesMobilnummer(mobil)) {
			PassordUtil hash = new PassordUtil();
			return hash.sjekkPassord(passord, dEAO.hentPassord(mobil));
		} else {
			return false;
		}
	}

	public String getMobil() {
		return mobil;
	}

	public String getPassord() {
		return passord;
	}

	public String getFeilInnlogging() {
		return feilInnlogging;
	}
}
