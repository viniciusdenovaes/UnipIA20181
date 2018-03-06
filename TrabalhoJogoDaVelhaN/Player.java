package model;

public abstract class Player implements Playable{
  public Player(int aN, TabuleiroFoto aTabuleiroFoto) {
  };
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
  void setSide(Player.Side aSide) {
    this.side = aSide;
  }
}
