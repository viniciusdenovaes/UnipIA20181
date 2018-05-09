package view;

import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ControlePanel extends JPanel{
  
  JButton botaoProximaJogada;
  
  public ControlePanel() {
    this.botaoProximaJogada = new JButton("Próxima Jogada");
    this.add(botaoProximaJogada);
  }
  public void setBotao(ActionListener proximaJogadaListener) {
    this.botaoProximaJogada.addActionListener(proximaJogadaListener);
  }

}
