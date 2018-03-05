package model;

public enum Acoes {
  CIMA("CIMA"),
  DIREITA("DIREITA"),
  BAIXO("BAIXO"),
  ESQUERDA("ESQUERDA");
  
  String key;
  
  Acoes() {}
  
  Acoes(String name){
    this.key = name;
  }
  
  String getString(Acoes acao) {
    switch(acao) {
    case CIMA:
      return "CIMA";
    case DIREITA:
      return "DIREITA";
    case BAIXO:
      return "BAIXO";
    case ESQUERDA:
      return "ESQUERDA";
    }
    return null;
  }
  
  @Override public String toString() {
    String res = " ";
    switch(this) {
      case CIMA:
        res+= "^\n |\n ";
        break;
      case DIREITA:
        res+= "->\n ";
        break;
      case BAIXO:
        res+= "|\n v\n ";
        break;
      case ESQUERDA:
        res+= "<-\n ";
        break;
    }
    return res;
  }
}
