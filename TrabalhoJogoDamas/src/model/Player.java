package model;

public abstract class Player {
  
  public Player(TabuleiroFoto aTabuleiroFoto) {}
  
  // D para dark, 
  // L para light, 
  private char side;
  
  public abstract Jogada joga(TabuleiroFoto aTabuleiroFoto);
  
  public void setSide(char aSide) {
    this.side = aSide;
  }
  public char getSide() {
    return this.side;
  }
  
}
