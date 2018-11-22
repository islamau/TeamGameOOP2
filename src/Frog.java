/*
 * Name: Aurnob Jahin Islam
 * File: Frog.java
 * Other files in this project:
 * Animal.java
 * Bird.java
 * Dog.java
 * Employee.java
 * Faculty.java
 * Fish.java
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
public class Frog extends Animal{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name = "Frog";
	
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 30;
	}

}
