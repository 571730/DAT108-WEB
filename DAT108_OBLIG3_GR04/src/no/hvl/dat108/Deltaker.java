package no.hvl.dat108;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="oblig3", name="deltaker")
public class Deltaker implements Comparable<Deltaker>{
	@Id
	private String mobil;
	
	private String fornavn;
	private String etternavn;
	private String kjonn;
	private String passord;
	
	
	public Deltaker (String fornavn, String etternavn, String kjonn, String mobil, String passord) {
		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		this.passord = passord;
	}
	
	public Deltaker() {
		
	}
	
	@Override
	public String toString() {
		return fornavn + " " + etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	@Override
	public int compareTo(Deltaker d2) {
		return (fornavn.compareTo(d2.fornavn) != 0) ? fornavn.compareTo(d2.fornavn) : etternavn.compareTo(d2.etternavn);
		
	}
	
	
	
	
}
