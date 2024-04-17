import java.util.Scanner;
public class SudokuGame {
 private static int[][] grid = new int[3][3];
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 initializeGrid();
 displayGrid();
 while (!isSudokuSolved()) {
 System.out.println("Enter row (1-3), column (1-3), and value (1-3):");
 int row = scanner.nextInt() - 1;
 int col = scanner.nextInt() - 1;
 int value = scanner.nextInt();
 if (isValidMove(row, col, value)) {
 grid[row][col] = value;
 displayGrid();
 } else {
 System.out.println("Invalid move! Try again.");
 }
 }
 System.out.println("Congratulations! You solved the Sudoku!");
 scanner.close();
 }
 private static void initializeGrid() {
 for (int i = 0; i < 3; i++) {
 for (int j = 0; j < 3; j++) {
 grid[i][j] = 0;
 }
 }
 }
 private static void displayGrid() {
 System.out.println("Sudoku Grid:");
 for (int i = 0; i < 3; i++) {
 for (int j = 0; j < 3; j++) {
 System.out.print(grid[i][j] + " ");
 }
 System.out.println();
 }
 System.out.println();
 }
 private static boolean isValidMove(int row, int col, int value) {
 for (int i = 0; i < 3; i++) {
 if (grid[row][i] == value || grid[i][col] == value) {
 return false;
 }
 }
 int startRow = row - row % 3;
 int startCol = col - col % 3;
 for (int i = 0; i < 3; i++) {
 for (int j = 0; j < 3; j++) {
 if (grid[i + startRow][j + startCol] == value) {
 return false;
 }
 }
 }
 return true;
 }
 private static boolean isSudokuSolved() {
 for (int i = 0; i < 3; i++) {
 for (int j = 0; j < 3; j++) {
 if (grid[i][j] == 0) {
 return false;
 }
 }
 }
 return true;
 }
}
