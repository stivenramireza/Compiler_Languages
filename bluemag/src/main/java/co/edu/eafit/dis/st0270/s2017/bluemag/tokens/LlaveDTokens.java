package co.edu.eafit.dis.st0270.s2017.bluemag.tokens;

/**
 * Clase que contiene la información de los tokens del comienzo
 * de llaves.
 *
 * @author Stiven Ramírez Arango
 * @author Juan Camilo Gómez Ruiz
 * @version 1.5
 */
public class LlaveDTokens extends SeparadorTokens {

    /**
     * Constructor de la clase LlaveDTokens.
     */
    public LlaveDTokens() {
	super("}", -1, -1);
    }
    public LlaveDTokens(int line, int column){
	super("}", line, column);
    }

    /**
     * Método que compara la instancia del objeto con el
     * token del comienzo de llaves.
     * @param obj
     * @return boolean.
     */
    public boolean equals(Object obj) {
	boolean ret = false;
	if (obj instanceof LlaveDTokens) {
	    return true;
	}
	return ret;
    }

    /**
     * Ḿétodo que retorna el código de hash correspondiente al
     * token generado en el comienzo de llaves.
     * @return int.
     */ 
    public int hashCode() {
        return BluemagTokensInfo.LlaveDTokens_TOKENS;
    }

}
