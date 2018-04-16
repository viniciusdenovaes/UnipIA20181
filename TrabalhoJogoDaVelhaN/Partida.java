package model;

public class Partida {
  
  public static char play(Player p1, Player p2, int tamanhoDoTabuleiro) {
    TabuleiroFoto tabuleiroFoto = new TabuleiroFoto(tamanhoDoTabuleiro);
    Tabuleiro tabuleiro = new Tabuleiro(tamanhoDoTabuleiro, tabuleiroFoto);
    
    Player players[] = new Player[2];
    players[0] = p1;
    players[1] = p2;
    players[0].setSide(Player.Side.O);
    players[1].setSide(Player.Side.X);
    
    char quemGanhou = '_';
    
    int numeroDaJogada = 0;
    while(!tabuleiro.isFull()) {
      Player.Side vez = players[numeroDaJogada%2].side;
      Jogada jogada = players[numeroDaJogada%2].joga(tabuleiroFoto);
      System.out.println("Jogada do " + vez + ": " + jogada);
      if(!tabuleiro.fazJogada(jogada, vez)) {
        System.out.println("side "+ players[numeroDaJogada%2].side + " ERROU A JOGADA");
        quemGanhou = Player.Side.getChar(players[ (numeroDaJogada+1)%2 ].side);
        return quemGanhou;
      }
      tabuleiroFoto = tabuleiro.foto();
      if(tabuleiro.ganhou(players[numeroDaJogada%2].side)) {
        System.out.println("side "+ players[numeroDaJogada%2].side + " ganhou");
        quemGanhou = Player.Side.getChar(players[ (numeroDaJogada)%2 ].side);
        System.out.println(tabuleiro);
        return quemGanhou;
      }
      System.out.println(tabuleiro);
      numeroDaJogada++;
    }
    if(quemGanhou=='_')System.out.println("EMPATE!");
    
    return '_';
  }

}
