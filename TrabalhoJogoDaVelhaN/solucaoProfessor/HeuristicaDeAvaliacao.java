package Model;

import model.TabuleiroFoto;

public class HeuristicaDeAvaliacao {
  enum Side{
    O,X;
    static char getChar(Side side) {
      switch(side) {
      case O:
        return 'O';
      case X:
        return 'X';
      default:
        return ' ';
      }
    }
  };
  Side side;
  Side otherSide;
  
  public HeuristicaDeAvaliacao(char aSide) {
    switch(aSide) {
    case 'O':
      this.side = HeuristicaDeAvaliacao.Side.O;
      this.otherSide = HeuristicaDeAvaliacao.Side.X;
      break;
    case 'X':
      this.side = HeuristicaDeAvaliacao.Side.X;
      this.otherSide = HeuristicaDeAvaliacao.Side.O;
      break;
    default:
      System.out.println("ERRO: EM heuristicaDeAvaliacao CONSTRUCTOR: SIDE NAO ENCONTRADO");
      break;
    }
  }
  
  boolean isMySide(char elemento) {
    return elemento == HeuristicaDeAvaliacao.Side.getChar(this.side);
  }
  boolean isEmptySide(char elemento) {
    return elemento == ' ';
  }
  boolean isOtherSide(char elemento) {
    return elemento == HeuristicaDeAvaliacao.Side.getChar(this.otherSide);
  }
  
  long avalia(TabuleiroFoto foto) {
    long notaDeAvaliacao = 0;
//    System.out.println("nota inicial " + notaDeAvaliacao);
    
    notaDeAvaliacao += avalia01(foto);
//    System.out.println("nota depois da 01 " + notaDeAvaliacao);
    notaDeAvaliacao += avalia02(foto);
//    System.out.println("nota depois da 02 " + notaDeAvaliacao);
    notaDeAvaliacao += avalia03(foto);
//    System.out.println("nota depois da 03 " + notaDeAvaliacao);
    
//    System.out.println("nota final " + notaDeAvaliacao);
    return notaDeAvaliacao;
  }
  
  
  
  // verifica se é estado objetivo (se ganha)
  long avalia01(TabuleiroFoto foto) {
    long notaParaGanhar = 10*(int)Math.pow((double)foto.n, (double)4);
    
    //linhas e colunas
    for(int i=0; i<foto.t.length; ++i) {
      int countLinha=0;
      int countColuna=0;
      for(int j=0; j<foto.t[i].length; ++j) {
        if(isMySide(foto.t[i][j]))
          countColuna++;
        if(isMySide(foto.t[j][i]))
          countLinha++;
      }
      if(countLinha==foto.n||countColuna==foto.n)
        return notaParaGanhar;
    }
    
    {
      int countDiagonalPrincipal=0;
      int countDiagonalSecundaria=0;
      for(int i=0; i<foto.n; ++i) {
        if(isMySide(foto.t[i][i]))
          countDiagonalPrincipal++;
        if(isMySide(foto.t[foto.n-1-i][i]))
          countDiagonalSecundaria++;
      }
      if(countDiagonalPrincipal==foto.n||countDiagonalSecundaria==foto.n)
        return notaParaGanhar;
    }
    
    return 0;
  }

  
  
  // verifica se é estado objetivo do outro jogador (se perde)
  // retorna um valor negativo
  long avalia02(TabuleiroFoto foto) {
    long notaParaNaoPerder = -10*(int)Math.pow((double)foto.n, (double)3);
    
    //linhas
    for(int i=0; i<foto.t.length; ++i) {
      int count=0;
      boolean blocked = false;
      for(int j=0; j<foto.t.length; ++j) {
        if(isMySide(foto.t[i][j])) {
          blocked = true;
          break;
        }
        if(isOtherSide(foto.t[i][j]))
          count++;
      }
      if(count==foto.n-1 && !blocked) {
        return notaParaNaoPerder;
      }
    }
    
    //colunas
    for(int j=0; j<foto.t.length; ++j) {
      int count=0;
      boolean blocked = false;
      for(int i=0; i<foto.t.length; ++i) {
        if(isMySide(foto.t[i][j])) {
          blocked = true;
          break;
        }
        if(isOtherSide(foto.t[i][j]))
          count++;
      }
      if(count==foto.n-1 && !blocked) {
        return notaParaNaoPerder;
      }
    }
    
    //diagonal principal
    {
      int count=0;
      boolean blocked = false;
      for(int i=0; i<foto.t.length; ++i) {
        if(isMySide(foto.t[i][i])) {
          blocked = true;
          break;
        }
        if(isOtherSide(foto.t[i][i]))
          count++;
      }
      if(count==foto.n-1 && !blocked) {
        return notaParaNaoPerder;
      }
    }
    
    //diagonal secundaria
    {
      int count=0;
      boolean blocked = false;
      for(int i=0; i<foto.t.length; ++i) {
        if(isMySide(foto.t[foto.t.length-1-i][i])) {
          blocked = true;
          break;
        }
        if(isOtherSide(foto.t[i][i]))
          count++;
      }
      if(count==foto.n-1 && !blocked) {
        return notaParaNaoPerder;
      }
    }
    
    return 0;
  }

  
  
  // verifica quantos faltam na linha para ganhar
  long avalia03(TabuleiroFoto foto) {
    long notaQuantosFaltam = 0;
    
    //linhas
    for(int i=0; i<foto.t.length; ++i) {
      int count = 0;
      boolean myLine = true; 
      for(int j=0; j<foto.t[i].length; ++j) {
        if(isMySide(foto.t[i][j])) 
          count++;
        else if(isOtherSide(foto.t[i][j])) {
          myLine = false;
          break;
        }
      }
      if(myLine)
        notaQuantosFaltam += Math.pow(count, 2);
    }
    
    //colunas
    for(int j=0; j<foto.t.length; ++j) {
      int count = 0;
      boolean myLine = true; 
      for(int i=0; i<foto.t.length; ++i) {
        if(isMySide(foto.t[i][j])) 
          count++;
        else if(isOtherSide(foto.t[i][j])) {
          myLine = false;
          break;
        }
      }
      if(myLine)
        notaQuantosFaltam += Math.pow(count, 2);
    }
    
    //diagonal principal
    {
      int count = 0;
      boolean myLine = true; 
      for(int j=0; j<foto.t.length; ++j) {
        if(isMySide(foto.t[j][j])) 
          count++;
        else if(isOtherSide(foto.t[j][j])) {
          myLine = false;
          break;
        }
      }
      if(myLine)
        notaQuantosFaltam += Math.pow(count, 2);
    }
    
    //diagonal secundaria
    {
      int count = 0;
      boolean myLine = true; 
      for(int j=0; j<foto.t.length; ++j) {
        if(isMySide(foto.t[foto.t.length-1-j][j])) 
          count++;
        else if(isOtherSide(foto.t[foto.t.length-1-j][j])) {
          myLine = false;
          break;
        }
      }
      if(myLine)
        notaQuantosFaltam += Math.pow(count, 2);
    }
    
    return notaQuantosFaltam;
  }

}









