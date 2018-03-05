package model;

public class Instance {
  int[][] matrix;
  
  public int[][] readInstance(){
    return new int[][]{
//      {1,2,3},
//      {8,0,4},
//      {7,6,5}};
//      {1,2,3},
//      {8,4,0},
//      {7,6,5}};
        {8,1,2},
        {7,4,6},
        {0,5,3}};
  }
  public int[][] readObjetivo(){
    return new int[][]{{1,2,3},
                       {8,0,4},
                       {7,6,5}};
  }

}
