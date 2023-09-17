/*
Tanmay Bothra
Bunco (Assignment 3)
April 6 2022
Written/online sources used: none
Help obtained: none
I confirm that the above list of sources is complete AND that I/we have not talked to anyone else (e.g., CSC 207 students) 
about the solution to this problem."
 */
import java.util.Scanner;
import java.util.ArrayList;

public class BuncoTester {
	static BuncoGame game = new BuncoGame();
	static ArrayList<Integer> placeholder = new ArrayList<Integer>();
	static String yesOrNo;
	static int numGames = 0;
	static int playerWins = 0;
	static int compWins = 0;
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your name? Enter \"decline to specify\" if you do not want to disclose it.");
		String name = sc.nextLine();
		if(!(name.equalsIgnoreCase("decline to specify"))){
		game.getPlayer().setName(name);
	}
		do {
			Scanner s = new Scanner(System.in);
			game.setcomputerPoints(0);
			game.sethumanPoints(0);
	System.out.println("Welcome " + game.getPlayer().getName() + "! The game will now commence. Each player will roll the dice, and the one with the higher running total will start Round 1.");
	System.out.println("In the event of a tie, " + game.getPlayer().getName() + " will begin Round 1.");
	System.out.println("Hit the \"Enter\" key to roll.");
	s.nextLine();
	ArrayList<Integer> preRound1 = game.getDiceBox().roll();
	int runningTotal = preRound1.get(0) + preRound1.get(1) + preRound1.get(2);
    System.out.println(game.getPlayer().getName() + " rolled a " + preRound1 + ", which gives " + game.getPlayer().getName() + " a running total of " + runningTotal + ".");
    ArrayList<Integer> computerPreRound1 = game.getDiceBox().roll();
    int computerRunningTotal = computerPreRound1.get(0) + computerPreRound1.get(1) + computerPreRound1.get(2);
    System.out.println("The computer rolled a " + computerPreRound1 + ", which gives it running total of " + computerRunningTotal + ".");
if(runningTotal >= computerRunningTotal) {
	System.out.println("This means that " + game.getPlayer().getName() + " will begin Round 1");
for(int i = 1; i < 7; i++) {
	System.out.println("Round " + i + " commences!");
	game.playRound(game.getPlayer(), i);
	game.playRound(game.getComputer(), i);
	System.out.println("Round " + i + " has ended. " + game.getPlayer().getName() + " gained " + game.gethrp() + " points in this round, while the computer gained " + game.getcrp() + ".");
	if(game.gethrp() > game.getcrp()) {
		System.out.println(game.getPlayer().getName() + " has won this round.");
	}
	if(game.gethrp() < game.getcrp()) {
		System.out.println("The computer has won this round.");
	}
	else if (game.gethrp() == game.getcrp()) {
		System.out.println("This round has ended in a tie.");
	}
}//for rounds 1 - 7

}//if person's pre-round roll > computer's

if(computerRunningTotal > runningTotal) {
	System.out.println("This means that the computer will begin Round 1");
	for(int i = 1; i < 7; i++) {
		System.out.println("Round " + i + " commences!");
		game.playRound(game.getComputer(), i);
		game.playRound(game.getPlayer(), i);
		System.out.println("Round " + i + " has ended. " + game.getPlayer().getName() + " gained " + game.gethrp() + " points in this round, while the computer gained " + game.getcrp() + ".");
		if(game.gethrp() > game.getcrp()) {
			System.out.println(game.getPlayer().getName() + " has won this round.");
		}
		if(game.gethrp() < game.getcrp()) {
			System.out.println("The computer has won this round.");
		}
		else if (game.gethrp() == game.getcrp()) {
			System.out.println("This round has ended in a tie.");
		}
	    }// 1 - 7
	
}//If computer's total > human's
numGames++;
System.out.println(game.getPlayer().getName() + " got " + game.gethumanPoints() + " points in this game, while the computer got " + game.getcomputerPoints() + " points.");
if(game.gethumanPoints() > game.getcomputerPoints()) {
	System.out.println("congratulations, " + game.getPlayer().getName() + " has won this game!");
	playerWins++;
}
if(game.gethumanPoints() < game.getcomputerPoints()) {
	System.out.println("Unfortuntely, the computer has won this game.");
	compWins++;
}
else if (game.gethumanPoints() == game.getcomputerPoints()) {
	System.out.println("This game has ended in a tie.");
}
System.out.println("So far, " + numGames + " games have been played. " + game.getPlayer().getName() + " has won " + playerWins + ", while the computer has won " + compWins);
System.out.println("Does " + game.getPlayer().getName() + " want to play again? Enter \"yes\" or \"no\"");
yesOrNo = sc.next();
	} while(yesOrNo.equalsIgnoreCase("yes"));
	}// main
}// class
