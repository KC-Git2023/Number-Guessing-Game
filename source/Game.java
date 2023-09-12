import java.util.Random;
public class Game {
	private final int LOWERBOUND = 1;
	private final int UPPERBOUND = 100;
	private final int NUMBEROFGUESSLIMIT = 5;
	
	private int targetNumber;
	private int numberOfGuess;
	private GameState state;
	
	public Game() {
		targetNumber = generateTargetNumber();
		numberOfGuess = 0;
		state = GameState.RUNNING;
	}
	
	private int generateTargetNumber() {
		var r = new Random();
		int integer = r.nextInt(UPPERBOUND);
		
		if(integer <  LOWERBOUND) return LOWERBOUND;

		return integer;
	}
	
	public int comapreGuessAndTarget(int userGuess){
		//....
		return 1;
	}
	
	public void updateNumberOfGuess(){
		numberOfGuess++;
	}
	
	public int getNumberOfGuess() {
		return numberOfGuess;
	}
	
	public int getLowerBound() {
		return LOWERBOUND;
	}
	
	public int getUpperBound() {
		return UPPERBOUND;
	}
	
	private GameState getState(){
		return state;
	}
	
	
	public static void main(String[] args) {
		var g = new Game();
		for(int i = 0; i< 1000; i++){
			g.targetNumber = g.generateTargetNumber();
			if(g.targetNumber < g.LOWERBOUND)
				System.out.println("This sentence shouldn't display!");
		}
	}
}