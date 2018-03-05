package model;

import java.util.ArrayList;

public class Solution {
  public ArrayList<String> acoes;
  public Solution(){
    this.acoes = new ArrayList<>();
  }
  
  @Override public String toString() {
    if(acoes.isEmpty()) return "Solucao esta vazia\n";
    String res = " ";
    for(String acao:this.acoes) 
      res += acao;
    return res;
  }
}
