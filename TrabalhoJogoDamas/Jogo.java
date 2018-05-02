package model;

import java.util.concurrent.TimeUnit;

public class Jogo {
  
  Player[] p;
  Tabuleiro tabuleiro;
  int numeroDaJogada = 0;
  int jogadorDaVez = 0;
  
  public Jogo(Player p1, Player p2) {
    
    this.p = new Player[2];
    p[0] = p1;
    p[1] = p2;
    p[0].setSide('L');
    p[1].setSide('D');
    
    this.tabuleiro = new Tabuleiro();
    
    this.numeroDaJogada = 0;
    this.jogadorDaVez = 0;
  }
  
  public void setTabuleiro(TabuleiroFoto aTabuleiroFoto) {
    this.tabuleiro = new Tabuleiro(aTabuleiroFoto);
  }
  
  public void comeca() {
    System.out.println("Iniciando o jogo:");
    System.out.println(this.tabuleiro);
    int i=0;
    while(++i<100) {
      proximaJogada();
    }
  }
  
  public void proximaJogada() {
    
    System.out.println("jogador " + jogadorDaVez);
    Player jogador = this.p[jogadorDaVez%2];
    char side = jogador.getSide();
    Jogada jogada = jogador.joga(this.tabuleiro.getTabuleiroFoto());
    System.out.println(jogada);
    while(jogada!=null&&jogada.getQuantidadeDeMovimentos()>=2) {
      jogada = this.tabuleiro.move(jogada, side);
      System.out.println(this.tabuleiro);
      
      // Esperar um segundo enquanto não implemento o botão
      try {TimeUnit.SECONDS.sleep(1);} 
      catch (InterruptedException e) {e.printStackTrace();}    
    }
    jogadorDaVez = (jogadorDaVez+1)%2;
  }

}
