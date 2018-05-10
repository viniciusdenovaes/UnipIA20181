package model;

public class Integrante {
  
  private int id;
  
  public Integrante(int aId) {
    setId(aId);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  public void print() {
    System.out.println("id: " + id);
  }

}
