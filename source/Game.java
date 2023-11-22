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
	
	public boolean isGuessOutOfBound(int userGuess) {
		if( (userGuess < LOWERBOUND) || (userGuess > UPPERBOUND))
			return true;
		return false;
	}
	
	public int compareGuessAndTarget(int userGuess){
		int numberToReturn;
		
		if(userGuess < targetNumber) 
			numberToReturn = -1;
		else if(userGuess == targetNumber) 
			numberToReturn = 0;
		else 
			numberToReturn = 1;
		
		updateNumberOfGuess();
		
		return numberToReturn;
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
	
	public GameState getState(){
		return state;
	}
	
	public void setState(GameState stateToUpdate) {
		state = stateToUpdate;
	}
	
	public int getTargetNumber() {
		return targetNumber;
	}
	
	
	
	public static void main(String[] args) {
		var g = new Game();
		int guessAndTarget;
		
		System.out.println("NumberOfGuess is  " + g.getNumberOfGuess());
		System.out.println();
		
		for(int i = 0; i< 1000; i++){
			g.targetNumber = g.generateTargetNumber();
			if(g.targetNumber < g.LOWERBOUND)
				System.out.println("This sentence shouldn't display!");
		}
		
		System.out.println("Target is " + g.targetNumber);
		System.out.println();
		
		guessAndTarget = g.compareGuessAndTarget(1);
		System.out.println("Result of compareGuessAndTarget(1) is " + 
											guessAndTarget);
		System.out.println();								
		
		guessAndTarget = g.compareGuessAndTarget(100);
		System.out.println("Result of compareGuessAndTarget(100) is " + 
											guessAndTarget);
		System.out.println();
		
		guessAndTarget = g.compareGuessAndTarget(g.targetNumber);
		System.out.println("Result of compareGuessAndTarget(g.targetNumber) is " 
										+ guessAndTarget);
		System.out.println();
		
		System.out.println("NumberOfGuess after 3 attempts " + 
												g.getNumberOfGuess());
		System.out.println();
		
		System.out.println("LowerBound is  " + g.getLowerBound());
		System.out.println();
		
		System.out.println("UpperBound is  " + g.getUpperBound());
		System.out.println();
		
		System.out.println("GameState is  " + g.getState());
		System.out.println();
		
		System.out.println("Edit Game State to End");
		g.setState(GameState.END);
		System.out.println("GameState is  " + g.getState());
		
		
		
		
	}
}