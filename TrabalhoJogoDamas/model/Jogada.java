package model;

import java.util.ArrayList;

public class Jogada {
  
  public ArrayList<Casa> movimentos;
  
  // constructors
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
  public Jogada(Casa casaOrigem) {
    this(casaOrigem.getX(), casaOrigem.getY());
  }
  public Jogada(Casa casaOrigem, Casa casaDestino) {
    this(casaOrigem.getX(), casaOrigem.getY(), casaDestino.getX(), casaDestino.getY());
  }
  
  // adiciona uma casa ao movimento
  public void add(Casa aCasa) {
    this.movimentos.add(aCasa);
  }
  // retorna o movimento na posição i
  public Casa getMovimento(int i){
    return this.movimentos.get(i);
  }
  // retorna um vetor com todos os movimentos
  public ArrayList<Casa> getTodosMovimentos(){
    return this.movimentos;
  }
  // retorna a quantidade de movimento (contando com a origem)
  public int getQuantidadeDeMovimentos() {
    return movimentos.size();
  }
  
  // retorna a casa origem do movimento
  public Casa getOrigem() {
    if(!(this.getQuantidadeDeMovimentos() > 1)) {
      System.out.println("Erro: Jogada::getOrigem(): jogadas vazio");
    }
    return new Casa(this.movimentos.get(0));
  }
  // retorna a casa destino do movimento (apenas uma, a primeira depois da origem)
  public Casa getDestino() {
    if(!(this.getQuantidadeDeMovimentos() > 1)) {
      System.out.println("Erro: Jogada::getDestino(): jogadas sem destino");
    }
    return new Casa(this.movimentos.get(1));
  }
  // retorna uma nova jogada sem a origem (util para saber todos os destinos)
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
  // faz o merge de uma nova jogada nesta jogada:
  //   pega todos os destinos da nova jogada e faz o merge
  //   *APENAS OS DESTINOS*
  public void append(Jogada novaJogada) {
    Jogada aJogadaSemOrigem = novaJogada.tiraOrigem();
    for(Casa casa:aJogadaSemOrigem.getTodosMovimentos())
      this.add(casa);
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
  // faz um clone de uma jogada
  public Jogada deepCopy() {
    Jogada clone = new Jogada();
    for(Casa casa : this.movimentos)
      clone.add(casa.deepCopy());
    return clone;
  }
  

}
