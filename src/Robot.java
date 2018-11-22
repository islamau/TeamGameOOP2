/*
 * Name: Aurnob Jahin Islam
 * File: Robot.java
 * Other files in this project:
 * Animal.java
 * Bird.java
 * Dog.java
 * Employee.java
 * Faculty.java
 * Fish.java
 * Frog.java
 * GameTeamMember.java
 * PlayGame.java 
 * SaveToFile.java
 * Scoreable.java
 * Staff.java
 * Student.java
 * Swan.java
 * Tiger.java
 * Main class: Game.java
 * */

public class Robot extends GameTeamMember {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String name;
	protected int age;
	public String gender;
	
	public Robot() {
		
	}
	
	@Override
	public void play() {
		System.out.println("A robot is playing.");
		
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected int getAge() {
		return age;
	}

	protected void setAge(int age) {
		this.age = age;
	}

	protected String getGender() {
		return gender;
	}

	protected void setGender(String gender) {
		this.gender = gender;
	}
	
	

}
