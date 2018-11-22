/*
 * Name: Aurnob Jahin Islam
 * File: Dog.java
 * Other files in this project:
 * Animal.java
 * Bird.java
 * Employee.java
 * Faculty.java
 * Fish.java
 * Frog.java
 * GameTeamMember.java
 * PlayGame.java
 * Robot.java
 * SaveToFile.java
 * Scoreable.java
 * Staff.java
 * Student.java
 * Swan.java
 * Tiger.java
 * Main class: Game.java
 * */
public class Dog extends Animal{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name = "Dog";
	
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 50;
	}
	
}
