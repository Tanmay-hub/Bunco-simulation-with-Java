/**
 * A class for stimulating the player playing Bunco
 * @author Tanmay Bothra
 *
 */
public class Player {
 private static String name = "computer";
public Player(){
	name = "computer";
}
public static String setName(String inputName) {
	 name = inputName;
	 return name;
}

public static String getName() {
	return name;
}

}
