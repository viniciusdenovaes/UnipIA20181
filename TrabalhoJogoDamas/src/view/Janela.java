package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.TabuleiroFoto;

@SuppressWarnings("serial")
public class Janela extends JFrame{
  
  private TabuleiroPanel tabuleiroPanel;
  private ControlePanel controlePanel;
  //private PlacarPanel placarPanel;
  private MessagePanel messagePanel;
  
  private Color bgColor;
  
  public Janela() {
    super("Jogo de Damas");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.bgColor = new Color(0,150,0);
    
    this.setBackground(bgColor);
    
    tabuleiroPanel = new TabuleiroPanel();
    controlePanel = new ControlePanel();
    //placarPanel = new PlacarPanel(bgColor);
    messagePanel = new MessagePanel();
    
    addComponentsToPane(this.getContentPane());
    
    this.pack();
    this.setVisible(true);
  }
  
  public Janela(TabuleiroFoto tf) {
    this();
    this.updateTabuleiro(tf);
  }

  private void addComponentsToPane(Container pane) {
    pane.add(this.tabuleiroPanel, BorderLayout.CENTER);
    pane.add(this.controlePanel, BorderLayout.PAGE_END);
//    pane.add(this.placarPanel, BorderLayout.PAGE_START);
    pane.add(this.messagePanel, BorderLayout.LINE_END);
    
  }
  
  void updateTabuleiro(TabuleiroFoto tf) {
    this.tabuleiroPanel.updateTabuleiro(tf);
  }
  void addMensagem(String msg) {
    this.messagePanel.addMensagem(msg);
  }
  void setBotao(ActionListener proximaJogadaListener){
    this.controlePanel.setBotao(proximaJogadaListener);
  }
  void terminaJogo(char ganhador) {
    this.messagePanel.addMensagem("JOGADOR " + ganhador + " GANHOU!!!");
    this.controlePanel.ligaBotao(false);
  }
  
  

}
