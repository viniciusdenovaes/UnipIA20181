package model;

public class Jogada {
  public int x,y;
  public Jogada(int aX, int aY) {
    this.x = aX;
    this.y = aY;
  }
  
  @Override public String toString() {
    String res = "";
    res += "jogada "+this.x+","+this.y;
    return res;
  }

}
