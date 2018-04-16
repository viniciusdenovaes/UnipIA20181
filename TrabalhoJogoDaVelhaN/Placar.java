package model;

public class Placar {
  
  static final int TAM_MAX = 11;
//  private static final int VITORIA = 0;
//  private static final int DERROTA = 1;
  private static final int  EMPATE = 2;
  
  private    int[][][]   quantidadeDeJogos      = new    int[2][2]   [TAM_MAX];
  private    int[][][][] quantidadeDeResultados = new    int[2][2][3][TAM_MAX];
  private double[][][][] ratioDeResultados      = new double[2][2][3][TAM_MAX];
  private double[][][]   mediaDosRatios         = new double[2][2][3];
  
  public Placar() {
  }
  
  public void ganhou(int ganhador, char side, int tamanhoDoTabuleiro) {
    atualizaPlacar(ganhador, side, tamanhoDoTabuleiro, false);
  }
  public void empatou(int ganhador, char side, int tamanhoDoTabuleiro) {
    atualizaPlacar(ganhador, side, tamanhoDoTabuleiro, true);
  }
  
  private void atualizaPlacar(int ganhador, 
                             char side, 
                              int tamanhoDoTabuleiro, 
                          boolean velha){
    
    int sideGanhador = Player.Side.getInt(Player.Side.valueOf(""+side));
    
    for(int i=0; i<2; ++i) 
      quantidadeDeJogos[(ganhador+i)%2]
                       [(sideGanhador+i)%2]
                       [tamanhoDoTabuleiro]++;
    
    for(int resultado=0; resultado<3; resultado++) {
      if(velha && resultado==EMPATE) {
        for(int i=0; i<2; i++) {
          quantidadeDeResultados[(ganhador+i)%2]
                                [(sideGanhador+i)%2]
                                [EMPATE]
                                [tamanhoDoTabuleiro]++;
        }
      }
      else if(!velha && resultado!=EMPATE) {
        quantidadeDeResultados[(ganhador+resultado)%2]
                              [(sideGanhador+resultado)%2]
                              [resultado]
                              [tamanhoDoTabuleiro]++;
      }
    }
    
    for(int resultado=0; resultado<3; resultado++) {
      for(int i=0; i<2; i++) {
        ratioDeResultados[(ganhador+i)%2]
                         [(sideGanhador+i)%2]
                         [resultado]
                         [tamanhoDoTabuleiro] = 
                           (double)
                           quantidadeDeResultados[(ganhador+i)%2]
                                                 [(sideGanhador+i)%2]
                                                 [resultado]
                                                 [tamanhoDoTabuleiro]/
                           (double)
                           quantidadeDeJogos     [(ganhador+i)%2]
                                                 [(sideGanhador+i)%2]
                                                 [tamanhoDoTabuleiro];
      }
    }
  }
  
  public void print() {
    atualizaMedia();
    System.out.print("|tamanhoDoTabuleiro:|");
    for(int coluna=4; coluna<TAM_MAX; ++coluna) {
      System.out.print(String.format(" %2d  ",coluna)+"|");
    }
    System.out.print("media");
    System.out.println();
    for(int jogador=0; jogador<2; ++jogador) {
      for(int side=0; side<2; ++side) {
        for(int resultado=0; resultado<3; ++resultado) {
          System.out.print("jogador"+(jogador+1)+"|");
          System.out.print(" "+Player.Side.getChar(
                               Player.Side.getSide(side))+" ");
          if(resultado==0)System.out.print("|ganhou |");
          if(resultado==1)System.out.print("|perdeu |");
          if(resultado==2)System.out.print("|empatou|");
          for(int coluna=4; coluna<TAM_MAX; ++coluna) {
            System.out.print(
                String.format("%5.3f",  
                    ratioDeResultados[jogador][side][resultado][coluna])
                +"|");
          }
          System.out.print(
              String.format("%5.3f",  
                            mediaDosRatios[jogador][side][resultado])
              +" ");
          System.out.println();
        }
        System.out.println("--------------------------------------------------");
      }
    }
    System.out.println();
    for(int i=0; i<2; ++i) {
      double nota=0;
      for(int j=0; j<2; j++)
        nota += Math.min(mediaDosRatios[i][j][0]/0.8, 1.0);
      nota/=2.0;
      nota*=3.0;
      nota+=3.0;
      System.out.println("nota do jogador "+i+": " + nota);
    }
  }
  
  private void atualizaMedia() {
    for(int resultado=0; resultado<3; resultado++) {
      for(int i=0; i<2; i++) {
        for(int j=0; j<2; j++) {
          mediaDosRatios[i][j][resultado] = 0;
          int quantidadeDeJogosTotal = 0;
          for(int tamanhoDoTabuleiro=0; 
                  tamanhoDoTabuleiro<Placar.TAM_MAX; 
                  tamanhoDoTabuleiro++) {
            mediaDosRatios[i][j][resultado] += 
                        ratioDeResultados[i][j][resultado][tamanhoDoTabuleiro]*
                (double)quantidadeDeJogos[i][j]           [tamanhoDoTabuleiro];
            quantidadeDeJogosTotal += 
                (double)quantidadeDeJogos[i][j][tamanhoDoTabuleiro];
            
          }
          mediaDosRatios[i][j][resultado] /= (double)quantidadeDeJogosTotal;
        }
      }
    }
    
  }
  

}
