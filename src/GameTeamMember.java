import java.io.Serializable;

/*
 * Name: Aurnob Jahin Islam
 * File: GameTeamMember.java 
 * Other files in this project:
 * Animal.java
 * Bird.java
 * Dog.java
 * Employee.java
 * Faculty.java
 * Fish.java
 * Frog.java
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

public abstract class GameTeamMember implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String name;
	protected int age;
	public String gender;
	public abstract void play();
}
