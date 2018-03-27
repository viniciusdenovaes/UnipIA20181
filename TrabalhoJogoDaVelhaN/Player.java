package model;

public abstract class Player implements Playable{
  
  //O constructor recebe uma foto do tabuleiro com o tamanho
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
  
  // Define o lado do jogador, podendo ser 'O' ou 'X'
  public void setSide(Player.Side aSide) {
    this.side = aSide;
  }
  public void setSide(char aSide) {
    this.side = Player.Side.valueOf(String.valueOf(aSide));
  }
  
  // Side eh o simbolo do jogador, podendo ser o character 'O' ou 'X'
  public char getSide() {
    return Player.Side.getChar(this.side);
  }
  
  // getOtherSide eh o simbolo do oponente
  public char getOtherSide() {
    return Player.Side.getChar(
           Player.Side.values()[ (this.side.ordinal()+1) % Player.Side.values().length ]);
  }
}
