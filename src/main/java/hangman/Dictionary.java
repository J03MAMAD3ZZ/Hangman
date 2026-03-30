package hangman;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Dictionary {

    private List<String> words;
    private static final int MAX_WORD_LENGTH = 8;
    private final String filePath;
    private final Random random = new Random();

    public Dictionary (String path) {
        this.filePath = path;
        initDictionary();
    }



    public String getFilePath() {
        return this.filePath;
    }

    public List<String> getWords() {
        return this.words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    private void initDictionary() {
        try {
            setWords(Files.readAllLines(Path.of(getFilePath()))
                    .stream()
                    .filter(s -> s.length() <= MAX_WORD_LENGTH)
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public String getRandomWord() {
        return getWords().get(random.nextInt(getWords().size()));
    }

}

