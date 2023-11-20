import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Rock, Paper, Scissors!");

        while (true) {
            System.out.print("Enter your move (Rock, Paper, Scissors) or type 'exit' to end: ");
            String playerMove = scanner.nextLine().toLowerCase();

            if (playerMove.equals("exit")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }

            if (isValidMove(playerMove)) {
                String computerMove = generateComputerMove();
                System.out.println("Computer's move: " + computerMove);

                String result = determineWinner(playerMove, computerMove);
                System.out.println(result);
            } else {
                System.out.println("Invalid move. Please enter Rock, Paper, or Scissors.");
            }
        }

        scanner.close();
    }

    private static boolean isValidMove(String move) {
        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
    }

    private static String generateComputerMove() {
        int random = (int) (Math.random() * 3);

        switch (random) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            case 2:
                return "Scissors";
            default:
                return ""; 
        }
    }

    private static String determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove.toLowerCase())) {
            return "It's a tie!";
        } else if ((playerMove.equals("rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("scissors") && computerMove.equals("Paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}
