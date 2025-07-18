package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class CalculatorGame {
    private static final String RULES = "What is the result of the expression?";
    private static final char[] OPERATORS = {'+', '-', '*'};

    public static void startGame() {
        String[][] roundsData = new String[Engine.ROUNDS_AMOUNT][2];
        Random random = new Random();

        for (int i = 0; i < roundsData.length; i++) {
            int randomNumber1 = random.nextInt(100) + 1;
            int randomNumber2 = random.nextInt(100) + 1;
            char operator = OPERATORS[random.nextInt(OPERATORS.length)];

            String question = randomNumber1 + " " + operator + " " + randomNumber2;
            String answer = Integer.toString(calculate(randomNumber1, randomNumber2, operator));

            roundsData[i][0] = question;
            roundsData[i][1] = answer;
        }

        Engine.startGame(RULES, roundsData);
    }
    private static int calculate(int a, int b, char operator) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            default -> {
                System.out.println("Error");
                yield 0;
            }
        };
    }
}
