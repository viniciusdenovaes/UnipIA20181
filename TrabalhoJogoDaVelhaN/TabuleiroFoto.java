package model;

public class TabuleiroFoto {
  public int n;
  public char[][] t;
  
  public TabuleiroFoto(int aN) {
    this.n = aN;
    this.t = new char[this.n][this.n];
    for(int i=0; i<this.n; ++i)
      for(int j=0; j<this.n; ++j)
        this.t[i][j] = '_';
  }
  public TabuleiroFoto(int aN, char[][] photo) {
    this.n = aN;
    this.t = new char[this.n][this.n];
    for(int i=0; i<this.n; ++i)
      for(int j=0; j<this.n; ++j)
        this.t[i][j] = photo[i][j];
  }
  public TabuleiroFoto(Tabuleiro tabuleiro) {
    this.n = Tabuleiro.n;
    this.t = new char[this.n][this.n];
    for(int i=0; i<this.n; ++i)
      for(int j=0; j<this.n; ++j)
        this.t[i][j] = tabuleiro.t[i][j];
  }
  public TabuleiroFoto(TabuleiroFoto foto) {
    this.n = foto.n;
    this.t = new char[this.n][this.n];
    for(int i=0; i<this.n; ++i)
      for(int j=0; j<this.n; ++j)
        this.t[i][j] = foto.t[i][j];
  }
  
  @Override public String toString() {
    String res = "" + this.n + "\n";
    for(int i=0; i<this.n; ++i) {
      res += "|";
      for(int j=0; j<this.n; ++j) {
        res += this.t[i][j] + "|";
      }
      res += "\n";
    }
    return res;
  }

  
}
