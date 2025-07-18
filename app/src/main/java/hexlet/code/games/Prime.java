package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Prime {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        Random random = new Random();
        String[][] roundsData = new String[Engine.ROUNDS_AMOUNT][2];

        for (int i = 0; i < roundsData.length; i++) {
            int number = random.nextInt(100) + 1;
            String question = Integer.toString(number);
            String answer = isPrime(number) ? "yes" : "no";

            roundsData[i][0] = question;
            roundsData[i][1] = answer;
        }

        Engine.startGame(RULES, roundsData);
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
