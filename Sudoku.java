//import java.util.Arrays;
public class Sudoku{

  private int [][] tablero;

  public Sudoku(int [][] tablero){
    if(tablero == null) 
      throw new NullPointerException("El sudoku no puede ser NULL");

    if(tablero.length != 9 || tablero[0].length != 9)
      throw new IllegalArgumentException("El tablero debe de ser 9x9");


    this.tablero = tablero;
  }

  /*
   * Se modificó el tipo de valor de regreso del método de void a boolean
   * simplemente porque al usar un algoritmo de BackTracking
   * hacemos uso de recursión y pues si el algoritmo de resolver Sudoku
   * solo se quedaría en void, no tendría ningún parámetro para que 
   * se pueda llevar la recursión ya que si llega al punto que debe de llegar
   * ¿Qué devuele la función?, debe de regresar un dato afirmativo o un dato 
   * de que no se cumplió la recursión por tanto se hace el cambio de retorno 
   * de void a boolean, simplemente para que funcione la recursion
   */
  
  public boolean resolverSudoku(){

    for(int i = 0; i < tablero.length; i ++){

      for(int j = 0; j < tablero.length; j++){

        if(tablero[i][j] == 0){

          for(int numPrueba = 1; numPrueba <= 9; numPrueba++){

            if(posicionValida(i, j, numPrueba)){
              tablero[i][j] = numPrueba;

              if(resolverSudoku()){
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
    if(fila < 0 || fila > 8 ||col < 0|| col > 8 || num > 9 || num < 1 ) 
      throw new IllegalArgumentException("Número debe de ser positivo");
    
    int subFila = fila - (fila % 3), subCol = col - (col % 3);

    for(int i = 0; i < tablero.length; i ++){
      if(tablero[fila][i] == num || tablero[i][col] == num) return false;
    }

    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
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
