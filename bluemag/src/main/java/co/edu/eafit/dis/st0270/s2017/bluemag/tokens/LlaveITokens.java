package co.edu.eafit.dis.st0270.s2017.bluemag.tokens;

/**
 * Clase que contiene la información de los tokens del fin
 * de llaves.
 *
 * @author Stiven Ramírez Arango
 * @author Juan Camilo Gómez Ruiz
 * @version 1.5
 */
public class LlaveITokens extends SeparadorTokens {

    /**
     * Constructor de la clase LlaveITokens.
     */
    public LlaveITokens() {
	super("{",-1,-1);
    }

    public LlaveITokens(int line, int column){
	super("{", line, column);
    }
    /**
     * Método que compara la instancia del objeto con
     * el token de fin de llaves.
     * @param obj
     * @return boolean.
     */
    public boolean equals(Object obj) {
	boolean ret = false;
	if (obj instanceof LlaveITokens){
	    return true;
	}
	return ret;
    }

    /**
     * Método que retorna el código de hash correspondiente
     * al fin de llaves.
     * @return int.
     */
    public int hashCode() {

        return BluemagTokensInfo.LlaveITokens_TOKENS;
    }

}
