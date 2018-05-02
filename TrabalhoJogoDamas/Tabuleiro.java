package model;

class Tabuleiro {
  
  private TabuleiroFoto tabuleiroFoto;
  
  Tabuleiro(){
    tabuleiroFoto = new TabuleiroFoto();
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
    
    // controle de erro
    if(!(pecaOrigem == side || (char)(pecaOrigem+1) == side)) {
      System.out.println("ERRO: tentou jogar com peca errada");
      System.exit(1);
      return null;
    }
    
    @SuppressWarnings("unused")
    int avanco;
    if(side == 'L')
      avanco = 1;
    else avanco = -1;
    
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
      System.out.println("ERRO: Tabuleiro::move nao eh diagonal");
      System.exit(1);
    }
    
    int avancoEmX = 1;
    if(casaDestino.getX() - casaOrigem.getX() < 0) avancoEmX = -1;
    int avancoEmY = 1;
    if(casaDestino.getY() - casaOrigem.getY() < 0) avancoEmY = -1;
    
    for(int i=0; i<dist; i++) {
      Casa casa = new Casa(casaOrigem.getX() + i*avancoEmX, 
                           casaOrigem.getY() + i*avancoEmY);
      this.setPeca('_', casa);
    }
    
    this.setPeca(pecaOrigem, jogada.getDestino());
    
    if(jogada.getQuantidadeDeMovimentos()<2)
      return null;
    else 
      return jogada.tiraOrigem();
  }
  
  @Override public String toString() {
    return this.tabuleiroFoto.toString();
  }
  
}
