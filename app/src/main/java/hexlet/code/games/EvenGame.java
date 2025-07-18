package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class EvenGame {
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startGame() {
        String[][] roundsData = new String[Engine.ROUNDS_AMOUNT][2];
        Random random = new Random();

        for (int i = 0; i < roundsData.length; i++) {
            int number = random.nextInt(100) + 1;
            String question = Integer.toString(number);
            String answer = isEven(number) ? "yes" : "no";

            roundsData[i][0] = question;
            roundsData[i][1] = answer;
        }

        Engine.startGame(RULES, roundsData);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
