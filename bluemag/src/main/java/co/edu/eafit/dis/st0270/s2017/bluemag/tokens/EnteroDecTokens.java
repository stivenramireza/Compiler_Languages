package co.edu.eafit.dis.st0270.s2017.bluemag.tokens;

/**
* Clase que contiene la información de los tokens enteros.
*
* @author Stiven Ramírez Arango
* @author Juan Camilo Gómez Ruiz
* @version 1.5
*/
public class EnteroDecTokens extends LiteralTokens{
    
    private Integer valor;

    /**
    * Constructor de la clase EnteroDecTokens.
    * @param nombre.
    * @param line.
    * @param column.
    */

    public EnteroDecTokens(){
        super(-1, -1);
        this.valor = valor;
    }

    public EnteroDecTokens(String nombre, int line, int column){
	super(line,column);
	this.valor = new Integer(nombre); 
    }

    /**
    * Método que obtiene el valor del token entero.
    * @return int.
    */
    public int getValor(){
	return valor;
    }

    /**
    * Método que obtiene el nombre del token entero.
    * @return String.
    */
    public String toString(){
	return "Integer: " +  valor + " " + super.toString();

    }

    public int hashCode() {
    return BluemagTokensInfo.EnteroDecTokens_TOKENS;
    }

    public boolean equals(Object obj) {
    boolean ret = false;
    if (obj instanceof EnteroDecTokens) {
        return true;
    }
    return ret;
    }

}
