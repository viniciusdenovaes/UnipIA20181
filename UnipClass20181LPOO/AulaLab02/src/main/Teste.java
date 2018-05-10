package main;

import java.util.ArrayList;

import model.Curso;
import model.CursoDeVerao;
import model.CursoOnline;

public class Teste {
  
  public static void main(String[] args) {
    
    CursoDeVerao v1 = new CursoDeVerao(1);
    CursoDeVerao v2 = new CursoDeVerao(2);
    CursoOnline o1 = new CursoOnline(3);
    CursoOnline o2 = new CursoOnline(4);
    
    ArrayList<Curso> cursos = new ArrayList<>();
    cursos.add(v1);
    cursos.add(v2);
    cursos.add(o1);
    cursos.add(o2);
    
    for(Curso c : cursos) {
      c.printHorario();
    }
    
  }
  
}
