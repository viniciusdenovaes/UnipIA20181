package view;

import java.awt.*;

import javax.swing.*;

import model.Peca;
import model.TabuleiroFoto;

@SuppressWarnings("serial")
public class TabuleiroPanel extends JPanel{
  
  TabuleiroFoto tabuleiroFoto;
  //Canvas tabuleiroCanvas;
  
  TabuleiroPanel(){
    this.tabuleiroFoto = new TabuleiroFoto();
    //tabuleiroCanvas = new Canvas();
    //tabuleiroCanvas.setPreferredSize(new Dimension(700,700));
    this.setPreferredSize(new Dimension(604,604));
    //this.add(tabuleiroCanvas);
  }
  
  void updateTabuleiro(TabuleiroFoto tf) {
    this.tabuleiroFoto = tf;
    repaint();
  }

  @Override 
  public void paint(Graphics g) {
    // Draw  checkerboard pattern in gray and lightGray.  Draw the
    // checkers.  If a game is in progress, hilite the legal moves.
  
  /* Draw a two-pixel black border around the edges of the canvas. */
  
    g.setColor(Color.black);
    g.drawRect(0,0,getSize().width-1,getSize().height-1);
    g.drawRect(1,1,getSize().width-3,getSize().height-3);
  
  /* Draw the squares of the checkerboard and the checkers. */
  
    for (int row = 0; row < TabuleiroFoto.SIZE; row++) {
      for (int col = 0; col < TabuleiroFoto.SIZE; col++) {
        if ( row % 2 == col % 2 )
          g.setColor(Color.lightGray);
        else
          g.setColor(Color.gray);
        g.fillRect(2 + col*60, 2 + row*60, 60, 60);
        switch (this.tabuleiroFoto.getPeca(col,TabuleiroFoto.SIZE-1-row)) {
          case Peca.RED:
            g.setColor(Color.red);
            g.fillOval(4 + col*60, 4 + row*60, 48, 48);
            break;
          case Peca.BLACK:
            g.setColor(Color.black);
            g.fillOval(4 + col*60, 4 + row*60, 48, 48);
            break;
          case Peca.RED_KING:
            g.setColor(Color.red);
            g.fillOval(4 + col*60, 4 + row*60, 48, 48);
            g.setColor(Color.white);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 42)); 
            g.drawString("K", 12 + col*60, 42 + row*60);
            break;
          case Peca.BLACK_KING:
            g.setColor(Color.black);
            g.fillOval(4 + col*60, 4 + row*60, 48, 48);
            g.setColor(Color.white);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 42)); 
            g.drawString("K", 12 + col*60, 42 + row*60);
            break;
        }
      }
    }
  }  // end paint()

}
