package co.edu.eafit.dis.st0270.s2017.bluemag.tokens;

/**
* Clase que contiene la información de los tokens de tipo varid.
*
* @author Stiven Ramírez Arango
* @author Juan Camilo Gómez Ruiz
* @version 1.5
*/
public class VaridTokens extends LiteralTokens{
    
    private String valor;

    /**
    * Constructor de la clase VaridTokens.
    * @param nombre.
    * @param line.
    * @param column.
    */
    public VaridTokens(String nombre, int line , int column){
	super(line,column);
	this.valor =new String(nombre);
    }

    /**
    * Método que obtiene el valor del token de tipo varid.
    * @return String.
    */
    public String getValor(){
	return valor;
    }

    /**
    * Método que retorna el valor del token de tipo varid.
    * @return String.
    */
    public String toString(){
	return "nombre: " + valor + " " + super.toString();
    }
}
