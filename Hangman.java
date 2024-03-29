
import java.util.Scanner;

public class Hangman {
    static String guessWord = "HELLOWORLD";
    static String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String wrongGuess = "";
    static String guessed = "";

    public static void main(String a[]) {
        Scanner inp = new Scanner(System.in);
        int remainingGuesses = 8;

        while (remainingGuesses > 0) {
            System.out.println("You have " + remainingGuesses + " Guesses Left");
            System.out.print("ALPHABETS LEFT: ");
            String temp = guessed + wrongGuess;
            for (int j = 0; j < alphabets.length(); j++) {
                boolean presence = false;
                for (int k = 0; k < temp.length(); k++) {
                    if (temp.charAt(k) == alphabets.charAt(j)) {
                        presence = true;
                        break;
                    }
                }
                if (!presence) System.out.print(alphabets.charAt(j) + " ");
            }
            System.out.println();

            System.out.print("Enter your guess: ");
            char guess = inp.next().toUpperCase().charAt(0);

            if (!isChar(guess, guessed) && isChar(guess, guessWord)) {
                guessed += guess;
                System.out.print("Guess So far: ");
                for (int j = 0; j < guessWord.length(); j++) {
                    if (guessed.indexOf(guessWord.charAt(j)) != -1) {
                        System.out.print(guessWord.charAt(j) + " ");
                    } else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
            } else {
                remainingGuesses--;
                System.out.print("Guess So far: ");
                for (int j = 0; j < guessWord.length(); j++) {
                    if (guessed.indexOf(guessWord.charAt(j)) != -1) {
                        System.out.print(guessWord.charAt(j) + " ");
                    } else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
                wrongGuess += guess;
            }

            if (guessWord.equals(guessed)) {
                System.out.println("Congratulations! You guessed the word correctly.");
                break;
            }
        }
        inp.close();
    }

    static boolean isChar(char a, String t) {
        return t.indexOf(a) != -1;
    }
}

