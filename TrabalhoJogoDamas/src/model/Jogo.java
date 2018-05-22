package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View;

public class Jogo {
  
  private static final int LIMITE_DE_JOGADAS = 4000;
  
  Player[] p;
  Tabuleiro tabuleiro;
  int numeroDaJogada = 0;
  int contadorJogadorDaVez = 0;
  Player jogadorDaVez;
  
  View view;
  
  public Jogo(Player p1, Player p2, View aView) {
    this.view = aView;
    setPlayers(p1, p2);
    resetJogo();
    resetView();
  }
  public Jogo(Player p1, Player p2) {
    this(p1, p2, new View());
  }
  
  private void setPlayers(Player p1, Player p2) {
    this.p = new Player[2];
    p[0] = p1;
    p[1] = p2;
    p[0].setSide('L');
    p[1].setSide('D');
  }
  private void resetJogo() {
    this.tabuleiro = new Tabuleiro();
    
    this.numeroDaJogada = 0;
    this.contadorJogadorDaVez = 0;
  }
  
  public void setTabuleiro(TabuleiroFoto aTabuleiroFoto) {
    this.tabuleiro = new Tabuleiro(aTabuleiroFoto);
  }
  
  private void resetView() {
    view = new View(this.tabuleiro.getTabuleiroFoto());
    this.view.setBotao(new ProximaJogadaListener());
  } 
  
  public void comeca() {
    System.out.println("Iniciando o jogo:");
    System.out.println(this.tabuleiro);
    resetView();
    this.jogadorDaVez = getJogadorDaVez();
    this.numeroDaJogada = 0;
  }
  
  public char proximaJogada() {
    System.out.println("fazendo proxima jogada");
    if(this.numeroDaJogada++<Jogo.LIMITE_DE_JOGADAS) {
      char ganhador;
      Jogada valida = fazProximaJogada();
      if(valida==null) {
        trocaJogadorDaVez();
        System.out.println("ganhador: " + this.jogadorDaVez.getSide());
        return this.jogadorDaVez.getSide();
      }
      ganhador = this.tabuleiro.checkGanhador();
      if(ganhador!='_') {
        return ganhador;
      }
      trocaJogadorDaVez();
    }
    if(this.numeroDaJogada>=Jogo.LIMITE_DE_JOGADAS) {
      return '_';
    }
    return ' ';
  }
  
  public Jogada fazProximaJogada() {
    
    System.out.println("jogador " + contadorJogadorDaVez);

    Player jogador = this.jogadorDaVez;
    char side = jogador.getSide();
    Jogada jogada = jogador.joga(this.tabuleiro.getTabuleiroFoto());
    if(jogada==null) {
      return null;
    }
    if(jogada.getQuantidadeDeMovimentos()<2)
      terminaJogo(Peca.otherSide(side));
    //Jogada jogadaOriginal = jogada.deepCopy();
    this.view.addMensagem("Jogada do side " + side +": "+jogada);
    //System.out.println(jogada);
    while(jogada!=null&&jogada.getQuantidadeDeMovimentos()>=2) {
      jogada = this.tabuleiro.move(jogada, side);
      System.out.println(this.tabuleiro);
      this.view.updateTabuleiro(this.tabuleiro.getTabuleiroFoto());
      
      // Esperar um segundo enquanto não implemento o botão
//      try {TimeUnit.SECONDS.sleep(1);} 
//      catch (InterruptedException e) {e.printStackTrace();}  
      if(jogada==null)
        return jogada;
    }
    return jogada;
  }
  
  public void acionaProximaJogada(int n) {
    char ganhador = ' ';
    for(int i=0; i<n; i++) {
      ganhador = this.proximaJogada();
      if(ganhador != ' ')
        break;
    }
    if(ganhador!=' ') {
      terminaJogo(ganhador);
    }
  }
  
  private void terminaJogo(char ganhador) {
    this.view.terminaJogo(ganhador);
  }
  
  private Player getJogadorDaVez() {
    return this.p[contadorJogadorDaVez%2];
  }
  private void trocaJogadorDaVez() {
    this.contadorJogadorDaVez = (this.contadorJogadorDaVez+1)%2;
    this.jogadorDaVez = getJogadorDaVez();
  }
  
  class ProximaJogadaListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand()=="Próxima Jogada")acionaProximaJogada(1);
      if(e.getActionCommand()=="5 jogadas")acionaProximaJogada(5);
      if(e.getActionCommand()=="10 jogadas")acionaProximaJogada(10);
    }
    
  }

}
