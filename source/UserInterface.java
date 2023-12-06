
interface UserInterface {
	int getIntInput();
	int getIntInputWithinRangeOfOption(int startOfRange, int endOfRange);
	int getMenuInput();
	int getUserGuess(int lowerBound, int upperBound);
	void printHintMessage(int guessCompareToTarget, int remainingNumberOfAttempts);
	void printOutOfLimitMessage(int lowerBound, int upperBound);
	void displayResult(boolean guessCorrectness, int numberOfGuess);
	int getUserContinueOption();
	
}
