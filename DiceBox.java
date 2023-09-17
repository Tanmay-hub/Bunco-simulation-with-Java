import java.util.ArrayList;
/**
 * A class for stimulating a dice box containing 3 dice that will be rolled by the player
 * @author Tanmay Bothra
 */
public class DiceBox {
private static Dice d1 = new Dice();
private static Dice d2 = new Dice();
private static Dice d3 = new Dice();

/**
 * Roll the 3 dice, and add the number rolled by each dice to an ArrayList
 * @return the ArrayList
 */
public static ArrayList<Integer> roll() {
	ArrayList<Integer> rolls = new ArrayList<Integer>();
	rolls.add(d1.roll());
	rolls.add(d2.roll());
	rolls.add(d3.roll());
	return rolls;
}


}