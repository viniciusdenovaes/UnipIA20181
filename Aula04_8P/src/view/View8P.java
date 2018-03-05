package view;

//import java.awt.Dimension;
//import java.awt.Graphics;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//

import model.*;

public class View8P{
  public View8P(Tabuleiro tabuleiro, Solution sol){
    printTabuleiro(tabuleiro);
    for(int i=0; i<sol.acoes.size(); ++i) {
      printAcao(Acoes.valueOf(sol.acoes.get(i)));
      tabuleiro = tabuleiro.geraFilho(Acoes.valueOf(sol.acoes.get(i)));
      printTabuleiro(tabuleiro);
    }
  }
  public void printTabuleiro(Tabuleiro tabuleiro) {
    System.out.println(tabuleiro);
  }
  
  public void printAcao(Acoes acao) {
    System.out.println(acao);
  }

}




//public class View8P extends JFrame{
//static final Dimension sizeFrame = new Dimension(400, 400);
//
//private static final long serialVersionUID = 1L;
//Dimension preferredSize = sizeFrame;
//TabuleiroPanel panel;
//
//public View8P(Tabuleiro tabuleiro, Solution sol){
//panel = new TabuleiroPanel(tabuleiro, sol); 
//add(panel);
//pack();
//}
//
//public void movePiece(Acoes dir) {
//this.panel.movePiece(dir);
//
//}
//
//
//
//
//private class TabuleiroPanel extends JPanel{
//Dimension pieceSize;
//Dimension boardSize;
//int[][] pieces;
//Tabuleiro tabuleiro;
//Solution sol;
//
//TabuleiroPanel(Tabuleiro tabuleiro, Solution sol){
//  setPreferredSize(sizeFrame);
//  this.boardSize = View8P.sizeFrame;
//  this.pieceSize = new Dimension(boardSize.width, boardSize.height);
//}
//
//@Override
//protected void paintComponent(Graphics g) {
//    super.paintComponent(g);
//    for(int i=0; i<)
//    g.d
//    
//}
//
//protected void movePiece(Acoes dir) {
//  
//}
//}

//}





