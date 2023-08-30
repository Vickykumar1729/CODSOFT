import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 7;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Game!");

        while (true) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

            int attempts = 0;
            boolean roundWon = false;

            System.out.println("\nNew Round!");
            System.out.println("Guess the number between " + minRange + " and " + maxRange);

            while (attempts < maxAttempts) {
                int attemptsLeft = maxAttempts - attempts; 
                System.out.println("You have " + attemptsLeft + " attempts left.");

                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please enter a valid number within the range.");
                } else if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                    roundWon = true;
                    roundsWon++;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!roundWon) {
                System.out.println("Round over! The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play Again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Game Over!");
        System.out.println("Rounds Won: " + roundsWon);
        scanner.close();
    }
}
