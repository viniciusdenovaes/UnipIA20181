package model;

public class Professor extends Funcionario{
  
  public Professor(int id, int salario) {
    super(id,salario);
  }
  
  @Override
  public void print() {
    super.print();
    System.out.println("Função: professor");
  }

}
