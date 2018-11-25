package co.edu.eafit.dis.st0270.s2017.bluemag.tokens;

/**
 * Clase que contiene la información de los tokens identificadores.
 *
 * @author Stiven Ramírez Arango
 * @author Juan Camilo Gómez Ruiz
 * @version 1.5
 */
public class IDTokens extends GRToken {

    private String id;

    /**
     * Constructor de la clase IDTokens.
     * @param id
     * @param line
     * @param column
     */
    public IDTokens(String id, int line, int column){
	super(line,column, id);
	this.id= id;
    }
    
    /**
     * Método que obtiene el token identificador.
     * @return String.
     */
    public String getID(){
	return id;
    }

    /**
     * Método que obtiene el nombre del token identificador.
     * @return String.
     */
    public String toString(){
	String var = super.toString();
	return "ID: " + id + " " + var ;
    }
}
