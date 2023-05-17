import java.util.Scanner;

public class TicTacToe {
    public static String[] board;
    public static String turn;

    //Creates a 3 by 3 Tic-Tac-Toe board
    public static void createBoard() {
        board = new String[9];
        for (int i = 0; i < 9; i++) {
            board[i] = "-";
        }
        turn = "X";
    }
    
    //Prints the board
    public static void printBoard() {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    //Checks if a player has won the game if three of their signs appear in a horizontal, vertical, or diagonal row
    public static boolean checkWin() {
        if (board[0].equals(turn) && board[1].equals(turn) && board[2].equals(turn) ||
            board[3].equals(turn) && board[4].equals(turn) && board[5].equals(turn) ||
            board[6].equals(turn) && board[7].equals(turn) && board[8].equals(turn) ||
            board[0].equals(turn) && board[3].equals(turn) && board[6].equals(turn) ||
            board[1].equals(turn) && board[4].equals(turn) && board[7].equals(turn) ||
            board[2].equals(turn) && board[5].equals(turn) && board[8].equals(turn) ||
            board[0].equals(turn) && board[4].equals(turn) && board[8].equals(turn) ||
            board[2].equals(turn) && board[4].equals(turn) && board[6].equals(turn)) {
            return true;
        }
        return false;
    }

    //Checks for a tie
    public static boolean checkTie() {
        for (int i = 0; i < 9; i++) {
            if (board[i].equals("-")) {
                return false;
            }
        }
        return true;
    }

    //Simulates Tic-Tac-Toe
    public static void play() {
        Scanner scanner = new Scanner(System.in);
        int position;

        while (true) {
            System.out.println("Player " + turn + ", enter position (1-9): ");
            position = scanner.nextInt();

            //invalid cases
            if (position < 1 || position > 9) {
                System.out.println("Invalid position, try again.");
                continue;
            }
            if (!board[position - 1].equals("-")) {
                System.out.println("Position already taken, try again.");
                continue;
            }

            board[position - 1] = turn;
            printBoard();
            if (checkWin()) {
                System.out.println("Player " + turn + " wins!");
                break;
            }
            if (checkTie()) {
                System.out.println("Tie game!");
                break;
            }
            if (turn.equals("X")) {
                turn = "O";
            } else {
                turn = "X";
            }
        }

        scanner.close();
    }

    //Main method that creates the board and simulates Tic-Tac-Toe
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");
        createBoard();
        printBoard();
        play();

    }
}
