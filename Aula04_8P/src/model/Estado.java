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
  
  Estado(Tabuleiro aTabuleiro){
    this.tabuleiro = new Tabuleiro(aTabuleiro);
  }
  
  Tabuleiro tabuleiro;
  Estado pai;
  Acoes acaoQueGerou;
  
  // Gera um vetor de filhos
  public ArrayList<Estado> geraFilhos() {
    ArrayList<Estado> filhos = new ArrayList<>();
    for(Acoes acao : Acoes.values()) {
      if(this.tabuleiro.valido(acao)) {
        Estado estado = new Estado(this.tabuleiro.geraFilho(acao));
        estado.pai = this;
        this.acaoQueGerou = acao;
        filhos.add(estado);
      }
    }
    return filhos;
  }

}



