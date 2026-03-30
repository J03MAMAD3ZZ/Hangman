package hangman;

import java.util.Scanner;

public class Game {
    private final Wordmask wordmask;
    private int attempts = 6;
    private static final Scanner userInput = new Scanner(System.in);

    public Game(Wordmask wordmask) {
        this.wordmask = wordmask;
    }

    public int getAttempts() {
        return attempts;
    }

    public void play() {
            greetPlayer();
        while (!isFinished()) {
            System.out.println(wordmask.getMaskedWord());
            System.out.println("Attempts left: " + getAttempts());
            System.out.println("Enter a letter: ");
            char guessedLetter = userInput.next().charAt(0);
            if (!isCorrectLetter(guessedLetter)) {
                attempts--;
                HangmanRender.drawHangman(getAttempts());
            } else {
                wordmask.updateWordMask(guessedLetter);
            }

            if (isLost()) {
                System.out.println("You lost! The word was: " + wordmask.getOriginalWord());
                break;
            } else if (isWon()) {
                System.out.println("Congratulations! You won! The word was: " + wordmask.getOriginalWord());
                break;
            }
        }
    }

    public boolean isFinished() {
        return isWon() || isLost();
    }

    public boolean isWon() {
        return wordmask.getOriginalWord().contentEquals(wordmask.getMaskedWord());
    }

    public boolean isLost() {
            return getAttempts() == 0;
    }

    public boolean isCorrectLetter(char guessedLetter){
        return wordmask.getOriginalWord().contains(String.valueOf(guessedLetter));
    }

    public void greetPlayer() {
        System.out.println("Welcome to Hangman!");  
    }
}
