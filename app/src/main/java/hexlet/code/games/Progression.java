package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MAX_STEP = 10;
    private static final int MAX_START = 20;

    public static void startGame() {
        String[][] roundsData = new String[Engine.ROUNDS_AMOUNT][2];
        Random random = new Random();

        for (int i = 0; i < roundsData.length; i++) {
            int length = random.nextInt(MIN_LENGTH, MAX_LENGTH + 1);
            int step = random.nextInt(1, MAX_STEP);
            int start = random.nextInt(MAX_START);
            int hiddenIndex = random.nextInt(length);

            int[] progression = generateProgression(start, step, length);
            String question = buildQuestion(progression, hiddenIndex);
            String answer = String.valueOf(progression[hiddenIndex]);

            roundsData[i][0] = question;
            roundsData[i][1] = answer;
        }

        Engine.startGame(RULES, roundsData);
    }

    private static int[] generateProgression(int start, int step, int length) {
        int[] progression = new int[length];

        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }

        return progression;
    }

    private static String buildQuestion(int[] progression, int hiddenIndex) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < progression.length; i++) {
            if (i == hiddenIndex) {
                builder.append(".. ");
            } else {
                builder.append(progression[i]).append(" ");
            }
        }

        return builder.toString();
    }
}
