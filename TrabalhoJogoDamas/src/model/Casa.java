package model;

public class Casa {
  private int x,y;
  public Casa(int aX, int aY){
    if(this.verifyForaDoTabuleiro()) {
      System.out.println("WARNING: criada casa fora do tabuleiro");
    }
    this.x = aX;
    this.y = aY;
  }
  public Casa(Casa aCasa){
    this(aCasa.getX(), aCasa.getY());
  }
  
  public int getX() {return this.x;}
  public int getY() {return this.y;}
  
  public boolean verifyForaDoTabuleiro() {
    if(
        this.getX()<0||
        this.getY()<0||
        this.getX()>=TabuleiroFoto.SIZE||
        this.getY()>=TabuleiroFoto.SIZE
        ) {
      return true;
    }
    return false;
  }
  
  @Override public String toString() {
    String res="";
    res+="("+this.getX()+","+this.getY()+")";
    return res;
  }
  public Casa deepCopy() {
    return new Casa(this.getX(), this.getY());
  }
  
  //operacoes
  public static Casa add(Casa casa1, Casa casa2) {
    return new Casa(casa1.getX() + casa2.getX(), casa1.getY()+casa2.getY());
  }
  public static Casa div(Casa casa, int div) {
    return new Casa(casa.getX()/div, casa.getY()/div);
  }
  
}
