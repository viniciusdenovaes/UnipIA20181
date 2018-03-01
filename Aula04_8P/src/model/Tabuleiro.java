package model;

/*
 * @author vinicius
 *
 * Classe para representar um tabuleiro de 8-Puzzle
 * O tabuleiro sera representado por uma matriz 3x3
 * O cada numero representa ele proprio e o 0 representa o espaco vazio
 *
 */

public class Tabuleiro {
  
  Tabuleiro(){}
  
  // Contructor para criar um Tabuleiro a partir de outro
  Tabuleiro(Tabuleiro aTabuleiro){
    for(int i=0; i<Tabuleiro.n; ++i)
      for(int j=0; j<Tabuleiro.n; ++j)
        this.t[i][j] = aTabuleiro.t[i][j];
    this.vazioColuna = aTabuleiro.vazioColuna;
    this.vazioLinha = aTabuleiro.vazioLinha;
  }
  
  static final int n = 3;
  public int[][] t = new int[n][n];
  
  // Posicao do vazio
  int vazioLinha = -1;
  int vazioColuna = -1;
  
  // Procura onde esta o zero para guardar a posicao dele
  public void resetEspacoPosicao() {
    for(int i=0; i<Tabuleiro.n; ++i) {
      for(int j=0; j<Tabuleiro.n; ++j) {
        if(this.t[i][j] == 0) {
          this.vazioLinha = i;
          this.vazioColuna = j;
        }
      }
    }
  }
  
  // Verifica se um movimento eh valido
  public boolean valido(Acoes acao) {
    switch(acao) {
      case CIMA:
        if(this.vazioLinha > 0)
          return true;
        break;
      case DIREITA:
        if(this.vazioColuna < Tabuleiro.n - 1)
          return true;
        break;
      case BAIXO:
        if(this.vazioLinha < Tabuleiro.n - 1)
          return true;
        break;
      case ESQUERDA:
        if(this.vazioColuna < 0)
          return true;
        break;
      default:
        System.out.println("ERRO EM TABULEIRO.VALIDO NENHUMA ACAO NO SWITCH");
        System.exit(0);
    }
    return false;
  }
  
  // Cria um novo tabuleiro e retorna como o filho deste
  public Tabuleiro geraFilho(Acoes acao) {
    if(!this.valido(acao)) {
      System.out.println("ERRO EM TABULEIRO.GERAFILHO ACAO INVALIDA");
      return null;
    }
    Tabuleiro newTabuleiro = new Tabuleiro(this);
    switch(acao) {
      case CIMA:
        newTabuleiro.moveEspaco(newTabuleiro.vazioLinha - 1, newTabuleiro.vazioColuna);
        break;
      case DIREITA:
        newTabuleiro.moveEspaco(newTabuleiro.vazioLinha, newTabuleiro.vazioColuna + 1);
        break;
      case BAIXO:
        newTabuleiro.moveEspaco(newTabuleiro.vazioLinha + 1, newTabuleiro.vazioColuna);
        break;
      case ESQUERDA:
        newTabuleiro.moveEspaco(newTabuleiro.vazioLinha, newTabuleiro.vazioColuna - 1);
        break;
      default:
        System.out.println("ERRO EM TABULEIRO.GERAFILHO NENHUMA ACAO NO SWITCH");
        System.exit(0);
    }
    return newTabuleiro;
  }
  
  // funcao para trocar uma peca de lugar com o espaco vazio
  private void moveEspaco(int newvazioLinha, int newvazioColuna) {
    this.t[this.vazioLinha][this.vazioLinha] = this.t[newvazioLinha][newvazioLinha];
    this.t[newvazioLinha][newvazioLinha] = 0;
    this.vazioLinha = newvazioLinha;
    this.vazioColuna = newvazioColuna;
  }

}



