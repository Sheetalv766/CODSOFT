import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("***Welcome to the Number Guessing Game!***");
      
        int score = 0;

        String playAgainInput;
        do { // Optional: Ensure at least one guess (uncomment if desired)
            int target = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 3;

            System.out.println("I have selected a number between 1 and 100. " + "/n" + "Can you guess it?");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess : ");
                int guess = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                attempts++;

                if (guess == target) {
                    System.out.println("Congratulations! You guessed the number " + target + " in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (guess < target) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + target + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgainInput = scanner.nextLine();
        } while (playAgainInput.equalsIgnoreCase("y"));

        System.out.println("Game Over! Your score : " + score);
        scanner.close();
    }
}

