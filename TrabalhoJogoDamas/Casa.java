package model;

public class Casa {
  private int x,y;
  Casa(int aX, int aY){
    if(
        aX<0||
        aY<0||
        aX>=TabuleiroFoto.SIZE||
        aY>=TabuleiroFoto.SIZE
        ) {
      System.out.println("ERRO: criada casa fora do tabuleiro");
      System.exit(1);
    }
    this.x = aX;
    this.y = aY;
  }
  Casa(Casa aCasa){
    this(aCasa.getX(), aCasa.getY());
  }
  
  public int getX() {return this.x;}
  public int getY() {return this.y;}
  
  @Override public String toString() {
    String res="";
    res+="("+this.getX()+","+this.getY()+")";
    return res;
  }
}
