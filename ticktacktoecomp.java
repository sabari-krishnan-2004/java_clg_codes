import java.util.Scanner;

public class ticktacktoecomp {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    private static boolean isGameOver = false;

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        
        while (!isGameOver) {
            if (currentPlayer == 'X') {
                userMove();
            } else {
                computerMove();
            }
            printBoard();
            checkWinner();
            switchPlayer();
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void userMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your move (row and column):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
            System.out.println("Invalid move! Try again.");
            userMove();
        } else {
            board[row][col] = 'X';
        }
    }

    private static void computerMove() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                    return;
                }
            }
        }
    }

    private static void checkWinner() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                System.out.println(board[i][0] + " wins!");
                isGameOver = true;
                return;
            }
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                System.out.println(board[0][i] + " wins!");
                isGameOver = true;
                return;
            }
        }

        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            System.out.println(board[0][0] + " wins!");
            isGameOver = true;
            return;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            System.out.println(board[0][2] + " wins!");
            isGameOver = true;
            return;
        }

        // Check for a tie
        boolean isTie = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isTie = false;
                    break;
                }
            }
            if (!isTie) {
                break;
            }
        }
        if (isTie) {
            System.out.println("It's a tie!");
            isGameOver = true;
        }
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
