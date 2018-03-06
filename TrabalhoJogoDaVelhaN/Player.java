package model;

public abstract class Player implements Playable{
  public Player(Tabuleiro tabuleiro) {};
  public enum Side{
    O,X;
    
    char getChar(Side side) {
      switch(side) {
      case O:
        return 'O';
      case X:
        return 'X';
      }
      return ' ';
    }
  };
  Side side;
  public void setSide(Player.Side aSide) {
    this.side = aSide;
  }
}
