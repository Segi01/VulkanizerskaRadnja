package auto_radnja;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	Radnja radnja;
	AutoGuma ag1,ag2;
	
	public abstract Radnja getInstance();
	@BeforeEach
	void setUp() throws Exception {
		radnja = getInstance();
		ag1 = new AutoGuma("BMW",15,200,50);
		ag2 = new AutoGuma("BMW",16,200,50);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void dodajGumuTest() {
		 
		radnja.dodajGumu(ag1);
		List<AutoGuma> sve = radnja.vratiSveGume();
		assertEquals(1, sve.size());
		assertEquals(ag1, sve.get(0));
		
	}
	
	@Test
	void dodajGumuTestNotNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> radnja.dodajGumu(null) );
	}
	
	@Test
	void dodajGumuTestDuplikat() {
		radnja.dodajGumu(ag1);
		
		assertThrows(java.lang.RuntimeException.class,
				() -> radnja.dodajGumu(ag1));
	}
	
	@Test
	void dodajGumuTestViseKomada() {
		 
		radnja.dodajGumu(ag1);
		radnja.dodajGumu(ag2);
		List<AutoGuma> sve = radnja.vratiSveGume();
		assertEquals(2, sve.size());
		assertTrue(sve.contains(ag1));
		assertTrue(sve.contains(ag2));
		
		
	}
	
	@Test
	void pronadjiGumuNull() {
		radnja.dodajGumu(ag1);
		assertNull(radnja.pronadjiGumu(null));
	}
	
	@Test
	void pronadjiGumuPraznaLista() {
		radnja.dodajGumu(ag1);
		radnja.dodajGumu(ag2);
		List<AutoGuma> gume = radnja.pronadjiGumu("Audi");
		assertEquals(0, gume.size());
	}
	
	@Test
	void pronadjiGumuJedna() {
		radnja.dodajGumu(ag1);
		ag2.setMarkaModel("Audi");
		radnja.dodajGumu(ag2);
		List<AutoGuma> gume = radnja.pronadjiGumu("Audi");
		assertEquals(1, gume.size());
		assertEquals(ag2, gume.get(0));


	}
	
	@Test
	void pronadjiGumuVise() {
		radnja.dodajGumu(ag1);
		radnja.dodajGumu(ag2);
		List<AutoGuma> gume = radnja.pronadjiGumu("BMW");
		assertEquals(2, gume.size());
		assertTrue(gume.contains(ag1));
		assertTrue(gume.contains(ag2));



	}


}
