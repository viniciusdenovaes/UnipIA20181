package model;

import java.util.ArrayList;

/**
 * 
 * @author vinicius
 * 
 * Classe para representar um Estado do Espaco de Estados
 * Por enquanto cada estado tera: 
 * * Tabuleiro
 * * TALVEZ informacoes sobre o pai dele (para auxiliar na busca pela solucao)
 * * Uma funcao para gerar novos estados filhos
 */

public class Estado {
  
  public Estado(Tabuleiro aTabuleiro){
    this.tabuleiro = new Tabuleiro(aTabuleiro);
  }
  
  
  Tabuleiro tabuleiro;
  Estado pai;
  String acaoQueGerou = null;
  
  // Gera um vetor de filhos
  public ArrayList<Estado> geraFilhos() {
    ArrayList<Estado> filhos = new ArrayList<>();
    for(Acoes acao : Acoes.values()) {
      if(this.tabuleiro.valido(acao)) {
        Estado estado = new Estado(this.tabuleiro.geraFilho(acao));
        estado.pai = this;
        estado.acaoQueGerou = acao.getString(acao);
        filhos.add(estado);
      }
    }
    return filhos;
  }
  
  @Override public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!Estado.class.isAssignableFrom(obj.getClass())) {
      return false;
    }
    final Estado other = (Estado) obj;
    return this.tabuleiro.equals(other.tabuleiro);
  }
  
  @Override public String toString() {
    String res = "\nEstado: \n";
    res += this.tabuleiro;
    if(this.acaoQueGerou!=null) res += "acao gerada: \n" + this.acaoQueGerou;
    else res += "acao gerada nula";
    return res+"\n";
  }

}



