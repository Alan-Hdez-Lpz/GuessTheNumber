import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        boolean playAgain = false;
        Scanner sc = new Scanner(System.in);
        do {
            int randomNumber = 0;
            System.out.println("Welcome to Guess the Number! ");
            boolean validation;
            do {
                System.out.print("Do you want to set the range for the random number? (Y/N): ");
                String answer = sc.next();
                if (answer.equalsIgnoreCase("Y")) {
                    System.out.println("Enter the minimum number: ");
                    int min = sc.nextInt();
                    int max;
                    do {
                        System.out.println("Enter the maximum number: ");
                        max = sc.nextInt();
                        if (max < min) {
                            System.out.println("You have entered less than the minimum number!");
                        }
                    } while (min > max);
                    randomNumber = rand.nextInt(max - min) + min;
                    validation = true;
                } else if (answer.equalsIgnoreCase("N")) {
                    randomNumber = rand.nextInt(500);
                    validation = true;
                } else {
                    System.out.println("You have entered an invalid option!");
                    validation = false;
                }
                if (validation) {
                    int count = 0;
                    boolean win = false;
                    do {
                        System.out.println("You have 5 attempts to guess the number!");
                        System.out.println("Enter a number: ");
                        int guessedNumber = sc.nextInt();
                        count++;
                        if (guessedNumber == randomNumber) {
                            count = 5;
                            win = true;
                        } else if (guessedNumber > randomNumber) {
                            System.out.println("The number is too high! Enter a lower number, attempt " + count + "/5.");
                        } else {
                            System.out.println("The number is too low! Enter a higher number, attempt " + count + "/5.");
                        }
                    } while (count < 5);
                    if (win) {
                        System.out.println("Congratulations!! You guessed the number!");
                    } else {
                        System.out.println("Game over!! You didn't guess the number!");
                    }
                }
            } while (!validation);
            boolean answerPlayAgainValidation;
            do {
                System.out.print("Do you want to play again? (Y/N): ");
                String answerPlayAgain = sc.next();
                if (answerPlayAgain.equalsIgnoreCase("Y")) {
                    playAgain = true;
                    answerPlayAgainValidation = false;
                } else if (answerPlayAgain.equalsIgnoreCase("N")) {
                    playAgain = false;
                    answerPlayAgainValidation = false;
                } else {
                    System.out.println("You have entered an invalid option!");
                    answerPlayAgainValidation = true;
                }
            } while (answerPlayAgainValidation);
        } while (playAgain);
    }
}
