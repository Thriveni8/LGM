import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    static String[] board;
    static String turn;

    // CheckWinner method will
    // decide the combination
    // of three box given below.
    static String checkWinner() {
        for (int b = 0; b < 8; b++) {
            String lin = null;

            switch (b) {
                case 0:
                    lin = board[0] + board[1] + board[2];
                    break;
                case 1:
                    lin = board[3] + board[4] + board[5];
                    break;
                case 2:
                    lin = board[6] + board[7] + board[8];
                    break;
                case 3:
                    lin = board[0] + board[3] + board[6];
                    break;
                case 4:
                    lin = board[1] + board[4] + board[7];
                    break;
                case 5:
                    lin = board[2] + board[5] + board[8];
                    break;
                case 6:
                    lin = board[0] + board[4] + board[8];
                    break;
                case 7:
                    lin = board[2] + board[4] + board[6];
                    break;
            }
            // For X winner
            if (lin.equals("XXX")) {
                return "X";
            }

            // For O winner
            else if (lin.equals("OOO")) {
                return "O";
            }
        }

        for (int b = 0; b < 9; b++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(b + 1))) {
                break;
            } else if (b == 8) {
                return "draw";
            }
        }

        // To enter the X Or O at the exact place on board.
        System.out.println(
                turn + "'s turn; enter a slot number to place "
                        + turn + " in:");
        return null;
    }

    // To print out the board.
    /*
     * |---|---|---|
     * | 1 | 2 | 3 |
     * |-----------|
     * | 4 | 5 | 6 |
     * |-----------|
     * | 7 | 8 | 9 |
     * |---|---|---|
     */

    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();

        System.out.println(
                "X will play first. Enter a slot number to place X in:");

        while (winner == null) {
            int numInput;

            // Exception handling.
            // numInput will take input from user like from 1 to 9.
            // If it is not in range from 1 to 9.
            // then it will show you an error "Invalid input."
            try {
                numInput = in.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println(
                            "Invalid input; re-enter slot number:");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println(
                        "Invalid input; re-enter slot number:");
                continue;
            }

            // This game has two player x and O.
            // Here is the logic to decide the turn.
            if (board[numInput - 1].equals(
                    String.valueOf(numInput))) {
                board[numInput - 1] = turn;

                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }

                printBoard();
                winner = checkWinner();
            } else {
                System.out.println(
                        "Slot already taken; re-enter slot number:");
            }
        }

        // If no one win or lose from both player x and O.
        // then here is the logic to print "draw".
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                    "It's a draw! Thanks for playing.");
        }

        // For winner -to display Congratulations! message.
        else {
            System.out.println(
                    "Congratulations! " + winner
                            + "'s have won! Thanks for playing.");
        }
        in.close();
    }
}