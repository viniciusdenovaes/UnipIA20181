package Model;

import java.util.ArrayList;

import model.Jogada;
import model.Player;
import model.TabuleiroFoto;

public class JogadorProfessor extends Player{
  
  HeuristicaDeAvaliacao heuristicaDeAvaliacao;

  public JogadorProfessor(int aN, TabuleiroFoto aTabuleiroFoto) {
    super(aN, aTabuleiroFoto);
  }

  @Override
  public Jogada joga(TabuleiroFoto foto) {
//    setSide('X');
//    char[][] tabuleiro = {
//        {' ', 'X', 'X', 'X'}, 
//        {' ', 'O', 'O', 'O'}, 
//        {' ', 'O', 'O', ' '}, 
//        {' ', ' ', ' ', ' '} 
//    };
//    TabuleiroFoto tf = new TabuleiroFoto(4, tabuleiro);
    
    
    ArrayList<Estado> filhos = geraFilhos(foto);
//    for(Estado filho : filhos) {
//      System.out.println(filho);
//    }
    
    int indiceFilhoMelhor = -1;
    long maiorAvaliacao = Long.MIN_VALUE;
    for(int i=0; i<filhos.size(); ++i) {
      if(maiorAvaliacao<filhos.get(i).avaliacao) {
        maiorAvaliacao = filhos.get(i).avaliacao;
        indiceFilhoMelhor = i;
      }
    }
    
    return filhos.get(indiceFilhoMelhor).jogadaQueGerou;
  }
  
  ArrayList<Estado> geraFilhos(TabuleiroFoto foto){
    HeuristicaDeAvaliacao heuristicaDeAvaliacao = new HeuristicaDeAvaliacao(this.getSide());
    ArrayList<Estado> filhos = new ArrayList<>();
    for(int i=0; i<foto.t.length; ++i) {
      for(int j=0; j<foto.t.length; ++j) {
        if(foto.t[i][j]=='_') {
          TabuleiroFoto novoFotoFilho = new TabuleiroFoto(foto);
          novoFotoFilho.t[i][j] = this.getSide();
          filhos.add(new Estado(novoFotoFilho, 
                                new Jogada(i,j), 
                                heuristicaDeAvaliacao.avalia(novoFotoFilho)));
        }
      }
    }
    
    return filhos;
  }
  
//  void testaFilhos(TabuleiroFoto foto) {
//    
//    setSide('X');
//    
//    ArrayList<Estado> filhos = geraFilhos(foto);
//    for(Estado filho : filhos) {
//      System.out.println(filho);
//    }
//  }
//    
//  
//  void testaHeuristicaDeAvaliacao(TabuleiroFoto foto) {
//    
//    setSide('X');
//    
//    heuristicaDeAvaliacao = new HeuristicaDeAvaliacao(this.getSide());
//    
//    TabuleiroFoto tf = new TabuleiroFoto(4);
//    System.out.println(tf);
//    
//    System.out.println("avalia " + heuristicaDeAvaliacao.avalia(tf));
//    
//    char[][] tabuleiro = {
//        {' ', 'X', 'X', 'X'}, 
//        {' ', ' ', ' ', ' '}, 
//        {' ', ' ', ' ', ' '}, 
//        {' ', ' ', ' ', ' '} 
//    };
//    
//    tf = new TabuleiroFoto(4, tabuleiro);
//    System.out.println(tf);
//    
//    System.out.println("avalia " + heuristicaDeAvaliacao.avalia(tf));
//    
//    char[][] tabuleiro2 = {
//        {'X', 'X', 'X', 'X'}, 
//        {' ', ' ', ' ', ' '}, 
//        {' ', ' ', ' ', ' '}, 
//        {' ', ' ', ' ', ' '} 
//    };
//    
//    tf = new TabuleiroFoto(4, tabuleiro2);
//    System.out.println(tf);
//    
//    System.out.println("avalia " + heuristicaDeAvaliacao.avalia(tf));
//    
//    char[][] tabuleiro3 = {
//        {'O', 'O', 'O', 'O'}, 
//        {' ', ' ', ' ', ' '}, 
//        {' ', ' ', ' ', ' '}, 
//        {' ', ' ', ' ', ' '} 
//    };
//    
//    tf = new TabuleiroFoto(4, tabuleiro3);
//    System.out.println(tf);
//    
//    System.out.println("avalia " + heuristicaDeAvaliacao.avalia(tf));
//    
//    tf = new TabuleiroFoto(4, tabuleiro2);
//    System.out.println(tf);
//    
//    System.out.println("avalia " + heuristicaDeAvaliacao.avalia(tf));
//    
//    char[][] tabuleiro4 = {
//        {'O', 'O', 'O', ' '}, 
//        {' ', ' ', 'X', 'O'}, 
//        {' ', 'X', 'X', 'O'}, 
//        {' ', ' ', ' ', ' '} 
//    };
//    
//    tf = new TabuleiroFoto(4, tabuleiro4);
//    System.out.println(tf);
//    
//    System.out.println("avalia " + heuristicaDeAvaliacao.avalia(tf));
//    
//  }
//  
  

}
