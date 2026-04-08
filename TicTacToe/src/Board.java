public class Board {
    char[][] board = {
            {'0', '1', '2'},
            {'3', '4', '5'},
            {'6', '7', '8'}};

    void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println("| " +
                    board[i][0] + " | " +
                    board[i][1] + " | " +
                    board[i][2] + " | "
            );
        }
    }

    boolean winCheck() {
        if // Row checks first
        (board[0][0] == board[0][1] && board[0][0] == board[0][2] ||
                board[1][0] == board[1][1] && board[1][0] == board[1][2] ||
                board[2][0] == board[2][1] && board[2][0] == board[2][2] ||
                // Column checks second
                board[0][0] == board[1][0] && board[0][0] == board[2][0] ||
                board[0][1] == board[1][1] && board[0][1] == board[2][1] ||
                board[0][2] == board[1][2] && board[0][2] == board[2][2] ||
                // Diagonal checks third
                board[0][0] == board[1][1] && board[0][0] == board[2][2] ||
                board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
            return true;
        }
        return false;
    }
}