import java.util.ArrayList;
import java.util.Scanner;

/**
 * A Class for stimulating a game of Bunco that comprises as fields the important elements of the game, including the 
 * human player, the computer opponent, the dice cup, the number of points scored by each player in a round, and the
 * number of points scored by each player in a game.
 * @author Tanmay Bothra
 *
 */
public class BuncoGame {
private static Player player = new Player(); 
private static Player computer = new Player();
private static DiceBox cup = new DiceBox();
private static int hrp = 0;
private static int crp = 0;
private static int humanPoints = 0;
private static int computerPoints = 0;


public static Player getPlayer() {
	return player;
}

public static Player getComputer() {
	return computer;
}

public static DiceBox getDiceBox() {
	return cup;
}

public static int gethrp() {
	return hrp;
}

public static int getcrp() {
	return crp;
}

public static int gethumanPoints() {
	return humanPoints;
}

public static int getcomputerPoints() {
	return computerPoints;
}

public static void sethumanPoints(int n) {
	humanPoints = n;
}

public static void setcomputerPoints(int n) {
	computerPoints = n;
}

/**
 * Determines whether a roll is a Bunco (all 3 dices of the dice box rolled the number 
 * that matches the number of the current round)
 * @param roll the ArrayList containing the number rolled by each of the 3 dices
 * @param Round the current round being played
 * @return true or false
 */
public static Boolean isABunco (ArrayList<Integer> roll, int Round) {
	Boolean result = true;
	for(int i =0; i<3; i++) {
		if(!(roll.get(i) == Round)) {
			result = false;
			break;
			}
		else {
			result = true;
		}
	}
	return result;
}

/**
 * Determines whether a roll is a mini Bunco (all 3 dices rolled 1 in a round other than the first one)
 * @param roll an ArrayList containing the number rolled by each of the 3 dices.
 * @return true or false
 */
public static Boolean isAMiniBunco (ArrayList<Integer> roll) {
	Boolean result = true;
	for(int i =0; i<3; i++) {
		if(!(roll.get(i) == 1)) {
			result = false;
			break;
			}
		else {
			result = true;
		}
	}
	return result;
}

public static Boolean containsRoundNo (ArrayList<Integer> roll, int Round) {
	Boolean result = true;
	for(int i =0; i<3; i++) {
		if(roll.get(i) == Round) {
			result = true;
			break;
			}
		else {
			result = false;
		}
	}
	return result;
}

/**
 * Conducts a round of Bunco by producing the computer's rolls when it is its turn and prompting the 
 * human to role when it is their turn and tabulates the points gained by each player during the round and the total 
 * number of points.
 * @param p a Player object that can be the human player or the computer opponent
 * @param roundNo the current round being played
 */
public static void playRound(Player p, int roundNo) {
	Scanner sc = new Scanner(System.in);
	ArrayList<Integer> placeholder = new ArrayList<Integer>();
	
    if(p == player) {
    	hrp = 0;
		do {
		    System.out.println("Hit the \"Enter\" key to roll.");
				sc.nextLine();	
				ArrayList<Integer> round = getDiceBox().roll();
				placeholder = round;
				System.out.println(player.getName() + " rolled a " + round);
				if(isABunco(round, roundNo)) {
					System.out.println("Continue rolling in Round " + roundNo);
					humanPoints = humanPoints + 21;
					hrp = hrp + 21;
				}
				else if(containsRoundNo(round, roundNo)){
					for(int j = 0; j<3; j++) {
						if(round.get(j) == roundNo) {
							humanPoints++;
							hrp++;
						}
					}
					System.out.println("Continue rolling in Round " + roundNo);
				}
				
				else if(isAMiniBunco(round)) {
					humanPoints = humanPoints + 5;
					hrp = hrp + 5;
					System.out.println("Continue rolling in Round " + roundNo);
				}
				
				else {
					System.out.println(player.getName() + " did not roll a " + roundNo + ", so their turn in Round " + roundNo + " is over.");
				}
				
			}//do 

			while((containsRoundNo(placeholder, roundNo))||(isAMiniBunco(placeholder)));

			
	}
    if(p == computer) {
    	crp = 0;
    	do {
		   	ArrayList<Integer> round = getDiceBox().roll();
				placeholder = round;
				System.out.println("The computer rolled a " + round);
				if(isABunco(round, roundNo)) {
					System.out.println("The compuer shall continue rolling in Round " + roundNo);
					computerPoints = computerPoints + 21;
					crp = crp + 21;
				}
				else if(containsRoundNo(round, roundNo)){
					for(int j = 0; j<3; j++) {
						if(round.get(j) == roundNo) {
							computerPoints++;
							crp++;
						}
					}
					System.out.println("The computer shall continue rolling in Round " + roundNo);
				}
				
				else if(isAMiniBunco(round)) {
					computerPoints = computerPoints + 5;
					crp = crp + 5;
					System.out.println("The computer shall continue rolling in Round " + roundNo);
				}
				
				else {
					System.out.println("The computer did not roll a " + roundNo + ", so its turn in Round " + roundNo + " is over.");
				}
				
			}//do 

			while((containsRoundNo(placeholder, roundNo))||(isAMiniBunco(placeholder)));
    }
}
}
