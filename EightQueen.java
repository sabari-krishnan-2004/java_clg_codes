public class EightQueen {
    private static final int N = 8; // Number of Queens
    public static void main(String[] args) {
    int[][] board = new int[N][N];
    if (solveQueens(board, 0)) {
    printBoard(board);
    } else {
    System.out.println("No solution exists.");
    }
    }
    private static boolean solveQueens(int[][] board, int col) {
    if (col == N) {
    return true; // All queens are placed successfully
    }
    for (int i = 0; i < N; i++) {
    if (isSafe(board, i, col)) {
    board[i][col] = 1; // Place Queen
    if (solveQueens(board, col + 1)) {
    return true;
    }
    // If placing a queen in the current position does not lead to a solution, backtrack
    board[i][col] = 0;
    }
    }
    return false; // If no row is safe in this column
    }
    private static boolean isSafe(int[][] board, int row, int col) {
    // Check this row on the left side
    for (int i = 0; i < col; i++) {
    if (board[row][i] == 1) {
    return false;
    }
    }
    // Check upper diagonal on the left side
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
    if (board[i][j] == 1) {
    return false;
    }
    }
    // Check lower diagonal on the left side
    for (int i = row, j = col; i < N && j >= 0; i++, j--) {
    if (board[i][j] == 1) {
    return false;
    }
    }
    return true;
    }
    private static void printBoard(int[][] board) {
    for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
    System.out.print(board[i][j] + " ");
    }
    System.out.println();
    }
    }
   }
