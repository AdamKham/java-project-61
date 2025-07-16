package hexlet.code;

import java.util.Scanner;

public class EvenGame {
    public static void startGame(Scanner scanner, String userName) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int totalQuestions = 3;
        int correctAnswersCount = 0;

        while (correctAnswersCount < totalQuestions) {
            int randomNumber = (int) (Math.random() * 100) + 1;
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            boolean isEven = randomNumber % 2 == 0;
            String correctAnswer = isEven ? "yes" : "no";

            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswersCount++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. " +
                        "Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
