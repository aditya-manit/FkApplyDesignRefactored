package test.flipkart.aditya.tictactoe.phase1;

import java.util.Scanner;
/**
 * The main class for the Tic-Tac-Toe (Console-OO, non-graphics version)
 * It acts as the overall controller of the game.
 */
public class GameMain {


    public static final int ROWS =3 ;
    public static final int COLS =3 ;
    private Board board;            // the game board
    private Enumerations.GameState currentState; // the current state of the game (of enum GameState)
    private Enumerations.Seed currentPlayer;     // the current player (of enum Seed)

    private static Scanner in = new Scanner(System.in);  // input Scanner

    /** Constructor to setup the game */
    public GameMain() {
        board = new Board();  // allocate game-board

        // Initialize the game-board and current status
        initGame();
        // Play the game once. Players CROSS and NOUGHT move alternately.
        do {
            playerMove(currentPlayer); // update the content, currentRow and currentCol
            board.paint();             // ask the board to paint itself
            updateGame(currentPlayer); // update currentState
            // Print message if game-over
            if (currentState == Enumerations.GameState.CROSS_WON) {
                System.out.println("'X' won! Bye!");
            } else if (currentState == Enumerations.GameState.NOUGHT_WON) {
                System.out.println("'O' won! Bye!");
            } else if (currentState == Enumerations.GameState.DRAW) {
                System.out.println("It's Draw! Bye!");
            }
            // Switch player
            currentPlayer = (currentPlayer == Enumerations.Seed.CROSS) ? Enumerations.Seed.NOUGHT : Enumerations.Seed.CROSS;
        } while (currentState == Enumerations.GameState.PLAYING);  // repeat until game-over
    }

    /** Initialize the game-board contents and the current states */
    public void initGame() {
        board.init();  // clear the board contents
        currentPlayer = Enumerations.Seed.CROSS;       // CROSS plays first
        currentState = Enumerations.GameState.PLAYING; // ready to play
    }

    /** The player with "theSeed" makes one move, with input validation.
     Update Cell's content, Board's currentRow and currentCol. */
    public void playerMove(Enumerations.Seed theSeed) {
        boolean validInput = false;  // for validating input
        do {
            if (theSeed == Enumerations.Seed.CROSS) {
                System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
            } else {
                System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
            }
            int row = in.nextInt() - 1;
            int col = in.nextInt() - 1;
            if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
                    && board.cells[row][col].content == Enumerations.Seed.EMPTY) {
                board.cells[row][col].content = theSeed;
                board.currentRow = row;
                board.currentCol = col;
                validInput = true; // input okay, exit loop
            } else {
                System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                        + ") is not valid. Try again...");
            }
        } while (!validInput);   // repeat until input is valid
    }

    /** Update the currentState after the player with "theSeed" has moved */
    public void updateGame(Enumerations.Seed theSeed) {
        if (board.hasWon(theSeed)) {  // check for win
            currentState = (theSeed == Enumerations.Seed.CROSS) ? Enumerations.GameState.CROSS_WON : Enumerations.GameState.NOUGHT_WON;
        } else if (board.isDraw()) {  // check for draw
            currentState = Enumerations.GameState.DRAW;
        }
        // Otherwise, no change to current state (still GameState.PLAYING).
    }

    /** The entry main() method */
    public static void main(String[] args) {
        new GameMain();  // Let the constructor do the job
    }
}