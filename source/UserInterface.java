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
		System.out.print("Please Input your option: ");
		do {
				try {
					num = sc.nextInt();
				break;
			} catch(InputMismatchException ex){
					System.out.println("Please input integer");
					sc.nextLine();					
			}
		} while(true);
		
		return num;
  }
	
	private int getIntInputWithinRangeOfOption(int startOfRange, int endOfRange) 
	{
		int num;
		do {
			System.out.printf("Please Input your option between %d and %d\n", startOfRange, endOfRange);
			
			num = getIntInput();
			
		} while((num < startOfRange) || (num > endOfRange));
		
		return num;
		
	}
	
	public int getMenuInput() {
	  System.out.println("1.Start Game");
		System.out.println("2.Exit");
		
		var userMenuInput = getIntInput();
		return userMenuInput;
	}
	
	
	public int getUserGuess() {
	  System.out.println("Please input a guess");
	    
		var userGuess = getIntInput();
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
	
	
	public int getUserContinueOption() {
		System.out.println("Continue?");
		System.out.println("1.Yes");
		System.out.println("2.No");
	    
		var continueOption = getIntInput();
		return continueOption;
	}
	
	
	
	
	public static void main(String[] args) {
		var ui = new UserInterface();
		int menuInput, userGuess, continueOption;
		
		menuInput = ui.getMenuInput();
		System.out.println("User menu input is " + menuInput);
		
		System.out.println();
		
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
		
		continueOption = ui.getUserContinueOption();
		System.out.println("User continue Option is " + continueOption);
		
		
		
	}
	
}