import java.util.Scanner;
import java.util.InputMismatchException;

public class UserInterface {
	Scanner sc = new Scanner(System.in);
	
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
	
	public void printContinueMessage() {
		System.out.println("Continue?");
	}
	
	public void displayResult(boolean guessCorrectness, int numberOfGuess) {
		if(guessCorrectness)
			System.out.printf("Contration! You guessed the correct "
					+ "target number in %d attempts\n", numberOfGuess);
		else 
			System.out.println("Unfortunately, you didn't guess it.");
	}
	
	public String getContinueOption() {
		var continueOption = sc.next();
		return continueOption;
	}
	
	
}