package Maexchen;


public class Player {
	public String name;
	public int age;
	public int points;
	public int rolled_n;
	public int called_n;
	
	public Player(String pName, int pAge) {
		this.name = pName;
		this.age = pAge;
		this.points = 0;
	}
	
	/**
	 * reduces the score of the player
	 */
	public void decreasePoints() {
		this.points -= 1;
	}
	
	/**
	 * @return the age of the player
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * @return the name of the player
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return the dice number
	 */
	public int getRolled() {
		return this.rolled_n;
	}
	
	/**
	 * @return what the player called he diced
	 */
	public int getCalled() {
		return this.called_n;
	}
	
	public void setRolled(int rolled) {
		this.rolled_n = rolled;
	}
	
	public void setCalled(int called) {
		this.called_n = called;
	}
	
	public void decreasepoints(){
		this.points -= 1;
	}
	
	
	/**
	 * @return points of the player
	 */
	public int getPoints() {
		return this.points;
	}
	
}
