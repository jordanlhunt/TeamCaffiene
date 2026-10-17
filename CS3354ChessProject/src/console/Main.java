//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package console;

import service.ConsoleUI;
import service.Game;

public class Main {
    /**
     * Application entry point.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
        ConsoleUI consoleUI = new ConsoleUI(game);
        consoleUI.runGame();
    }
}