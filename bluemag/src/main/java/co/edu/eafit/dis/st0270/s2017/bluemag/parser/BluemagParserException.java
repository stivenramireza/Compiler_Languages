package co.edu.eafit.dis.st0270.s2017.bluemag.parser;

import co.edu.eafit.dis.st0270.s2017.bluemag.tokens.GRToken;

/**
 * Clase que genera las excepciones para el Parser Generator.
 *
 * @author Stiven Ramírez Arango
 * @author Juan Camilo Gómez Ruiz
 * @version 1.5
 */
public class BluemagParserException extends Exception{
    
    /**
     * Código serial obtenido por UUIDGEN.
     */
    public static final long serialVersionUID = 4487924411002636L;

    /**
     * Constructor de la clase BluemagParserException.
     * @param nombre
     * @param tok
     */
    public BluemagParserException(String nombre, GRToken tok){
	super(nombre + " en " + tok);
    }
    
}
