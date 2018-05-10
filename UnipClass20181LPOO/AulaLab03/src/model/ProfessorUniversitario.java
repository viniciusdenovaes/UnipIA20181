package model;

public class ProfessorUniversitario extends Professor{
  
  public ProfessorUniversitario(int id, int salario) {
    super(id,salario);
  }
  
  void listaDeCurso() {
    System.out.println("quase todos da faculdade");
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
    System.out.println("Categoria: professor de universidade");
  }

}
