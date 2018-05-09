package view;

import java.awt.Color;

import javax.swing.*;

@SuppressWarnings("serial")
public class PlacarPanel extends JPanel{
  
  private JLabel placar;
  private String placarText;
  private int pontoP1=0;
  private int pontoP2=0;
  
  public PlacarPanel(Color bgColor) {
    this.placar = new JLabel();
    setPlacar(0, 0);
    this.setBackground(bgColor);
  }
  public void setPlacarPanel(int pP1, int pP2) {
    setPlacar(pP1, pP2);
  }
  private void setPlacar(int pP1, int pP2) {
    this.pontoP1 = pP1;
    this.pontoP2 = pP2;
    updatePlacar();
  }
  private void updatePlacar() {
    this.placarText = pontoP1+" X "+ pontoP2;
    this.placar.setText(this.placarText);
  }

}
