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
	
	public void decreasePoints() {
		this.points -= 1;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getRolled() {
		return this.rolled_n;
	}
	
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
	
	public int getPoints() {
		return this.points;
	}
	
}
