package model;

class Tabuleiro {
  
  private TabuleiroFoto tabuleiroFoto;
  
  Tabuleiro(){
    this(new TabuleiroFoto());
  }
  Tabuleiro(TabuleiroFoto aTabuleiroFoto){
    tabuleiroFoto = new TabuleiroFoto(aTabuleiroFoto);
  }
  
  TabuleiroFoto getTabuleiroFoto() {
    return this.tabuleiroFoto.deepCopy();
  }
  void setTabuleiroFoto(char[][] aFoto) {
    this.tabuleiroFoto.setFoto(aFoto);
  }
  void setPeca(char peca, int x, int y) {
    this.tabuleiroFoto.setPeca(peca, x, y);
  }
  void setPeca(char peca, Casa casa) {
    this.setPeca(peca, casa.getX(), casa.getY());
  }
  
  // return Jogada to ok, null to notOk
  Jogada move(Jogada jogada, char side) {
    Casa casaOrigem  = jogada.getOrigem();
    Casa casaDestino = jogada.getDestino();
    System.out.println("Jogada Origem: " + casaOrigem);
    System.out.println("Jogada destino: " + casaDestino);
    System.out.println("Peca na origem: " + this.tabuleiroFoto.getPeca(casaOrigem));
    char pecaOrigem = this.tabuleiroFoto.getPeca(casaOrigem);
    
    if(jogada.getQuantidadeDeMovimentos()<2) {
      String erro = ("ERRO: quantidade de movimentos eh menor que dois");
      System.out.println(erro);
      return null;
    }

    // controle de erro
    if(!(Peca.isSameSide(side, pecaOrigem))) {
      String erro = "ERRO: tentou jogar com peca errada";
      System.out.println(erro);
      return null;
    }
    if( this.tabuleiroFoto.getPeca(casaDestino) != '_' ) {
      String erro = "ERRO: casa de destino é diferente de vazia";
      System.out.println(erro);
      return null;
    }
    // Assume que é diagonal
    boolean isDiagonal = true;
    // Assume que é diagonal, a distancia será a do taxi/2, 
    // pq a distX será igual distY
    int dist = Math.abs(casaDestino.getX() - casaOrigem.getX()); 
    if(   (    Math.abs(casaDestino.getX() - casaOrigem.getX()) 
            != Math.abs(casaDestino.getY() - casaOrigem.getY()))
        ||
          (dist == 0))
      isDiagonal = false;
    if(!isDiagonal) {
      String erro = ("ERRO: Tabuleiro::move nao eh diagonal\n"
                   + "      Ou nao sai do lugar");
      System.out.println(erro);
      return null;
    }
    
    int avancoEmX = 1;
    if(casaDestino.getX() - casaOrigem.getX() < 0) avancoEmX = -1;
    int avancoEmY = 1;
    if(casaDestino.getY() - casaOrigem.getY() < 0) avancoEmY = -1;
    
    // se a peca não é rei e não capturou ninguém
    if(!Peca.isKing(pecaOrigem)) {
      if(dist==1) {
        if(Peca.direcao(side)!=avancoEmY) {
          String erro = "ERRO: peca se move na direcao errada";
          System.out.println(erro);
          return null;
        }
      }
      else if(dist==2) {
        Casa casaCapturada = Casa.div(Casa.add(casaOrigem, casaDestino), 2);
        if(!Peca.isSameSide(Peca.otherSide(side), 
                            this.tabuleiroFoto.getPeca(casaCapturada))) {
          String erro = "ERRO: Tentou capturar peça do mesmo lado ou vazio";
          System.out.println(erro);
          return null;
        }
      }
      else {
        String erro = "ERRO: pulou mais de duas casas";
        System.out.println(erro);
        return null;
      }
    }
    
    for(int i=0; i<dist; i++) {
      Casa casa = new Casa(casaOrigem.getX() + i*avancoEmX, 
                           casaOrigem.getY() + i*avancoEmY);
      this.setPeca('_', casa);
    }
    
    //virou rei
    if(!Peca.isKing(pecaOrigem)) {
      if(  (Peca.direcao(side)== 1 && jogada.getDestino().getY()==TabuleiroFoto.SIZE-1)
        || (Peca.direcao(side)==-1 && jogada.getDestino().getY()==0)){
          pecaOrigem = Peca.viraRei(pecaOrigem);
      }
    }
    
    this.setPeca(pecaOrigem, jogada.getDestino());
    
    return jogada.tiraOrigem();
  }
  
  // '_' para ainda não terminou
  char checkGanhador() {
    if(this.tabuleiroFoto.getCount('D')==0)
      return 'L';
    if(this.tabuleiroFoto.getCount('L')==0)
      return 'D';
    
    return '_';
  }
  
  @Override public String toString() {
    return this.tabuleiroFoto.toString();
  }
  
}
