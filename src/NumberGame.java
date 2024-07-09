import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain;

        do {
            playGame(sc);
            System.out.print("Do you want to play again? (Y/N): ");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("Y");
        } while (playAgain);

        System.out.println("Thanks for playing the Number Game!");
        sc.close();
    }

    public static void playGame(Scanner sc) {
        int chances = 8;
        int totalWins = 0;
        System.out.println("Welcome to the Number Game");
        System.out.println("You have " + chances + " chances to guess the number between 1 and 100");

        int rand = getRandomNumber(1, 100);
        boolean guessedCorrectly = false;

        for (int i = 0; i < chances; i++) {
            System.out.print("Chance " + (i + 1) + ": Guess the number: ");
            int guess = sc.nextInt();

            if (guess == rand) {
                System.out.println("You WIN!!");
                guessedCorrectly = true;
                totalWins++;
                break;
            } else if (guess < rand) {
                System.out.println("Try a larger number");
            } else {
                System.out.println("Try a smaller number");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you ran out of chances. The number was: " + rand);
        }

        System.out.println("Your total score: " + totalWins);
        System.out.println();
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}


