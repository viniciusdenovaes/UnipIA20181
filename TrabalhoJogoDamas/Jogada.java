package model;

import java.util.ArrayList;

public class Jogada {
  
  private ArrayList<Casa> movimentos;
  
  public Jogada() {
    this.movimentos = new ArrayList<>();
  }
  public Jogada(int xOrigem, int yOrigem) {
    this();
    this.movimentos.add(new Casa(xOrigem, yOrigem));
  }
  public Jogada(int xOrigem, int yOrigem, int xDestino, int yDestino) {
    this(xOrigem, yOrigem);
    this.movimentos.add(new Casa(xDestino, yDestino));
  }
  public void add(Casa aCasa) {
    this.movimentos.add(aCasa);
  }
  public Casa getMovimento(int i){
    return this.movimentos.get(i);
  }
  public ArrayList<Casa> getTodosMovimentos(){
    return this.movimentos;
  }
  public int getQuantidadeDeMovimentos() {
    return movimentos.size();
  }
  
  public Casa getOrigem() {
    if(!(this.getQuantidadeDeMovimentos() > 1)) {
      System.out.println("Erro: Jogada::getOrigem(): jogadas vazio");
    }
    return new Casa(this.movimentos.get(0));
  }
  
  public Casa getDestino() {
    if(!(this.getQuantidadeDeMovimentos() > 1)) {
      System.out.println("Erro: Jogada::getDestino(): jogadas sem destino");
    }
    return new Casa(this.movimentos.get(1));
  }
  
  public Jogada tiraOrigem() {
    if(this.getQuantidadeDeMovimentos()<2) {
      return null;
    }
    
    Jogada jogadaSemOrigem = new Jogada();
    for(int i=1; i<this.getQuantidadeDeMovimentos(); ++i) {
      jogadaSemOrigem.add(this.getMovimento(i));
    }
    
    return jogadaSemOrigem;
  }
  
  @Override public String toString() {
    String res="";
    res+="Jogada = ";
    for(int i=0; i<this.getQuantidadeDeMovimentos(); i++) {
      res+=this.getMovimento(i).toString();
      res+=", ";
    }
    res+="\n";
    return res;
  }
  

}
