import java.util.Scanner;
import java.util.InputMismatchException;

public class UserInterface {
	Scanner sc;
	
	UserInterface() {
		sc = new Scanner(System.in);
	}
	
	public void showMenu() {
		System.out.println("1.Start Game");
		System.out.println("2.Exit");
	}
	
	public int getMenuInput() throws InputMismatchException{
		var userMenuInput = sc.nextInt();
		return userMenuInput;
	}
	
	public void printRequestInputGuessMessage() {
		System.out.println("Please input a guess");
	}
	
	public int getUserGuess() throws InputMismatchException{
		var userGuess = sc.nextInt();
		return userGuess;
	}
	
	public void printHintMessage(int guessCompareToTarget) {
		if (guessCompareToTarget < 0)
			System.out.println("Try again! Your guess was too low!");
		
		else if (guessCompareToTarget > 0)
			System.out.println("Try again! Your guess was too high!");
	}
	
	public void printOutOfLimitMessage(int lowerBound, int upperBound) {
		System.out.println("Your guess is outside the limit.");
		System.out.printf("The range is from %d to %d.\n", 
											lowerBound, upperBound);
	}
	
	public void displayResult(boolean guessCorrectness, int numberOfGuess) {
		if(guessCorrectness)
			System.out.printf("Contration! You guessed the correct "
					+ "target number in %d attempts\n", numberOfGuess);
		else 
			System.out.println("Unfortunately, you didn't guess it.");
	}
	
	public void printContinueMessage() {
		System.out.println("Continue?");
	}
	
	public String getContinueOption() {
		var continueOption = sc.next();
		return continueOption;
	}
	
	public static void main(String[] args) {
		var ui = new UserInterface();
		int menuInput, userGuess;
		String continueOption;
		
		ui.showMenu();
		menuInput = ui.getMenuInput();
		System.out.println("User menu input is " + menuInput);
		
		System.out.println();
		
		ui.printRequestInputGuessMessage();
		userGuess = ui.getUserGuess();
		System.out.println("User guess is " + userGuess);
		
		System.out.println();
		
		ui.printHintMessage(-1);
		ui.printHintMessage(0);
		ui.printHintMessage(1);
		
		System.out.println();
		
		ui.printOutOfLimitMessage(1, 10);
		
		System.out.println();
		
		
		ui.displayResult(false, 3);
		System.out.println();
		
		ui.displayResult(true, 3);
		System.out.println();
		
		ui.printContinueMessage();
		continueOption = ui.getContinueOption();
		System.out.println("User continue Option is " + continueOption);
		
		
		
	}
	
}