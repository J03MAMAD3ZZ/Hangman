package hangman;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String WORD_PATH = "src/main/resources/word.txt";
    private final Dictionary dictionary = new Dictionary(WORD_PATH);
    private static final Scanner userInput = new Scanner(System.in);


    public Main() throws IOException {
    }

    void main () throws IOException {
        askForNewGame();
    }

    public void askForNewGame() throws IOException {
        while (true) {
            System.out.println("Would you like to play again? (Y/N)");
            char userChoice = userInput.next().charAt(0);
            switch (userChoice) {
                case 'Y', 'y' -> startNewGame();
                case 'N', 'n' -> {
                    System.out.println("Thank you for playing! Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }

    public void startNewGame() {
        Game newGame = new Game(new Wordmask(dictionary.getRandomWord()));
        newGame.play();
    }

}
