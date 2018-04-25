package Model;

import model.Jogada;
import model.TabuleiroFoto;

public class Estado {
  TabuleiroFoto tabuleiroFoto;
  Jogada jogadaQueGerou;
  long avaliacao;
  
  Estado(TabuleiroFoto aTabuleiroFoto,
                Jogada aJogadaQueGerou,
                  long aAvaliacao){
    this.tabuleiroFoto  = new TabuleiroFoto(aTabuleiroFoto);
    this.jogadaQueGerou = new Jogada(aJogadaQueGerou.x, aJogadaQueGerou.y);
    this.avaliacao = aAvaliacao;
  }
  
  @Override
  public String toString() {
    String res = "";
    res += "foto: \n";
    res += this.tabuleiroFoto.toString();
    res += "jogada que gerou: ";
    res += this.jogadaQueGerou.toString();
    res += "\n";
    res += "avaliacao: " + this.avaliacao;
    res += "\n";
    return res;
  }
}
