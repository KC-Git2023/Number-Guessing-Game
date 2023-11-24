import java.util.Scanner;
import java.util.InputMismatchException;

public class UserInterface {
	Scanner sc;
	int startOfMenuOption, endOfMenuOption, startOfContinueOption,
			endOfContinueOption;
	
	public UserInterface() {
		sc = new Scanner(System.in);
		
		startOfMenuOption = 1;
		endOfMenuOption = 2;
		
		startOfContinueOption = 1;
		endOfContinueOption = 2;
	}
	
	private int getIntInput() {
		int num;
		do {
				try {
					num = sc.nextInt();
				break;
			} catch(InputMismatchException ex){
					System.out.print("Please input integer: ");
					sc.nextLine();					
			}
		} while(true);
		
		return num;
  }
	
	private int getIntInputWithinRangeOfOption(int startOfRange, int endOfRange) 
	{
		int num;
		do {
			System.out.printf("\nPlease Input your option between %d and %d: ", 
			                startOfRange, endOfRange);
			
			num = getIntInput();
			
			if((num < startOfRange) || (num > endOfRange))
				System.out.println("Your input is outside the range of options!");
			
		} while((num < startOfRange) || (num > endOfRange));
		
		return num;
		
	}
	
	public int getMenuInput() {
	  System.out.println("1.Start Game");
		System.out.println("2.Exit");
		
		var userMenuInput = getIntInputWithinRangeOfOption(startOfMenuOption, endOfMenuOption);
		return userMenuInput;
	}
	
	
	public int getUserGuess(int lowerBound, int upperBound) {
	  System.out.printf("\nPlease input a guess that between " + 
				"%d and %d: ", lowerBound, upperBound);
	    
		var userGuess = getIntInput();
		return userGuess;
	}
	
	public void printHintMessage(int guessCompareToTarget, int remainingNumberOfAttempts) {
		if(guessCompareToTarget != 0){
			if (guessCompareToTarget < 0)
				System.out.println("\nTry again! Your guess was too low!");
			
			else if (guessCompareToTarget > 0)
				System.out.println("\nTry again! Your guess was too high!");
			
			System.out.println("\nThe remaining number of attempts is " +
												remainingNumberOfAttempts);
		}
	}
	
	public void printOutOfLimitMessage(int lowerBound, int upperBound) {
		System.out.println("\nYour guess is outside the limit.");
		System.out.printf("The range is from %d to %d.\n", 
											lowerBound, upperBound);
	}
	
	public void displayResult(boolean guessCorrectness, int numberOfGuess) {
		if(guessCorrectness)
			System.out.printf("\nContration! You guessed the correct "
					+ "target number in %d attempts\n", numberOfGuess);
		else 
			System.out.println("\nUnfortunately, you didn't guess it.");
	}
	
	
	public int getUserContinueOption() {
		System.out.println("\nContinue?");
		System.out.println("1.Yes");
		System.out.println("2.No");
	    
		var continueOption = getIntInputWithinRangeOfOption(startOfContinueOption, 
		                        endOfContinueOption);
		return continueOption;
	}
	
	public static void main(String[] args) {
		var ui = new UserInterface();
		int menuInput, userGuess, continueOption;
		
		menuInput = ui.getMenuInput();
		System.out.println("User menu input is " + menuInput);
		
		System.out.println();
		
		//userGuess = ui.getUserGuess();
		//System.out.println("User guess is " + userGuess);
		
		System.out.println();
		
		/*
		ui.printHintMessage(-1);
		ui.printHintMessage(0);
		ui.printHintMessage(1);
		*/
		
		System.out.println();
		
		ui.printOutOfLimitMessage(1, 10);
		
		System.out.println();
		
		
		ui.displayResult(false, 3);
		System.out.println();
		
		ui.displayResult(true, 3);
		System.out.println();
		
		continueOption = ui.getUserContinueOption();
		System.out.println("User continue Option is " + continueOption);
		
	}
	
}
	
