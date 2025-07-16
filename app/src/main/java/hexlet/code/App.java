package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        System.out.println("Your choice: ");
        int choice  = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            Cli.greetUser();
        } else if (choice == 2) {
            System.out.print("May I have your name? ");
            String name = scanner.nextLine();
            EvenGame.startGame(scanner, name);
        } else if (choice == 0) {
            System.out.println("Goodbye!");
        }
    }
}
