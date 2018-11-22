import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/*
 * Name: Aurnob Jahin Islam
 * Assignment: Assignment 2
 * Program: Information System Security
 * Description:
 * */

public class Game implements Serializable{
	
	private static final long serialVersionUID = 1L; //default serial for serializable object
	
	public static void main(String[] args) throws Exception {
		
		//creating objects of game team members
		Student student = new Student();
		Employee employee = new Employee();
		Robot robot = new Robot();
		Staff staff = new Staff();
		Faculty faculty = new Faculty();
		
		//creating team 1 consisting game team members as players 
		ArrayList<GameTeamMember> team1 = new ArrayList<GameTeamMember>(5);
		team1.add(student);
		team1.add(employee);
		team1.add(robot);
		team1.add(staff);
		team1.add(faculty);
		
		//creating team 2 consisting game team members as players 
		ArrayList<GameTeamMember> team2 = new ArrayList<GameTeamMember>(5);
		team2.add(student);
		team2.add(employee);
		team2.add(robot);
		team2.add(staff);
		team2.add(faculty);
		
		//animal queue 1 that is used by team 1 and is set to have no values as default
		Queue<Animal> queue1 = new LinkedList<Animal>();
		
		//animal queue 2 that is used by team 2 and is set to have no values as default
		Queue<Animal> queue2 = new LinkedList<Animal>();
		
		//stack of animals for team 1 and adding animal objects using reference
		Stack<Animal> animalStack1 = new Stack<Animal>();
		
		animalStack1.push(new Dog());
		animalStack1.push(new Fish());
		animalStack1.push(new Frog());
		animalStack1.push(new Bird());
		animalStack1.push(new Swan());
		animalStack1.push(new Tiger());
		animalStack1.push(new Dog());
		animalStack1.push(new Fish());
		animalStack1.push(new Bird());
		animalStack1.push(new Frog());
		
		//stack of animals for team 2 and adding animal objects using reference
		Stack<Animal> animalStack2 = new Stack<Animal>();
		
		animalStack2.push(new Dog());
		animalStack2.push(new Fish());
		animalStack2.push(new Frog());
		animalStack2.push(new Bird());
		animalStack2.push(new Swan());
		animalStack2.push(new Tiger());
		animalStack2.push(new Dog());
		animalStack2.push(new Fish());
		animalStack2.push(new Bird());
		animalStack2.push(new Frog());
		
		Random rand = new Random();
		int randomNumber = 0;
		
		//an array list that contains random numbers generated using the following for loop
		//to have values from 0 to 90 with +10 as interval between each values
		ArrayList<Integer> value = new ArrayList<Integer>();

		for(int i = 0; i<10; i++) {
			value.add(i*10);
		}
				
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to a game of fun. In this game, you will have 2 teams, consisting of 5 players for each team. ");
		System.out.println("Every team gets its own Animal Stack containing 10 animals. Each team will get to play two rounds. ");
		System.out.println("After the final rounds, the scores of each team will be compared to decide the final winner. ");
		System.out.println("Type any key and ENTER to start the game!!!");
		scan.hasNext();
		scan.close();
		System.out.println();
		
		//an animal holder that holds the animal that is going to be pooped from the animal stack
		Animal animalHolder = new Animal();
		int totalScore = 0;
		int teamScore = 0;
		
		System.out.println("Team 1 is playing: ");
		System.out.println();
		//object team1Play is a type PlayGame object that uses its constructor to run the logic of the game
		PlayGame team1Play = new PlayGame(team1, randomNumber, rand, value, animalHolder, animalStack1, queue1, totalScore, teamScore);
		System.out.println("\n");
		System.out.println("### ### ### ###");
		System.out.println("\n");
		System.out.println("Team 2 is playing: ");
		System.out.println();
		//object team2Play is a type PlayGame object that uses its constructor to run the logic of the game
		PlayGame team2Play = new PlayGame(team2, randomNumber, rand, value, animalHolder, animalStack2, queue2, totalScore, teamScore);
		System.out.println("\n");
		System.out.println("### ### ### ###");
		System.out.println();
			
		System.out.println("\nGame Finished. Time to Compare Scores --->");
		
		System.out.println("Team 1: " + team1Play.teamTotalScore);
		System.out.println("Team 2: " + team2Play.teamTotalScore);
		
		ArrayList<GameTeamMember> winningTeam = new ArrayList<GameTeamMember>();//this array list contains the members of the winning team
		String winningAnimalsString = "";//this string is useful to show the animals from the winning team
		int winningTeamScore = 0;
		String name = null; 
		
		/*following conditions are to test which team won the game after two rounds
		 * also these conditions are useful to provide the winning team members and animals in order to store 
		 * in file*/
		if(team1Play.teamTotalScore > team2Play.teamTotalScore) {
			System.out.println("Team 1 won the game with " + (team1Play.teamTotalScore-team2Play.teamTotalScore) + " points in hand.");
			winningTeam = team1;
			name = "Team 1";
			winningAnimalsString = team1Play.winningAnimals;
			winningTeamScore = team1Play.teamTotalScore;
		}
		else if(team2Play.teamTotalScore > team1Play.teamTotalScore) {
			System.out.println("Team 2 won the game with " + (team2Play.teamTotalScore-team1Play.teamTotalScore) + " points in hand.");
			winningTeam = team2;
			name = "Team 2";
			winningAnimalsString = team2Play.winningAnimals;
			winningTeamScore = team2Play.teamTotalScore;
		}
		else if(team1Play.teamTotalScore == team2Play.teamTotalScore) {
			System.out.println("Both teams drew the game.");
		}
		
		System.out.println("Thank you for playing...");
		System.out.println("\n");
		
		/*sf is an object of type SaveToFile. The purpose is to use the logic of 
		 * SaveToFile class to store information about the winning team*/
		try {
			SaveToFile sf = new SaveToFile(winningTeamScore, winningTeam, winningAnimalsString);

			// writing object to file
			FileOutputStream fos = new FileOutputStream("c:\\temp\\aurnob's winners.txt"); //location to store the file
			ObjectOutputStream oos = new ObjectOutputStream(fos); 
			oos.writeObject(sf);
			System.out.println("Object has been written succesfully....");
			oos.close();
			System.out.println("\n");

			// reading object from file
			FileInputStream fis = new FileInputStream("c:\\temp\\aurnob's winners.txt"); //location to read file from
			ObjectInputStream ois = new ObjectInputStream(fis);
			SaveToFile result = (SaveToFile) ois.readObject();
			ois.close();

			/*the following code is verify if the files have been written 
			 * the way they were meant to be written*/
			System.out.println("Verifying writing to file by reading it....");
			String strTeam = "";
			for(int i = 0; i<winningTeam.size(); i++) {
				strTeam += result.winningTeam.get(i).getClass().getName() + " ";
			}
			System.out.println("The players in the team are: " + strTeam);
			System.out.println();
			System.out.println("The animals which played for winning team are: " + result.winningAnimals);
			System.out.println("Winning Team is " + name +" & their score is " + result.getWinningTeamScore());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
