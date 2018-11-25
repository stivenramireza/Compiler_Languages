package co.edu.eafit.dis.st0270.s2017.bluemag.tokens;

/**
* Clase que contiene la información de los tokens operadores.
*
* @author Stiven Ramírez Arango
* @author Juan Camilo Gómez Ruiz
* @version 1.5
*/
public class OperadorTokens extends GRToken {

	/**
	* Enumeración para los operadores unarios y binarios.
	*/
    public enum EnumOperador{
	AND,
	MENIGUAL,
	IGUAL,
	SUM,
	MUL,
	NO,
	PI,
	PD;
    }

    private String operador;
    private EnumOperador enum1;

    /**
    * Constructor de la clase OperadorTokens.
    * @param operador.
    * @param line.
    * @param column.
    */
    public OperadorTokens(String operador, int line, int column){
	super(line,column, operador);
    this.operador = new String(operador);
	this.enum1 =getNum();
    }

    /**
    * Método de la enumeración que compara los operadores con el
    * nombre del mismo ingresado en el constructor.
    * @return EnumOperador.
    * @throw java.io.Error
    */
    private EnumOperador getNum(){
	if(operador.compareTo("y") == 0 ){
	    return EnumOperador.AND;
	}
        if(operador.compareTo("<=") == 0 ){
	    return EnumOperador.MENIGUAL;
	}
	
	if(operador.compareTo("=") == 0 ){
	    return EnumOperador.IGUAL;
	}
	
	if(operador.compareTo("+") == 0 ){
	    return EnumOperador.SUM;
	}
	if(operador.compareTo("*") == 0 ){
	    return EnumOperador.MUL;
	}
	if(operador.compareTo("no") == 0 ){
	    return EnumOperador.NO;
	}
	if(operador.compareTo("(") == 0 ){
	    return EnumOperador.PI;
	}

	if(operador.compareTo(")") == 0 ){
	    return EnumOperador.PD;
	}
	throw new Error("Error:operador no valido ");	
    }

    /**
    * Método que obtiene el operador.
    * @return EnumOperador.
    */
    public EnumOperador getEnumoperador(){
	return enum1;
    }

    /**
    * Método que retorna el nombre del token operador.
    * @return String.
    */
    public String toString(){
	return "operador: " + operador + " " + super.toString();
    }
    
}
	
	
