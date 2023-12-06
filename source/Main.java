public class Main {
	public static void main(String[] args) {
		var game = new Game();
		UserInterface ui = new CommandLineInterface();
		
		var flowController = new GameFlowController(game, ui);
		
		flowController.startGame();
	}
}