//import java.util.Arrays;
public class Sudoku{

  private int [][] tablero;

  public Sudoku(int [][] tablero){
    this.tablero = tablero;
  }

  public void resolverSudoku(){

    if(resolver()){
      System.out.println("Sudoku resuelto");
    }else{
      System.out.println("No hay solución del sudoku");
    }

  }

  private boolean resolver(){
    //Se agrega este método porque el método de resolverSudoku al tener un retorno de tipo VOID, es imposible hacer recursión lol

    for(int i = 0; i < tablero.length; i ++){

      for(int j = 0; j < tablero.length; j++){

        if(tablero[i][j] == 0){

          for(int numPrueba = 1; numPrueba <= 9; numPrueba++){

            if(posicionValida(i, j, numPrueba)){
              tablero[i][j] = numPrueba;

              if(resolver()){
                return true;
              }else{
                tablero[i][j] = 0;
              }
            }
                    
          }
          return false;
        }
      }
    }
    return true; 
  }
  private boolean posicionValida(int fila, int col, int num){
    
    int subFila = fila - (fila % 3), subCol = col - (col % 3);

    for(int i = 0; i < tablero.length; i ++){
      if(tablero[fila][i] == num || tablero[i][col] == num) return false;
    }

    for(int i = 0; i < tablero.length; i++){
      for(int j = 0; j < tablero.length; j++){
        if(tablero[i + subFila][j + subCol] == num) return false;
      }
    }
    return true;
  }


  public void imprimeSolucion(){
    for(int i = 0; i < 9; i++){
      if (i % 3 == 0 && i != 0) {
                System.out.println("-----------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
    }

  }

  
}
