package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma ag;
	
	@BeforeEach
	void setUp() throws Exception {
		ag=new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag=null;;
	}

	@Test
	void testAutoGuma() {
		
		assertNotNull(ag);
		
		assertEquals(null, ag.getMarkaModel());
		assertEquals(-1, ag.getPrecnik());
		assertEquals(-1, ag.getSirina());
		assertEquals(-1, ag.getVisina());

	}

	@Test
	void testAutoGumaStringIntIntInt() {
		
		
		assertNotNull(ag);
		
		ag=new AutoGuma("BMW", 15, 150, 30);
		assertEquals("BMW", ag.getMarkaModel());
		assertEquals(15, ag.getPrecnik());

		assertEquals(30, ag.getVisina());

		assertEquals(150, ag.getSirina());

	}

	@Test
	void testSetMarkaModel() {
		
		ag.setMarkaModel("BMW");
		
		assertEquals("BMW", ag.getMarkaModel());
		
		
	}
	
	@Test
	void testSetMarkaModelNotNull() {
		
		assertThrows(java.lang.NullPointerException.class,
				() ->ag.setMarkaModel(null));
		
		
	}
	@Test
	void testSetMarkaModelNotEmpty() {
		
		assertThrows(java.lang.IllegalArgumentException.class,
				() ->ag.setMarkaModel("bw"));
		
	}

	@Test
	void testSetPrecnik() {
		
		ag.setPrecnik(16);
		
		assertEquals(16, ag.getPrecnik());
		
	
	}
	
	@Test
	void testSetPrecnik1() {
		
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setPrecnik(10));
	}
	
	@Test
	void testSetPrecnik2() {
		
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setPrecnik(30));
	}

	@Test
	void testSetSirina() {
		
		ag.setSirina(200);
		
		assertEquals(200, ag.getSirina());
	}
	
	@Test
	void testSetSirina1() {
		
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setSirina(100));

	}
	
	@Test
	void testSetSirina2() {
		
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setSirina(400));

	}

	@Test
	void testSetVisina() {
		
		ag.setVisina(50);
		
		assertEquals(50, ag.getVisina());
	}
	
	@Test
	void testSetVisina1() {
		
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setVisina(20));

	}
	
	@Test
	void testSetVisina2() {
		
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setVisina(200));

	}

	@Test
	void testToString() {
		
		
		ag.setMarkaModel("BBMW");
		ag.setPrecnik(15);
		ag.setVisina(50);
		ag.setSirina(200);
		
		
		String string=ag.toString();
		
		assertTrue(string.contains("BMW"));
		assertTrue(string.contains("15"));
		assertTrue(string.contains("50"));
		assertTrue(string.contains("200"));

	}

	@Test
	void testEqualsObject() {
		
		
		AutoGuma b=ag;
		
		assertTrue(ag.equals(b));
	}
	
	@Test
	void testEqualsObjectNotNull() {
		
		
		assertFalse(ag.equals(null));
	}
	
	@Test
	void testEqualsObjectDrugaKlasa() {
		
		
		assertFalse(ag.equals(new Object()));
	}
	
	@ParameterizedTest
	@CsvSource({
		
		"BMW,15,200,50,AUDI,15,200,50,false",
		"BMW,15,200,50,BMW,16,200,50,false",
		"BMW,15,200,50,BMW,15,201,50,false",
		"BMW,15,200,50,BMW,15,200,51,false",
		
		
		"BMW,15,200,50,AUDI,16,200,50,false",
		"BMW,15,200,50,AUDI,15,201,50,false",
		"BMW,15,200,50,AUDI,15,200,51,false",
		"BMW,15,200,50,BMW,16,201,50,false",
		"BMW,15,200,50,BMW,16,200,51,false",
		"BMW,15,200,50,BMW,15,201,51,false",
		
		
		
		"BMW,15,200,50,AUDI,16,201,50,false",
		"BMW,15,200,50,AUDI,16,200,51,false",
		"BMW,15,200,50,AUDI,15,201,51,false",
		"BMW,15,200,50,BMW,16,201,51,false",
		
		
		"BMW,15,200,50,AUDI,16,201,51,false",
		"BMW,15,200,50,BMW,15,200,50,true",



		
	})
	
	void testEquaksObjectSveOk(String marka1,int precnik1,int sirina1,int visina1,
			String marka2,int precnik2,int sirina2,int visina2,boolean equals) {
		
		ag.setMarkaModel(marka1);
		ag.setPrecnik(precnik1);
		ag.setSirina(sirina1);
		ag.setVisina(visina1);
		
		AutoGuma aautoGuma=new AutoGuma(marka2, precnik2, sirina2, visina2);
		
		assertEquals(equals, aautoGuma.equals(ag));
	}


}
