public class Queens {
    private static final int SIZE = 8;
    private int[][] board;

    public Queens() {
        board = new int[SIZE][SIZE];
    }

    // Check if a queen can be placed at board[row][col]
    private boolean isSafe(int row, int col) {
        // Check this row on left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (int i = row, j = col; i < SIZE && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Method to place queens on the board
    public void placeQueens(int col) {
        if (col >= SIZE) {
            displayBoard(); // Display the solution
            System.out.println(); // Separate solutions
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1; // Place queen
                placeQueens(col + 1); // Recur to place rest of the queens
                board[i][col] = 0; // Backtrack: Remove queen
            }
        }
    }

    // Method to display the board
    public void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] == 1 ? " Q " : " . ");
            }
            System.out.println();
        }
    }

    // Other methods...
}
