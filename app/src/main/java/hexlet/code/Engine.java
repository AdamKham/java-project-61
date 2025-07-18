package hexlet.code;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_AMOUNT = 3;

    public static void startGame(String rules, String[][] gameData) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");

        System.out.println(rules);

        for (String[] roundData : gameData) {
            String question = roundData[0];
            String correctAnswer = roundData[1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (!userAnswer.equalsIgnoreCase(correctAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. " +
                        "Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }

            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
