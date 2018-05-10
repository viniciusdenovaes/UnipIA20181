package model;

public class Funcionario extends Integrante{
  
  private int salario;
  
  public Funcionario(int id, int aSalario) {
    super(id);
    setSalario(aSalario);
  }
  
  public int getSalario() {
    return salario;
  }

  public void setSalario(int salario) {
    this.salario = salario;
  }

  public void print() {
    super.print();
    System.out.println("salario: " + salario);
  }
  

}
