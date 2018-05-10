package model;

public class ProfessorDeEnsinoMedio extends Professor{

  public ProfessorDeEnsinoMedio(int id, int salario) {
    super(id,salario);
  }
  
  void listaDeCurso() {
    System.out.println("quase todos do ensino medio");
  }
  
  boolean podeDarOCurso(String c) {
    return true;
  }
  void escolheOLivro(String livro, String curso) {
    
  }
  String defineAEmenta(String ementa) {
    return "";
  }
  boolean foiAprovado(Aluno aluno, String curso) {
    return true;
  }
  
  @Override
  public void print() {
    super.print();
    System.out.println("Especialização: professor de ensino médio");
  }

  
}
