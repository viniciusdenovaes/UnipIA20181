package factory.PlayerR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Direcao {
  int x;
  int y;
  Direcao(int aX, int aY){
    this.x = aX;
    this.y = aY;
  }
  
  @SuppressWarnings("serial")
  static final List<Direcao> todas = Collections.unmodifiableList(
      new ArrayList<Direcao>() {
      {
          for(int i=0; i<4; i++)
            add(intToDirecao(i));
          }});
  static Direcao intToDirecao(int a) {
    return new Direcao( ((a%2)*(-2)) + 1, (( (a/2)%2 )*(-2)) + 1);
  }
  @Override public String toString() {
    String res = "";
    res += "("+this.x+", "+this.y+")";
    return res;
  }

}

