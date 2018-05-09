package view;

import java.awt.event.ActionListener;

import model.TabuleiroFoto;

public class View {
  
  Janela janela;
  
  public View(){
    janela = new Janela();
  }
  public View(TabuleiroFoto tf){
    this();
    updateTabuleiro(tf);
  }
  public void updateTabuleiro(TabuleiroFoto tf) {
    this.janela.updateTabuleiro(tf);
  }
  public void addMensagem(String msg) {
    //janela.addMensagem(msg);
  }
  public void terminaJogo(char ganhador) {
    
  }
  public void recomecaJogo() {
    
  }
  public void setBotao(ActionListener proximaJogadaListener) {
    this.janela.setBotao(proximaJogadaListener);
  }
  
  

}
