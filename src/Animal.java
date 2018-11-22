import java.io.Serializable;

/*
 * Name: Aurnob Jahin Islam
 * File: Animal.java
 * Other files in this project:
 * Bird.java
 * Dog.java
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

public class Animal implements Scoreable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;

	public Animal() {
		
	}
	
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}


}
