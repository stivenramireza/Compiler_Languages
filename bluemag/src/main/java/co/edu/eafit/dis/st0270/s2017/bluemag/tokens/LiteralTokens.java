package co.edu.eafit.dis.st0270.s2017.bluemag.tokens;

/**
 * Clase abstracta que contiene la información de los tokens literales.
 *
 * @author Stiven Ramírez Arango
 * @author Juan Camilo Gómez Ruiz
 * @version 1.5
 */
public abstract class LiteralTokens extends GRToken {

    /**
     * Constructor de la clase LiteralTokens.
     * @param line
     * @param column
     */
    public LiteralTokens(int line, int column){
	super(line, column, null);
    }
}
