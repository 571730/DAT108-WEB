package no.hvl.dat108.tester;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import no.hvl.dat108.Validator;

public class ValidatorTest {
	private Validator v;

	@Before
	public final void setup() throws Exception {
		v = new Validator();
	}
	
	@Test
	public final void testFornavn() {
		assertTrue(v.isFornavnValid("Magnus-Olav"));
		assertFalse(v.isFornavnValid("hansen"));
		assertFalse(v.isFornavnValid("A"));
	}
	
	@Test
	public final void testEtternavn() {
		assertTrue(v.isEtternavnGyldig("Hansen"));
		assertTrue(v.isEtternavnGyldig("Hansen-Hansen"));
		assertFalse(v.isEtternavnGyldig("liten"));
		assertFalse(v.isEtternavnGyldig("B"));
	}
	
	@Test
	public final void testMobil() {
		assertTrue(v.isMobilGyldig("91939495"));
		assertTrue(v.isMobilGyldig("00939495"));
		assertFalse(v.isMobilGyldig("9193949"));
		assertFalse(v.isMobilGyldig("9193949A"));
		assertFalse(v.isMobilGyldig("9193949938"));
	}
	
	@Test
	public final void testKjonn() {
		assertTrue(v.isKjonnGyldig("mann"));
		assertFalse(v.isKjonnGyldig(null));
	}
	
	@Test
	public final void testPassord() {
		assertTrue(v.isPassordGyldig("passord", "passord"));
		assertFalse(v.isPassordGyldig("passord", "passord1"));
		assertFalse(v.isPassordGyldig("pas", "pas"));
	}

}
