package model;

public abstract class Player implements Playable{
  public Player(int aN, TabuleiroFoto aTabuleiroFoto) {
  };
  public enum Side{
    O,X;
    
    static char getChar(Side side) {
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
  public char getSide() {
    return Player.Side.getChar(this.side);
  }
  public char getOtherSide() {
    return Player.Side.getChar(
           Player.Side.values()[ (this.side.ordinal()+1) % Player.Side.values().length ]);
  }
  void setSide(Player.Side aSide) {
    this.side = aSide;
  }
}
