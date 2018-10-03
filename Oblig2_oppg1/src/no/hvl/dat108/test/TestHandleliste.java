package no.hvl.dat108.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat108.HandlelisteObjekt;

public class TestHandleliste {
	HandlelisteObjekt liste;
	String item1 = "Brus";
	String item2 = "Banan";
	String item3 = "Pizza";

	@Before
	public final void setup() throws Exception {
		liste = new HandlelisteObjekt();
	}
	
	/**
	 * Sjekker at size er lik 1 naar ett element er lagt til
	 */
	@Test
	public final void leggTilEn() {
		liste.leggTil(item1);
		assertEquals(liste.getHandlelisteObjekt().size(), 1);
	}
	
	/**
	 * Sjekker at size er 0 naar en legger til en og tar samme item
	 */
	@Test
	public final void leggTilOgTaVekk() {
		liste.leggTil(item1);
		liste.fjernItem(item1);
		assertEquals(liste.getHandlelisteObjekt().size(), 0);
	}
	
	
}
