package model;

import java.util.ArrayList;

/**
 * 
 * @author vinicius
 * 
 * Classe para representar uma busca no do Espaco de Estados
 * Por enquanto cada estado tera:
 * * Um espaco de Estados 
 * * Uma funcao que faca uma busca no Espaco de Estados
 */



public class BuscaNoEspacoDeEstado {
  
  public BuscaNoEspacoDeEstado() {}
  ArrayList<Estado> aberto;
  ArrayList<Estado> fechado;
  
  public Solution fazerBusca(Estado estadoInicial, Estado estadoObjetivo) {
    aberto = new ArrayList<>();
    fechado = new ArrayList<>();
    Estado estadoEncontrado = null;
    aberto.add(estadoInicial);
    int tamanhoDoFechado = fechado.size();
    while( !aberto.isEmpty() ) {
      Estado x = aberto.get(0);
      aberto.remove(0);
      if(x.equals(estadoObjetivo)) {
        System.out.println("estado encontrado: \n" + x);
        estadoEncontrado = x;
        break;
      }
      else {
        //System.out.println("estado nao encontrado: gerando filhos de " + x);
        ArrayList<Estado> filhosDeX = x.geraFilhos();
        fechado.add(x);
        for(Estado filho : filhosDeX) {
          if(!aberto.contains(filho) && !fechado.contains(filho)) {
            insereAberto(filho, 1);
          }
        }
        if(tamanhoDoFechado < fechado.size()) {
          tamanhoDoFechado = fechado.size();
          System.out.println("conjunto fechado tem " + fechado.size() + " elementos, "
                                    + " aberto tem " + aberto .size() + " elementos");
        }
      }
      
    }
    
    //fabrica a solução atraves do pai de cada estado e da acao que o gerou
    //como a solucao é fabricada seguindo o pai de cada um, o vetor de soluções fica invertido
    System.out.println("estado encontrado = "+estadoEncontrado);
    ArrayList<String> inversa = new ArrayList<>();
    while(estadoEncontrado.acaoQueGerou!=null && estadoEncontrado.pai!=null) {
      inversa.add(estadoEncontrado.acaoQueGerou);
      estadoEncontrado = estadoEncontrado.pai;
    }
    
    //desinvertendo o vetor de soluções
    Solution sol = new Solution();
    for(int i=inversa.size()-1; i>=0; i--)
      sol.acoes.add(inversa.get(i));
    
    return sol;
  }
  
  //modoDaBusca 1 para busca em largura, 2 para busca em profundidade
  private void insereAberto(Estado e, int modoDaBusca) {
    if(modoDaBusca==1) {
      aberto.add(e);
    }
    if(modoDaBusca==2) {
      aberto.add(0, e);
    }
  }
  
  

}











