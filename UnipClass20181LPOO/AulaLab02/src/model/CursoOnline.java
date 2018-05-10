package model;

public class CursoOnline extends Curso{

  public CursoOnline(int aId) {
    super(aId);
  }
  
  @Override
  public void printHorario() {
    System.out.println("O aluno escolhe a hora, uma vez por semana");
  }

}
