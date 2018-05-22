package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class ControlePanel extends JPanel{
  
  JButton botaoProximaJogada;
  JButton botaoCincoJogada;
  JButton botaoDezJogada;
  ArrayList<JButton> botoes;
  
  ControlePanel() {
    botoes = new ArrayList<>();
    this.botaoProximaJogada = new JButton("Próxima Jogada");
    this.botoes.add(botaoProximaJogada);
    this.botaoCincoJogada = new JButton("5 jogadas");
    this.botoes.add(botaoCincoJogada);
    this.botaoDezJogada = new JButton("10 jogadas");
    this.botoes.add(botaoDezJogada);
    for(JButton b : botoes) {
      this.add(b);
    }
  }
  void setBotao(ActionListener proximaJogadaListener) {
    for(JButton b : this.botoes) {
      b.addActionListener(proximaJogadaListener);
    }
  }
  
  void ligaBotao(boolean b) {
    for(JButton botao : this.botoes) {
      botao.setEnabled(b);
    }
  }
  

}
