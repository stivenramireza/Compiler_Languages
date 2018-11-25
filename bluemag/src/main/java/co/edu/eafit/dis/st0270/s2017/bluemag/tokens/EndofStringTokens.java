package co.edu.eafit.dis.st0270.s2017.bluemag.tokens;

/**
 * Clase que contiene la información de los tokens de fin de línea.
 *
 * @author Stiven Ramírez Arango
 * @author Juan Camilo Gómez Ruiz
 * @version 1.5
 */
public class EndofStringTokens extends GRToken {

    /**
     * Constructor de la clase EndofStringTokens.
     */
    public EndofStringTokens() {
	super(-1,-1, null);
    }

    /**
     * Método que compara el objeto instancia del token de fin de línea.
     * @param obj.
     * @return boolean.
     */
    public boolean equals(Object obj) {
	boolean ret = false;
	if (obj instanceof EndofStringTokens) {
	    return true;
	}
	return ret;
    }

    /**
     * Método que obtiene el código de hash evaluador de la expresión
     * en el token de fin de línea.
     * @return int.
     */
    public int hashCode() {
	return BluemagTokensInfo.ENDOFSTRING_TOKENS;
    }

}
