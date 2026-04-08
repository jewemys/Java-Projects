import java.util.Scanner;

public class Game {
    boolean isPlayerXturn;
    int moveCount;
    Board board;
    Scanner scanner;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
        isPlayerXturn = true;
        moveCount = 0;
    }

    void startGame() {
        while (true) {
            board.printBoard();
            makePlayerMove();

            if (board.winCheck()) { // Checking at each turn if there is a winner
                board.printBoard();
                System.out.println("Player " + (isPlayerXturn ? 'O' : 'X') + " wins. Good job.");
                break;
            }

            if (moveCount >= 9) {
                board.printBoard();
                System.out.println("It's a draw. Try harder both of you.");
                break;
            }
        }
    }

    char getPlayerInput() {
        char currentPlayer = (isPlayerXturn ? 'X' : 'O');
        System.out.println("Player: " + currentPlayer + ", Please pick a number available on the grid. (0-8)\n");
        while (true) {
            String input = scanner.nextLine();

            // Checking length first to see if anything has been entered
            if (input.length() == 0) {
                System.out.println("You must enter in a value (0-8)");
                continue;
            }

            // Grabs the first index of the input String we allowed the user to place in
            char userChar = input.charAt(0);

            if (userChar < '0' || userChar > '8') {
                System.out.println("Invalid input, try again, psst try and enter a number between 0-8\n");
                continue;
            }; // if user enters empty string we keep asking for a string
            return userChar;
        }
    }

    void makePlayerMove(){
        char currentPlayer = isPlayerXturn ? 'X' : 'O';
        char playerMove;

        while (true) {
            playerMove = getPlayerInput(); // Asking user for input

            if (board.validateMove(playerMove)) {
                board.placeMove(playerMove, currentPlayer);
                moveCount++;
                switchTurn();
                break;
            } else {
                System.out.println("That spot is taken! Try again.");
            }
        }
    }

    void switchTurn() {
        isPlayerXturn = !isPlayerXturn; // Flips the turn to the other player
    }


}
