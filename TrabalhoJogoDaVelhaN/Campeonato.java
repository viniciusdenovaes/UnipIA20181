package model;

public class Campeonato {
  
  public static void play(Player p1, Player p2) {
    Placar placar = new Placar();
    for(int i=0; i<100; i++)
      for(int tamanhoDoTabuleiro=4; 
              tamanhoDoTabuleiro<Placar.TAM_MAX; 
              tamanhoDoTabuleiro++) {
        char sideGanhador = Partida.play(p1, p2, tamanhoDoTabuleiro);
        if(sideGanhador == '_')
          placar.empatou(0, 'O', tamanhoDoTabuleiro);
        else if(sideGanhador == 'O')
          placar.ganhou(0, 'O', tamanhoDoTabuleiro);
        else if(sideGanhador == 'X')
          placar.ganhou(1, 'X', tamanhoDoTabuleiro);
        sideGanhador = Partida.play(p2, p1, tamanhoDoTabuleiro);
        if(sideGanhador == '_')
          placar.empatou(1, 'O', tamanhoDoTabuleiro);
        else if(sideGanhador == 'O')
          placar.ganhou(1, 'O', tamanhoDoTabuleiro);
        else if(sideGanhador == 'X')
          placar.ganhou(0, 'X', tamanhoDoTabuleiro);
      }
    placar.print();
  }

}
