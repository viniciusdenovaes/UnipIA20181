package model;

public class TabuleiroFoto {
  public static int n;
  public char[][] t;
  
  public TabuleiroFoto(int aN) {
    TabuleiroFoto.n = aN;
    this.t = new char[TabuleiroFoto.n][TabuleiroFoto.n];
    for(int i=0; i<TabuleiroFoto.n; ++i)
      for(int j=0; j<TabuleiroFoto.n; ++j)
        this.t[i][j] = '_';
  }
  public TabuleiroFoto(int aN, char[][] photo) {
    TabuleiroFoto.n = aN;
    this.t = new char[TabuleiroFoto.n][TabuleiroFoto.n];
    for(int i=0; i<TabuleiroFoto.n; ++i)
      for(int j=0; j<TabuleiroFoto.n; ++j)
        this.t[i][j] = photo[i][j];
  }
  public TabuleiroFoto(Tabuleiro tabuleiro) {
    TabuleiroFoto.n = Tabuleiro.n;
    this.t = new char[TabuleiroFoto.n][TabuleiroFoto.n];
    for(int i=0; i<TabuleiroFoto.n; ++i)
      for(int j=0; j<TabuleiroFoto.n; ++j)
        this.t[i][j] = tabuleiro.t[i][j];
  }
}
