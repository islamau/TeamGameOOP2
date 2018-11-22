/*
 * Name: Aurnob Jahin Islam
 * File: Employee.java
 * Other files in this project:
 * Animal.java
 * Bird.java
 * Dog.java
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
public class Employee extends GameTeamMember{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String name;
	protected int age;
	public String gender;
	
	public Employee() {
		
	}
	
	@Override
	public void play() {
		System.out.println("An employee is playing.");
		
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
