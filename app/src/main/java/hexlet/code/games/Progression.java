package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";
    private static final int PROGRESSION_MIN_LENGTH = 5;
    private static final int PROGRESSION_MAX_LENGTH = 10;
    private static final int MAX_STEP = 10;
    private static final int MAX_START = 20;

    public static void startGame() {
        String[][] roundsData = generateRoundsData();
        Engine.startGame(RULES, roundsData);
    }

    private static String[][] generateRoundsData() {
        Random random = new Random();
        String[][] roundsData = new String[Engine.ROUNDS_AMOUNT][2];

        for (int i = 0; i < roundsData.length; i++) {
            int length = PROGRESSION_MIN_LENGTH + random.nextInt(PROGRESSION_MAX_LENGTH - PROGRESSION_MIN_LENGTH + 1);
            int step = 1 + random.nextInt(MAX_STEP);
            int start = random.nextInt(MAX_START);
            int hiddenIndex = random.nextInt(length);

            String[] progression = generateProgression(start, step, length);
            String answer = progression[hiddenIndex];

            progression[hiddenIndex] = "..";
            String question = String.join(" ", progression);

            roundsData[i][0] = question;
            roundsData[i][1] = answer;
        }

        return roundsData;
    }

    private static String[] generateProgression(int start, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = Integer.toString(start + i * step);
        }
        return progression;
    }
}