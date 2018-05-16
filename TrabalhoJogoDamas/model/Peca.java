package model;

public class Peca {
  
  public final static char LIGHT = 'L';
  public final static char RED = Peca.LIGHT;
  public final static char DARK = 'D';
  public final static char BLACK = Peca.DARK;
  public final static char LIGHT_KING = (char)('L'+1);
  public final static char RED_KING = Peca.LIGHT_KING;
  public final static char DARK_KING = (char)('D'+1);
  public final static char BLACK_KING = Peca.DARK_KING;
  
  // verifica se a peca é um rei
  public static boolean isKing(char aPeca) {
    if(aPeca==LIGHT_KING)return true;
    if(aPeca==DARK_KING)return true;
    return false;
  }
  // verifica se a peca é do mesmo lado de side
  public static boolean isSameSide(char side, char aPeca) {
    if(aPeca==(char)(side) || aPeca==(char)(side+1))return true;
    return false;
  }
  // verifica se a peca é do lado oposto de side
  public static boolean isOtherSide(char side, char aPeca) {
    if(aPeca==(char)(otherSide(side)) || aPeca==(char)(otherSide(side)+1))return true;
    return false;
  }
  //retorna o character do outro lado de side
  public static char otherSide(char side) {
    if(side==LIGHT)return DARK;
    if(side==DARK) return LIGHT;
    return '_';
  }
  // transforma a peca em rei
  public static char viraRei(char aPeca) {
    if(isKing(aPeca))
      return aPeca;
    else return (char)(aPeca+1);
  }
  // direcao que a peca deve se mover (de baixo para cima)
  public static int direcao(char side) {
    if(side==LIGHT) return  1;
    if(side==DARK)  return -1;
    return 0;
  }

}
