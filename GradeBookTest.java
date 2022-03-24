import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	private GradeBook g1;
	private GradeBook g2;
	private GradeBook g3;

	@BeforeEach
	void setUp() throws Exception {
		
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g3 = new GradeBook(5);
		
		g1.addScore(75);
		g1.addScore(95);
		
		g2.addScore(80);
		g2.addScore(90);
		g2.addScore(100);
		
		g3.addScore(10);
		g3.addScore(50);
		g3.addScore(90);
		g3.addScore(140);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = g2 = g3 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("75.0 95.0 "));
		assertTrue(g2.toString().equals("80.0 90.0 100.0 "));
		assertTrue(g3.toString().equals("10.0 50.0 90.0 140.0 "));
		
		
		assertEquals(2, g1.getScoreSize());
		assertEquals(3, g2.getScoreSize());
		assertEquals(4, g3.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(170, g1.sum());
		assertEquals(270, g2.sum());
		assertEquals(290, g3.sum());
	}
	
	@Test
	void testMinimum() {
		
		assertEquals(75, g1.minimum());
		assertEquals(80, g2.minimum());
		assertEquals(10, g3.minimum());
	}

	@Test
	void testFinalScore() {
		
		assertEquals(95, g1.finalScore());
		assertEquals(190, g2.finalScore());
		assertEquals(280, g3.finalScore());
		
	}

}
