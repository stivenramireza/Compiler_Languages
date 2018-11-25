package co.edu.eafit.dis.st0270.s2017.bluemag.tokens;

import java.io.IOException;

/**
 * Clase que contiene la información de los tokens para las
 * palabras reservadas.
 *
 * @author Stiven Ramírez Arango
 * @author Juan Camilo Gómez Ruiz
 * @version 1.5
 */
public class PalabrasReservadas extends GRToken {
  
    /**
     * Enumeración de las palabras reservadas.
     */
    public enum EnumKeyword{
	CLASE,
	SOLICITAR,
	CUANDO,
	SI,
	ENT,
	SINO,
	FINSI,
	MIENTRAS,
	HACER,
	Flecha,
	PCOMA;
	
	/**
	 * Método que obtiene el valor del token de la palabra reservada.
	 * @param nombre
	 * @return EnumKeyword.
	 * @throws java.io.IOException
	 */
	public static EnumKeyword getKeywordOrdinal(String nombre) throws IOException{

	    if(nombre.compareTo("clase") == 0){
		return CLASE;
	    }
	    if (nombre.compareTo("solicitar") == 0){
		return SOLICITAR;
	    }
	    if (nombre.compareTo("cuando") == 0){
		return CUANDO;
	    }
	    if (nombre.compareTo("si") == 0){
		return SI;
	    
	    }
	    if (nombre.compareTo("ent") == 0){
		return ENT;
	    
	    }
	    if (nombre.compareTo("sino") == 0){
		return SINO;
	    
	    }
	    if (nombre.compareTo("finsi") == 0){
		return FINSI;
	    
	    }
	    if (nombre.compareTo("mientras") == 0){
		return MIENTRAS;
	    
	    }
	    if (nombre.compareTo("hacer") == 0){
		return HACER;
	    
	    }
	    if (nombre.compareTo(";") == 0){
		return PCOMA;

	    }
	    if (nombre.compareTo("<-" )== 0) {
		return Flecha;
	    }
	    throw new IOException ("irreconocible keyword");
	}
    }

    private String keyword = null;
    
    /**
     * Constructor de la clase PalabrasReservadas.
     * @param keyword
     * @param line
     * @param column
     */
    public PalabrasReservadas(String keyword, int line, int column){
	super(line, column, keyword);
	this.keyword = new String(keyword);
    }

    /**
     * Método que retorna el nombre del token de la palabra reservada.
     * @return String.
     */
    public String toString(){
	return "keyword es:" + this.keyword + " " + super.toString();

    }

    /**
     * Método que obtiene el valor de la enumeración del token de la
     * palabra reservada.
     * @return EnumKeyword.
     * @throws java.io.IOException
     */
    public EnumKeyword getEnumKeyword()  throws IOException{
	return EnumKeyword.getKeywordOrdinal(keyword);
    }

}
