package hangman;

public final class HangmanRender {

    public static void drawHangman (int attempts) {
        switch (attempts) {
            case 5 -> System.out.println("""
                            0
                            """);
            case 4 -> System.out.println("""
                             0
                             |
                            
                            """);
            case 3 -> System.out.println("""
                            0
                            |
                           / 
                           """);
            case 2 -> System.out.println("""
                            0
                            |
                           / \\
                          """);
            case 1 -> System.out.println("""
                            0
                          / |
                           / \\
                          """);
            case 0 -> System.out.println("""
                             0
                           / | \\
                            / \\
                           """);
        }
    }
}
