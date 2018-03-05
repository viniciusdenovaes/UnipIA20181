package controller;

import model.Acoes;
import model.EspacoDeEstado;
import model.Estado;
import model.Instance;
import model.Solution;
import model.Tabuleiro;
import view.View8P;

public class Controller {
  
  View8P view;
  Instance inst = new Instance();
  Tabuleiro tabuleiroInicial = new Tabuleiro(inst.readInstance());
  Estado estadoInicial = new Estado(tabuleiroInicial);
  Tabuleiro tabuleiroObjetivo = new Tabuleiro(inst.readObjetivo());
  Estado estadoObjetivo = new Estado(tabuleiroObjetivo);
  EspacoDeEstado espacoDeEstado = new EspacoDeEstado(estadoInicial, estadoObjetivo);
  Solution sol;
  public Controller(){
    
    sol = new Solution();
    sol = espacoDeEstado.solve();
    this.view = new View8P(tabuleiroInicial, sol);
  }

}
