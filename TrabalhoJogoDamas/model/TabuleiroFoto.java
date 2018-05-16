package model;

/*
 * Um tabuleiro 10x10 de caracteres:
 * D para dark, 
 * E para Dama dark, (char)(D+1) 
 * L para light, 
 * M para Dama light, (char)(L+1)
 * _ para vazio
 * Com posições iniciando de baixo para cima, da esquerda para a direita
 * 
 *  (x,y)
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * |(0,9)|(1,9)|(2,9)|(3,9)|(4,9)|(5,9)|(6,9)|(7,9)|(8,9)|(9,9)|
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * |(0,8)|(1,8)|(2,8)|(3,8)|(4,8)|(5,8)|(6,8)|(7,8)|(8,8)|(9,8)|
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * |(0,7)|(1,7)|(2,7)|(3,7)|(4,7)|(5,7)|(6,7)|(7,7)|(8,7)|(9,7)|
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * |(0,6)|(1,6)|(2,6)|(3,6)|(4,6)|(5,6)|(6,6)|(7,6)|(8,6)|(9,6)|
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * |(0,5)|(1,5)|(2,5)|(3,5)|(4,5)|(5,5)|(6,5)|(7,5)|(8,5)|(9,5)|
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * |(0,4)|(1,4)|(2,4)|(3,4)|(4,4)|(5,4)|(6,4)|(7,4)|(8,4)|(9,4)|
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * |(0,3)|(1,3)|(2,3)|(3,3)|(4,3)|(5,3)|(6,3)|(7,3)|(8,3)|(9,3)|
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * |(0,2)|(1,2)|(2,2)|(3,2)|(4,2)|(5,2)|(6,2)|(7,2)|(8,2)|(9,2)|
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * |(0,1)|(1,1)|(2,1)|(3,1)|(4,1)|(5,1)|(6,1)|(7,1)|(8,1)|(9,1)|
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * |(0,0)|(1,0)|(2,0)|(3,0)|(4,0)|(5,0)|(6,0)|(7,0)|(8,0)|(9,0)|
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
 * 
 * As casa cujo a soma das coordenadas é par podem estar ocupadas por uma peça
 * Inicialmente:
 * As casas com coordenada y menor que 4 estão com peças do lado Light
 * As casas com coordenada y maior ou igual a 6 estão com peças do lado Dark
 * Quem começa é o lado Light
 * 
 * */

public class TabuleiroFoto {
  
  public final static int SIZE = 10;
  
  public char[][] foto;
  
  public TabuleiroFoto() {
    this.foto = new char[SIZE][SIZE];
    reset();
  }
  
  public TabuleiroFoto(TabuleiroFoto aTabuleiroFoto) {
    this.foto = new char[SIZE][SIZE];
    this.setFoto(aTabuleiroFoto.getFoto());
  }
  public TabuleiroFoto(char[][] aFoto) {
    this.foto = new char[SIZE][SIZE];
    this.setFoto(aFoto);
  }
  
  // Torna todos espaços vazios
  public void clean() {
    for(int x=0; x<TabuleiroFoto.SIZE; ++x) {
      for(int y=0; y<TabuleiroFoto.SIZE; ++y) {
        this.setPeca('_', x, y);
      }
    }
  }
  // Configura para o tabuleiro inicial
  public void reset() {
    clean();
    for(int x=0; x<TabuleiroFoto.SIZE; ++x) {
      for(int y=0; y<TabuleiroFoto.SIZE; ++y) {
        if((x+y)%2==0) {
          if(y<4)
            this.setPeca('L', x, y);
          else if(y>=6)
            this.setPeca('D', x, y);
        }
      }
    }
  }
  
  //getPeça retorna o char da peça que está na casa x y
  public char getPeca(int x, int y) {
    return this.foto[x][y];
  }
  public char getPeca(Casa aCasa) {
    return getPeca(aCasa.getX(), aCasa.getY());
  }
  public void setPeca(char peca, int x, int y) {
    this.foto[x][y] = peca;
  }
  public void setPeca(char peca, Casa casa) {
    setPeca(peca, casa.getX(), casa.getY());
  }
  
  public char[][] getFoto() {
    return this.foto;
  }
  
  public void setFoto(char[][] aFoto) {
    
    if(aFoto.length != SIZE) {
      System.out.println("ERROR (TabuleiroFoto::setFoto): "
                       + "tamanho da foto nao eh " + SIZE);
    }
    for(int i=0; i<aFoto.length; ++i) {
      if(aFoto[i].length != SIZE) {
        System.out.println("ERROR (TabuleiroFoto::setFoto): "
                         + "tamanho da foto nao eh " + SIZE);
      }
      for(int j=0; j<aFoto[i].length; ++j) {
        this.foto[i][j] = aFoto[i][j];
      }
    }
  }
  
  // retorna se a peça na casa x,y é do lado de side
  public boolean isPecaSide(int x, int y, char side) {
    char peca = this.getPeca(x, y);
    return Peca.isSameSide(side, peca);
  }
  // retorna se a peça da casa x,y é do outro lado de side
  public boolean isPecaOtherSide(int x, int y, char side) {
    char peca = this.getPeca(x, y);
    return Peca.isOtherSide(side, peca);
  }
  // retorna a quantidade de peças que tem do lado side
  public int getCount(char side) {
    int count = 0;
    for(int x=0; x<TabuleiroFoto.SIZE; x++)
      for(int y=0; y<TabuleiroFoto.SIZE; y++)
        if(isPecaSide(x, y, side))
          count++;
    return count;
  }
  
  // faz uma cópia do tabuleiro
  public TabuleiroFoto deepCopy() {
    TabuleiroFoto tabuleiroFotoClone = new TabuleiroFoto();
    tabuleiroFotoClone.setFoto(this.foto);
    return tabuleiroFotoClone;
  }
  
  @Override public String toString() {
    String res = "";
    String line = "+---+---+---+---+---+---+---+---+---+---+\n";
    res+=line;
    for(int y=9; y>=0; --y) {
      res+= "| ";
      for(int x=0; x<10; ++x) {
        char peca = this.getPeca(x, y);
        if(peca == '_') peca = ' ';
        res+= peca;
        res+= " | ";
      }
      res+="\n";
      res+=line;
    }
    res+="\n";
    return res;
  }

}
