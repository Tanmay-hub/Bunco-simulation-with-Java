import java.util.Random;
/**
 * A class for stimulating a dice
 * @author Tanmay Bothra
 *
 */
public class Dice {
	/**
	 * Rolls the dice by generating a random number between 1 and 6
	 * @return the rolled number (ie the random number between 1 and 6)
	 */
public static int roll(){
	Random rng = new Random();
	int response = rng.nextInt(6) + 1;
	return response;
}

}