public class Main {
	public static void main(String[] args) {
		var game = new Game();
		var ui = new UserInterface();
		
		var flowController = new GameFlowController(game, ui);
		
		flowController.startGame();
	}
}