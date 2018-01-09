import cs1.Keyboard;

public class Woo {
    
    public static void main (String[]args) {
	Player human = new Human();
	Player AI = new BeginnerAI();
	Boolean a = true;
	int row = 0;
	int col = 0;
	human.setGrid();
	human.placeShip();
	AI.setGrid();
	AI.placeShip();
	while (a) {
	    System.out.println(human);
	    System.out.print("Row: ");
	    row = Keyboard.readInt();
	    System.out.print("Col: ");
	    col = Keyboard.readInt();
	    human.attackOpponent(row,col, AI);
	    if (AI.check()) {
		System.out.println("You Win!");
		break;
	    }
	    AI.attackOpponent(human);
	    if (human.check()) {
		System.out.println("You Lose!");
		break;
	    }
	}
    }
}
