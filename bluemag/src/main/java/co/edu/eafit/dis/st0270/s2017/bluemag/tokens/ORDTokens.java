package co.edu.eafit.dis.st0270.s2017.bluemag.tokens;

/**
 * Clase que contiene la información de los tokens del comienzo
 * de plecas.
 *
 * @author Stiven Ramírez Arango
 * @author Juan Camilo Gómez Ruiz
 * @version 1.5
 */
public class ORDTokens extends SeparadorTokens {

    /**
     * Constructor de la clase ORDTokens.
     */

	
    /**
     * Constructor de la clase ORDTokens.
     */
    public ORDTokens() {

    	super("|", -1 , -1);
    }
    public ORDTokens(int line, int column){
	super("|", line, column);
    }

    /**
     * Método que compara la instancia del objeto con el
     * token del comienzo de plecas.
     * @param obj
     * @return boolean.
     */
    public boolean equals(Object obj) {
	boolean ret = false;
	if (obj instanceof ORDTokens) {
	    return true;
	}
	return ret;
    }

    /**
     * Método que retorna el valor del código de hash correspondiente
     * al token del comienzo de plecas.
     * @return int.
     */
    public int hashCode() {
	return BluemagTokensInfo.ORDTokens_TOKENS;
    }

}
