import java.util.Scanner;
public class TicTacToe {
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
 printBoard(board);
 char currentPlayer = 'X';
 boolean gameWon = false;
 while (!gameWon) {
 System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2) separated by space:");
 int row = scanner.nextInt();
 int col = scanner.nextInt();
 if (isValidMove(board, row, col)) {
 board[row][col] = currentPlayer;
 printBoard(board);
 gameWon = checkWin(board, currentPlayer);
 if (!gameWon) {
 currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
 }
 } else {
 System.out.println("Invalid move. Try again.");
 }
 }
 System.out.println("Player " + currentPlayer + " wins!");
 scanner.close();
 }
 private static boolean isValidMove(char[][] board, int row, int col) {
 return (row >= 0 && row < 3 && col >= 0 && col < 3 && 
board[row][col] == ' ');
 }
 private static void printBoard(char[][] board) {
 System.out.println("-------------");
 for (int i = 0; i < 3; i++) {
 System.out.print("| ");
 for (int j = 0; j < 3; j++) {
 System.out.print(board[i][j] + " | ");
 }
 System.out.println("\n-------------");
 }
 }
 private static boolean checkWin(char[][] board, char player) {
 // Check rows, columns, and diagonals for a win
 for (int i = 0; i < 3; i++) {
 if ((board[i][0] == player && board[i][1] == player && 
board[i][2] == player) ||
 (board[0][i] == player && board[1][i] == player && 
board[2][i] == player)) {
 return true;
 }
 }
 if ((board[0][0] == player && board[1][1] == player && 
board[2][2] == player) ||
 (board[0][2] == player && board[1][1] == player && 
board[2][0] == player)) {
 return true;
 }
 return false;
 }
}