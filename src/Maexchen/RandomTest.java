package Maexchen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomTest {

	@Test
	void testGetRandomNumber() {
		Random random = new Random();
		int test = random.getRandomNumber();
		
		assertEquals(test > 0 && test < 7, true);
	}

}
