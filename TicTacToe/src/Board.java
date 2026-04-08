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
        System.out.println("\n");
    }

    boolean winCheck() {
        if      // Row checks first
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

    boolean validateMove(char numInputChar) {
        // Working with char data type so use char data not direct integers
        if (numInputChar < '0' || numInputChar > '8') {
            return false; // INVALID MOVE
        }

        for (char[] row: board) {
            for (char cell: row) {
                if (cell == numInputChar) {
                    return true; // VALID MOVE
                }
            }
        }
        return false;
    }

    void placeMove(char numInputChar, char playerChar) {
        /* playerChar is either an 'X' or an 'O'
            and we convert our numInputChar into an integer for mathematical operations */
        int temp = numInputChar - '0';

        int row = temp / 3;
        int col = temp % 3;
        board[row][col] = playerChar; // Player inserts 'X' or 'O' (depends on player) inside the cell
    }
}