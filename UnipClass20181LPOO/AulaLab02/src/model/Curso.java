package model;

public class Curso {
  
  private int id;
  private String horario;
  
  public Curso(int aId) {
    this.setId(aId);
  }

  public int getId() {
    return id;
  }

  public void setId(int aId) {
    this.id = aId;
  }
  
  public void setHorario(String aHorario) {
    this.horario = aHorario;
  }
  public String getHorario() {
    return this.horario;
  }
  
  // cada curso tem que fazer o @Override desta função
  public void printHorario() {
    System.out.println("Cada curso tem que fazer o @Override desta função");
  }

  
  
  

}
