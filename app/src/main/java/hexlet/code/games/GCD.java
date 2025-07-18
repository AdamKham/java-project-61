package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    private static final String RULES = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        String[][] roundsData = new String[Engine.ROUNDS_AMOUNT][2];
        Random random = new Random();

        for (int i = 0; i < roundsData.length; i++) {
            int randomNumber1 = random.nextInt(100) + 1;
            int randomNumber2 = random.nextInt(100) + 1;

            String question = randomNumber1 + " " + randomNumber2;
            String answer = Integer.toString(findGCD(randomNumber1, randomNumber2));

            roundsData[i][0] = question;
            roundsData[i][1] = answer;
        }

        Engine.startGame(RULES, roundsData);
    }

    private static int findGCD(int a, int b) {
        while (b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }

        return a;
    }
}
