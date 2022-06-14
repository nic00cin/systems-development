package Maexchen;

public class Player {
	public String name;
	public int age;
	public int points;
	
	public Player(String pName, int pAge) {
		this.name = pName;
		this.age = pAge;
		this.points = 10;
	}
	
	public void decreasePoints() {
		this.points -= 1;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}
	
}
