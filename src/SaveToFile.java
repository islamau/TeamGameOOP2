import java.io.Serializable;
import java.util.ArrayList;

/*
 * Name: Aurnob Jahin Islam
 * File: SaveToFile.java
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
 * Robot.java
 * Scoreable.java
 * Staff.java
 * Student.java
 * Swan.java
 * Tiger.java
 * Main class: Game.java
 * */

//this class is created to save winning team's information into file
public class SaveToFile implements Serializable {

	private static final long serialVersionUID = 1L; //default serial for serializable object
	//following three global variable useful for saving file
	int winningTeamScore;
	ArrayList<GameTeamMember> winningTeam;
	String winningAnimals;

	public SaveToFile() {
		
	}
	
	public SaveToFile(int winningTeamScore, ArrayList<GameTeamMember> winningTeam, String winningAnimals) {
		this.winningTeamScore = winningTeamScore;
		this.winningTeam = winningTeam;
		this.winningAnimals = winningAnimals;
	}

	protected int getWinningTeamScore() {
		return winningTeamScore;
	}

	protected void setWinningTeamScore(int winningTeamScore) {
		this.winningTeamScore = winningTeamScore;
	}

	protected ArrayList<GameTeamMember> getWinningTeam() {
		return winningTeam;
	}

	protected void setWinningTeam(ArrayList<GameTeamMember> winningTeam) {
		this.winningTeam = winningTeam;
	}

	protected String getWinningAnimals() {
		return winningAnimals;
	}

	protected void setWinningAnimals(String winningAnimals) {
		this.winningAnimals = winningAnimals;
	}

	

}
