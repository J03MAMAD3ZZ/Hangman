package hangman;

public class Wordmask {

    private final StringBuilder maskedWord = new StringBuilder();
    private final String originalWord;

    public Wordmask(String initialWord) {
        this.originalWord = initialWord;
        initMask(initialWord);
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public StringBuilder getMaskedWord() {
        return maskedWord;
    }

    public void initMask (String word) {
        getMaskedWord().append("_".repeat(word.length()));
    }

    public void updateWordMask (String word, char guessedLetter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guessedLetter) {
                getMaskedWord().setCharAt(i, guessedLetter);
            }
        }
    }

}
