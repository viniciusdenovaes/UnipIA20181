package model;

/**
 * 
 * @author vinicius
 * 
 * Classe para representar um Espaco de Estados
 * 
 * Por enquanto esta classe tera: 
 * * Um conjunto de Estados
 * * Uma busca no espaco de estados
 * * Um estado inicial pre determinado
 * * Estados objetivos pre determinados
 * 
 * Devera encontrar uma solucao
 * * caminho do estado inicial a algum estado do Objetivo
 */


public class EspacoDeEstado {
  Estado estadoInicial;
  Estado estadoObjetivo;
  public EspacoDeEstado(Estado aEstadoInitial, Estado aEstadoObjetivo){
    this.estadoInicial  = aEstadoInitial;
    this.estadoObjetivo = aEstadoObjetivo;
  }
  
  public Solution solve() {
    Solution sol = new Solution();
    BuscaNoEspacoDeEstado busca = new BuscaNoEspacoDeEstado();
    sol = busca.fazerBusca(estadoInicial, estadoObjetivo);
    
    return sol;
  }

}
