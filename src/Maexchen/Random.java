package Maexchen;

public class Random {

/**
 * @return a random number between 1-6
 */
public static int getRandomNumber() {
	return (int) Math.floor(Math.random() * 6) + 1;
	
	}
}
