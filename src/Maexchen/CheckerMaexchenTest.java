package Maexchen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckerMaexchenTest {

	@Test
	void CheckerMaexchen_Test() {
		CheckerMaexchen checker = new CheckerMaexchen();
		assertEquals(checker.Values[0] == 31, true);
		assertEquals(checker.Values[1] == 32, true);
		assertEquals(checker.Values[2] == 41, true);
		assertEquals(checker.Values[3] == 42, true);
		assertEquals(checker.Values[4] == 43, true);
		assertEquals(checker.Values[5] == 51, true);
		assertEquals(checker.Values[6] == 52, true);
		assertEquals(checker.Values[7] == 53, true);
		assertEquals(checker.Values[8] == 54, true);
		assertEquals(checker.Values[9] == 61, true);
		assertEquals(checker.Values[10] == 62, true);
		assertEquals(checker.Values[11] == 63, true);
		assertEquals(checker.Values[12] == 64, true);
		assertEquals(checker.Values[13] == 65, true);
		assertEquals(checker.Values[14] == 11, true);
		assertEquals(checker.Values[15] == 22, true);
		assertEquals(checker.Values[16] == 33, true);
		assertEquals(checker.Values[17] == 44, true);
		assertEquals(checker.Values[18] == 55, true);
		assertEquals(checker.Values[19] == 66, true);
		assertEquals(checker.Values[20] == 66, false);
		}
	
	@Test
	void CheckerMaexchen_getValueIndexTest() {
		CheckerMaexchen checker = new CheckerMaexchen();
		assertEquals(checker.getValueIndex(21) == 20, true);
		}
	
	@Test
	void checkhigherTest() {
		CheckerMaexchen checker = new CheckerMaexchen();
		PlayerInfoUI playerInfo = new PlayerInfoUI();
		playerInfo.highest_number = 33;
		assertEquals(checker.checkhigher(44) == true, true);
		assertEquals(checker.checkhigher(22) == false, true);
	}
	
	@Test
	void numberIsInTest() {
		CheckerMaexchen checker = new CheckerMaexchen();
		assertEquals(checker.NumberisIn(22) == true, true);
	}
}
