package co.edu.eafit.dis.st0270.s2017.bluemag.tokens;

/**
* Clase abstracta que contiene la información de los tokens en general.
*
* @author Stiven Ramírez Arango
* @author Juan Camilo Gómez Ruiz
* @version 1.5
*/
public abstract class GRToken{
  
    private int line;
    private int column;
    private String lexema;

  /**
  * Constructor de la clase GRToken.
  * @param line.
  * @param column.
  */
  public GRToken(int line, int column, String lexema){
    this.line = line + 1;
    this.column = column;
    this.lexema = lexema;
  }

  /**
  * Método que obtiene el valor de la columna del token en general.
  * @return int.
  */
  public int getColumn(){
    return column;
  }

  /**
  * Método que obtiene el valor de la línea del token en general.
  * @return int.
  */
  public int getLine(){
    return line;
  }

  /**
  * Método que retorna el lexema leído de la gramática.
  * @return String
  */
  public String getString(){
    return lexema;
  }

  /**
  * Método que obtiene el nombre del token en general.
  * @return String.
  */
  public String toString(){
    return "line: " + line + " column: " + column;
  }
}
