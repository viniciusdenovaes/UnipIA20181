package view;

import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ControlePanel extends JPanel{
  
  JButton botaoProximaJogada;
  
  ControlePanel() {
    this.botaoProximaJogada = new JButton("Próxima Jogada");
    this.add(botaoProximaJogada);
  }
  void setBotao(ActionListener proximaJogadaListener) {
    this.botaoProximaJogada.addActionListener(proximaJogadaListener);
  }
  
  void ligaBotao(boolean b) {
    this.botaoProximaJogada.setEnabled(b);
  }
  

}
