package test.flipkart.aditya.tictactoe.phase3.players;

import test.flipkart.aditya.tictactoe.phase3.gameMechanics.Runner;
import test.flipkart.aditya.tictactoe.phase3.hexBoards.Board;
import java.util.ArrayList;

public abstract class AbstractPlayer implements Player {

  protected ArrayList<Board> auxBoards = new ArrayList<Board>();
  protected Runner game;
  protected int player;
  protected int opponent;
  protected int size;

  public AbstractPlayer(Runner game, int colour, String[] args) {
    this.game = game;
    this.player = colour;
    if (this.player == Board.RED)
      this.opponent = Board.BLUE;
    else
      this.opponent = Board.RED;
    this.size = game.getBoard().getSize();
  }

  public ArrayList<Board> getAuxBoards() {
    return auxBoards;
  }
}
