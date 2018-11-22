
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;


/*
 * Name: Aurnob Jahin Islam
 * File: PlayGame.java 
 * Other files in this project:
 * Animal.java
 * Bird.java
 * Dog.java
 * Employee.java
 * Faculty.java
 * Fish.java
 * Frog.java
 * GameTeamMember.java
 * Robot.java
 * SaveToFile.java
 * Scoreable.java
 * Staff.java
 * Student.java
 * Swan.java
 * Tiger.java
 * Main class: Game.java
 * */

//this class is created to make the code efficient and not have repeated process in the main method
public class PlayGame {
	
	//the following three class variables of different types are useful when to store data to file
	int teamTotalScore;
	ArrayList<GameTeamMember> team;
	String winningAnimals = "";

	//this constructor is used to pass on values to its parameters when making the two teams play the game
	public PlayGame(ArrayList<GameTeamMember> team, int randomNumber, Random rand, ArrayList<Integer> value, 
			Animal animalHolder, Stack<Animal> animalStack, Queue<Animal> queue, int totalScore, int teamScore) {
		
		//this for loop is used to have the teams play two rounds of the game
		for(int round = 1; round<=2; round++) {
			System.out.println("This is round --> " + round);
			System.out.println();
			System.out.print("Animals in your stack: ");
			
			//the following for loop shows the animals in the team's stack prior to playing the round
			for(int i=0; i<animalStack.size(); i++) {
				System.out.print(animalStack.get(i).getClass().getName() + " ");
			}
			System.out.println();
			System.out.println();
			
			//the following for nested for loops provide random numbers for team members to pick
			for (int i = 0; i < team.size(); i++) {
				for(int j=0; j<1; j++) {
					randomNumber = rand.nextInt(10);
				}
				int score = value.get(randomNumber);
				
				/*the following conditions are written to meet the vital condition of the game
				 * to check if a player scores more or less than and equal to 50 */
				if (score > 50) {
					//players scoring more than 50 will be able to pop an animal from the animal stack
					team.get(i).play();
					animalHolder = (Animal) animalStack.pop(); //animalHolder stores the animal which has been popped
					queue.add(animalHolder); //the animal that's been popped gets enqueued to the team's queue
					/*the following conditions are written to justify which round
					 * the player is playing*/
					if(round==2) {
						int val = animalHolder.getScore();
						winningAnimals += animalHolder.getClass().getName() + " ";
						System.out.println(animalHolder.getClass().getName() + " is also playing.");
						
						totalScore = score + val; //in round 2, the animal score is also added to the player's score
						
						System.out.println(team.get(i).getClass().getName() + "'s random score is " + score + ". " + 
								team.get(i).getClass().getName() + " got the animal " + animalHolder.getClass().getName() + 
								" and " + animalHolder.getClass().getName() + "'s score is " + animalHolder.getScore() + ".");
						
						System.out.println(team.get(i).getClass().getName() + " & " + animalHolder.getClass().getName() + 
								"'s total score is " + totalScore);
					}
					else if(round==1) {
						totalScore = score; //in round 1, only the player's score is evaluated
						
						System.out.println(team.get(i).getClass().getName() + "'s total score is " + totalScore + ".");
					}					
					
					teamScore += totalScore; //to update the total team score
					
				} else {
					System.out.println("Sorry " + team.get(i).getClass().getName() +", your score is too low.");
					/*the following conditions are written to satisfy game requirement needs, 
					 * which is only applicable when the player score is less than or equal to 50*/ 
					if (queue.isEmpty() == false) {
						queue.remove(); //if queue isn't empty, then dequeue an animal from team's queue
						
						System.out.println("An animal has been taken out of your queue.");
					}
					else if(queue.isEmpty() == true) {
						System.out.println("Empty animal queue.");
					}
				}
				
			}
			
			System.out.println();
			System.out.print("Remaining animals in the stack: ");
			//the following for loop shows the remaining animals in the stack after the teams have performed two rounds
			for(int i=0; i<animalStack.size(); i++) {
				System.out.print(animalStack.get(i).getClass().getName() + " ");
			}
			
			System.out.println();
			//the try block only shows the first element of the queue to verify if animals have queued properly or not
			try {
				System.out.println("Team 1 animal queue (First element): " + queue.peek().getClass().getName());
			}
			catch (Exception e){
				System.out.println("Team 1 animal queue: no elements" );
			}
			System.out.println();
			
			System.out.println("Team Score in round " + round + ": " + teamScore);
			System.out.println();
			
			teamTotalScore += teamScore; //to add up the score from both rounds played by the teams
			
		}
		
		System.out.println("Team's total score after two rounds is: " + teamTotalScore);
		
	}

	//the following getters and setters are only helpful for storing information of the winning team into a file
	protected int getTeamTotalScore() {
		return teamTotalScore;
	}

	protected void setTeamTotalScore(int teamTotalScore) {
		this.teamTotalScore = teamTotalScore;
	}
	
	protected ArrayList<GameTeamMember> getTeam() {
		return team;
	}

	protected void setTeam(ArrayList<GameTeamMember> team) {
		this.team = team;
	}

	protected String getWinningAnimals() {
		return winningAnimals;
	}

	protected void setWinningAnimals(String winningAnimals) {
		this.winningAnimals = winningAnimals;
	}


}
