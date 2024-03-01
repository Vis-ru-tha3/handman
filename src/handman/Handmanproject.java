package handman;

import java.util.Random;
import java.util.Scanner;

public class Handmanproject 
{
	private static final String[] WORDS = {"encryption", "machine", "express", "firebase", "mongodb",  "python", "javascript", "network", "database", "software",
            "typescript", "development", "coding", "algorithm", "html", 
            "postgresql", "frontend", "intelligence", "keyboard", "computer", 
            "security", "vue", "server", "learning", "git", 
            "programming", "cloud", "openai", "backend", "variable", 
            "interface", "css", "angular", "artificial", "docker", 
            "model", "web", "hangman", "java", "node", 
            "server", "debugging", "kubernetes", "sqlite","framework", 
            "application"};

    private static final int MAX_CHANCES = 7;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String word = WORDS[random.nextInt(WORDS.length)];
        char[] guessedWord = new char[word.length()];
        boolean[] guessedLetters = new boolean[26];
        int chances = MAX_CHANCES;
        int incorrectGuesses = 0;

        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        while (chances > 0) {
            System.out.println("Guess the word: " + new String(guessedWord));
            System.out.println("Chances left: " + chances);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (!Character.isLetter(guess)) {
                System.out.println("Please enter a valid letter.");
                continue;
            }

            if (guessedLetters[guess - 'a']) {
                System.out.println("You have already guessed that letter.");
                continue;
            }

            guessedLetters[guess - 'a'] = true;
            boolean correctGuess = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                chances--;
                incorrectGuesses++;
                drawHangman(incorrectGuesses);
                System.out.println("Incorrect guess!");
            }

            boolean wordGuessed = true;
            for (char c : guessedWord) {
                if (c == '_') {
                    wordGuessed = false;
                    break;
                }
            }

            if (wordGuessed) {
                System.out.println("Congratulations! You guessed the word: " + word);
                break;
            }
        }

        if (chances == 0) {
            System.out.println("Sorry, you ran out of chances. The word was: " + word);
        }
    }

    private static void drawHangman(int incorrectGuesses) {
        switch (incorrectGuesses) {
            case 1:
            	System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("___|___");
                break;
            case 2:
            	System.out.println("   _____________");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   | ");
                System.out.println("___|___");
                break;
            case 3:
            	System.out.println("   _____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        |     |");
                System.out.println("   |         \\_ _/");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("___|___");
                break;
            case 4:
            	System.out.println("   _____________");
                System.out.println("   |          _|_");
                System.out.println("   |         /   \\");
                System.out.println("   |        |     |");
                System.out.println("   |         \\_ _/");
                System.out.println("   |           |");
                System.out.println("   |           |");
                System.out.println("   |");
                System.out.println("___|___");
                break;
            case 5:
            	 System.out.println("   _____________");
                 System.out.println("   |          _|_");
                 System.out.println("   |         /   \\");
                 System.out.println("   |        |     |");
                 System.out.println("   |         \\_ _/");
                 System.out.println("   |          _|_");
                 System.out.println("   |         / | \\");
                 System.out.println("   |         ");
                 System.out.println("___|___      ");
                break;
            case 6:
            	 System.out.println("   _____________");
                 System.out.println("   |          _|_");
                 System.out.println("   |         /   \\");
                 System.out.println("   |        |     |");
                 System.out.println("   |         \\_ _/");
                 System.out.println("   |          _|_");
                 System.out.println("   |         / | \\");
                 System.out.println("   |          / ");
                 System.out.println("___|___      / ");
                break;
            case 7:
                 System.out.println("   _____________");
                 System.out.println("   |          _|_");
                 System.out.println("   |         /   \\");
                 System.out.println("   |        |     |");
                 System.out.println("   |         \\_ _/");
                 System.out.println("   |          _|_");
                 System.out.println("   |         / | \\");
                 System.out.println("   |          / \\ ");
                 System.out.println("___|___      /   \\");
                 System.out.println("GAME OVER!");
                break;
        }
    }
}



