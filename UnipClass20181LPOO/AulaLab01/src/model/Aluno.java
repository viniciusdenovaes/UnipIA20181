package model;

public class Aluno extends Integrante{
  
  public Aluno(int id) {
    super(id);
  }
  
  @Override
  public void print() {
    super.print();
    System.out.println("Função: aluno");
  }

}
