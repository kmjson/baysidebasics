import cs1.Keyboard;

public class Woo {

    static Player human;
    static Player AI;

    public static void start() {
	System.out.println("\n============================================");
	System.out.println("Welcome player.\n\nYou are about to embark in a naval war. Are you prepared for that?\nPlease enter Yes if you are, No if you are not.\n");
	String ans = Keyboard.readString();
	if (!(ans.equals("Yes")) && !(ans.equals("No"))) {
	    System.out.println ("Please enter a valid answer.\nIt is case-sensitive");
	    start();
	}
	else {
	    if (ans.equals("Yes")) {
		System.out.println ("\nThat is what we, the game developers, like to hear!! \nPrepare for war!");
	    }
	    if (ans.equals("No")) {
		System.out.println ("That is too bad. Prepare for war!");
	    }
	}
	System.out.println("\n============================================");
	System.out.println("Time to choose the difficulty! If you fail to follow these instructions, we WILL make it harder for you!");
	System.out.println("Type either 1 or 2, and then press enter!");
	System.out.println("1) Beginner");
	System.out.println("2) Advanced");
	int diff = Keyboard.readInt();
	if (diff == 1) {
	    AI = new BeginnerAI();
	}
	else {
	    AI = new AdvancedAI();
	}
    }
    
    public static void main (String[]args) {
	human = new Human();
	Boolean a = true;

	start(); // begin!
	
	human.setGrid();
	System.out.println("\n============================================");
	System.out.println("Time to place ships!");
	
	System.out.println(human);
	System.out.println("Please place your Carrier");
	human.placeCarrier();

	System.out.println(human);
	System.out.println("Please place your Battleship");
	human.placeBattleship();

	System.out.println(human);
	System.out.println("Please place your Cruiser");
	human.placeCruiser();

	System.out.println(human);
	System.out.println("Please place your Submarine");
	human.placeSubmarine();

	System.out.println(human);
	System.out.println("Please place your Destroyer");
	human.placeDestroyer();
	human.setPlaying(true);

	AI.setGrid();
	AI.placeCarrier();
	AI.placeBattleship();
	AI.placeCruiser();
	AI.placeSubmarine();
	AI.placeDestroyer();
	while (a) {
	    System.out.println("\n============================================");
	    System.out.println("Time to attack! Both grids are given to you.");
	    System.out.println("Row: Integer between 1 - 10");
	    System.out.println("Col: CAPITAL letter between A - J");
	    System.out.println(human);
	    human.attackOpponent(AI);
	    if (AI.check()) {
		System.out.println("Congratulations! You have defeated the enemy team! ");
		a=false;
	    }
	    else {
		AI.attackOpponent(human);
		if (human.check()) {
		    System.out.println("Uh oh, your navy has been wiped out. You have lost.");
		    a=false;
		}
	    }
	}
    }
}
