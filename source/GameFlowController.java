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
		int remainingNumberOfAttempts;
		
		do {
			System.out.println("Target is " + game.getTargetNumber());
			userGuess = ui.getUserGuess(game.getLowerBound(), 
													game.getUpperBound());
			
			if(!game.isGuessOutOfBound(userGuess)) {
				guessCompareToTarget = 
								game.compareGuessAndTarget(userGuess);
								
				remainingNumberOfAttempts = game.getRemainingNumberOfAttempts();
				
				if(remainingNumberOfAttempts == 0) {
					setEndState();
					break;
				}
			
				
				if(guessCompareToTarget != 0)
					ui.printHintMessage(guessCompareToTarget, 
											remainingNumberOfAttempts);
				else
					setEndState();	
			}
			else 
				ui.printOutOfLimitMessage(game.getLowerBound(), 
												game.getUpperBound());	
		} while(game.getState() != GameState.END);
		
		afterGame();
	
	}
	
	private void afterGame() {
		int continueOption;
		
		setGameUserGuessTheTarget();
		
		ui.displayResult(game.getIsUserGuesstheTarget(), 
							game.getNumberOfGuess());
							
		continueOption = ui.getUserContinueOption();
		
		if(continueOption == 1)
			reset();
	}
	
	
	private void setEndState() {
		game.setState(GameState.END);
	}
	
	private void setGameUserGuessTheTarget() {
		if(game.getRemainingNumberOfAttempts() > 0)
			game.setUserGuesstheTarget(true);
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