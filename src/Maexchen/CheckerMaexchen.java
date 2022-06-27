package Maexchen;

import java.lang.reflect.Array;

public class CheckerMaexchen {
	public static int Values[] = new int[21];
	public static int index;
	public static boolean isIn;
	
	public CheckerMaexchen() {
		Values[0] = 31;
		Values[1] = 32;
		Values[2] = 41;
		Values[3] = 42;
		Values[4] = 43;
		Values[5] = 51;
		Values[6] = 52;
		Values[7] = 53;
		Values[8] = 54;
		Values[9] = 61;
		Values[10] = 62;
		Values[11] = 63;
		Values[12] = 64;
		Values[13] = 65;
		Values[14] = 11;
		Values[15] = 22;
		Values[16] = 33;
		Values[17] = 44;
		Values[18] = 55;
		Values[19] = 66;
		Values[20] = 21;
	}
	
	/**
	 * checks what the player called is the same as what the player rolled
	 * @return true or false
	 */
	public static boolean check() {
		if(PlayerInfoUI.Players[PlayerInfoUI.player_order].getCalled() == PlayerInfoUI.Players[PlayerInfoUI.player_order].getRolled()) {
			return true;
		} else{
			return false;
		}
	}
	
	/**
	 * pairs the diced number with one of the values above
	 * @param number
	 * @return the value of the diced number
	 */
	public static int getValueIndex(int number) {
		for(int i = 0; i<21; i++) {
			if(number == Values[i]) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * checks if the players number is higher than the number of the player before
	 * @param number
	 * @return 
	 */
	public static boolean checkhigher(int number) {
		if(getValueIndex(number) > getValueIndex(PlayerInfoUI.highest_number)) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	public static boolean NumberisIn(int number) {
		isIn = false;
		for(int i = 0; i<21; i++) {
			if(number == Values[i]) {
				isIn = true;
			}
		}
		return isIn;
	}
	
}
