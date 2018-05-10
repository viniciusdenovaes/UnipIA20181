package main;

import java.util.ArrayList;

import model.Aluno;
import model.Integrante;
import model.Professor;

public class Teste {
  
  public static void main(String[] args) {
    
    Aluno a1 = new Aluno(1);
    Aluno a2 = new Aluno(2);
    Professor p1 = new Professor(3, 20);
    Professor p2 = new Professor(4, 20);
    
    ArrayList<Integrante> grupoDeIntegrantes = new ArrayList<>();
    grupoDeIntegrantes.add(a1);
    grupoDeIntegrantes.add(a2);
    grupoDeIntegrantes.add(p1);
    grupoDeIntegrantes.add(p2);
    
    for(Integrante pessoa : grupoDeIntegrantes) {
      pessoa.print();
    }
    
  }
  
}
