package hangman;

import java.util.Scanner;

//I don't think inheriting from Wordmask class like that is ok
//but i really need getters from that class.
//Making a field Wordmask in Game class also turned out to be an ugly decision


public class Game extends Wordmask {
    private int attempts = 6;
    private static final Scanner userInput = new Scanner(System.in);

    public Game(String initialWord) {
        super(initialWord);
    }

    public int getAttempts() {
        return attempts;
    }

    public void play() {
            greetPlayer();
        while (isNotFinished()) {
            System.out.println(getMaskedWord());
            System.out.println("Attempts left: " + getAttempts());
            System.out.println("Enter a letter: ");
            char guessedLetter = userInput.next().charAt(0);
            if (!isCorrectLetter(guessedLetter)) {
                attempts--;
                HangmanRender.drawHangman(attempts);
            } else {
                updateWordMask(getOriginalWord(), guessedLetter);
            }

            if (isLost()) {
                System.out.println("You lost! The word was: " + getOriginalWord());
                break;
            } else if (isWon()) {
                System.out.println("Congratulations! You won! The word was: " + getOriginalWord());
                break;
            }
        }
    }

    public boolean isNotFinished() {
        return attempts > 0;
    }

    public boolean isWon() {
        return getOriginalWord().contentEquals(getMaskedWord());
    }

    public boolean isLost() {
            return getAttempts() == 0;
    }

    public boolean isCorrectLetter(char guessedLetter){
        return getOriginalWord().contains(String.valueOf(guessedLetter));
    }

    public void greetPlayer() {
        System.out.println("Welcome to Hangman!");
    }
}
