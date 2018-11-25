package co.edu.eafit.dis.st0270.s2017.bluemag.tokens;

/**
 * Clase que contiene la información de los tokens separadores.
 *
 * @author Stiven Ramírez Arango
 * @author Juan Camilo Gómez Ruiz
 * @version 1.5
 */
public class SeparadorTokens extends GRToken {

    private String separador;

    /**
     * Constructor de la clase SeparadorTokens.
     * @param separador
     * @param line
     * @param column
     */
    public SeparadorTokens(String separador, int line, int column) {
	super(-1, -1, separador);
	this.separador = new String(separador);
    }

    /**
     * Método que retorna el nombre de los tokens separadores.
     * @return String.
     */
    public String toString() {
	return "Separador: " + separador + " " + super.toString();
    }
}
