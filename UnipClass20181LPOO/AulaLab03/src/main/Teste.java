package main;

import java.util.ArrayList;

import model.Aluno;
import model.Integrante;
import model.Professor;
import model.ProfessorDeEnsinoMedio;
import model.ProfessorUniversitario;

public class Teste {
  
  public static void main(String[] args) {
    
    ProfessorDeEnsinoMedio p1 = new ProfessorDeEnsinoMedio(1, 20);
    ProfessorDeEnsinoMedio p2 = new ProfessorDeEnsinoMedio(2, 20);
    ProfessorUniversitario p3 = new ProfessorUniversitario(3, 20);
    
    ArrayList<Professor> grupoDeProfessores = new ArrayList<>();
    grupoDeProfessores.add(p1);
    grupoDeProfessores.add(p2);
    grupoDeProfessores.add(p3);
    
    for(Professor p : grupoDeProfessores) {
      p.listaDeCurso();
    }
    
  }
  
}
