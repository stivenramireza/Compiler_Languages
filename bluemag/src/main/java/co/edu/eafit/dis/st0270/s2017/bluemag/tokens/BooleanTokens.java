package co.edu.eafit.dis.st0270.s2017.bluemag.tokens;

/**
 * Clase que contiene la información de los tokens booleanos.
 *
 * @author Stiven Ramírez Arango
 * @author Juan Camilo Gómez Ruiz
 * @version 1.5
 */
public class BooleanTokens extends LiteralTokens{
    
    private Boolean valor;

    /**
     * Constructor de la clase BooleanTokens.
     * @param nombre
     * @param line
     * @param column
     */
    public BooleanTokens(String nombre, int line, int column){
	super(line,column);
	this.valor = new Boolean(nombre);
    }

    /**
     * Método que obtiene el valor del token booleano.
     * @return int.
     */
    public Boolean getValor(){
	return valor;
    }

    /**
     * Ḿétodo que obtiene el nombre del token booleano.
     * @return String.
     */
    public String toString(){
	return "Boolean: " + valor + " " + super.toString();
    }

}
