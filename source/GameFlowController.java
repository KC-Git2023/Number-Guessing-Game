public class GameFlowController {
	Game game;
	UserInterface ui;
	
	public GameFlowController() {
		game = new Game();
		ui = new UserInterface();
	}
	
	public void startGame() {
		int userOption = ui.getMenuInput();
		if(userOption == 1)  runGame();
		
	}
	
	private void runGame() {
		int userGuess;
		int guessCompareToTarget;
		
		do {
			System.out.println("Target is " + game.getTargetNumber());
			userGuess = ui.getUserGuess();
			
			if(!game.isGuessOutOfBound(userGuess)) {
				guessCompareToTarget = 
								game.compareGuessAndTarget(userGuess);
				
				if(guessCompareToTarget != 0)
					ui.printHintMessage(guessCompareToTarget);
				else
					game.setState(GameState.END);		
			}
			else 
				ui.printOutOfLimitMessage(game.getLowerBound(), 
												game.getUpperBound());	
		} while(game.getState() != GameState.END);
		
	}
	
	private void reset() {
		int userContinueOption = ui.getUserContinueOption();
		
		if(userContinueOption == 1) {
			game = null;
			ui = null;
			
			game = new Game();
			ui = new UserInterface();
			runGame();
		}	
		
	}
	
}