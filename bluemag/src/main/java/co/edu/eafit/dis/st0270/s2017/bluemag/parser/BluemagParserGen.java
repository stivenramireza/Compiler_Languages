package co.edu.eafit.dis.st0270.s2017.bluemag.parser;

import co.edu.eafit.dis.st0270.s2017.bluemag.lexer.GRBluemagLexer;
import co.edu.eafit.dis.st0270.s2017.bluemag.tokens.*;
import java.io.StringReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Clase que contiene el Parser Generator manual.
 *
 * @author Stiven Ramírez Arango
 * @author Juan Camilo Gómez Ruiz
 * @version 1.5
 */
public class BluemagParserGen {

    /**
     * Instancias de clase GRBluemagLexer para el caracter leído y de
     * la clase GRToken para el caracter actual.
     */
    private GRBluemagLexer cel = null;
    private GRToken cc  = null;
    
    /**
     * Constructor de la clase BluemagParserGen.
     */
    public BluemagParserGen() {
    }

    /**
     * Método que analiza la expresión ingresada a través de la gramática.
     * @param str
     * @throws BluemagParserException
     * @throws java.io.IOException
     */
    public void parser(String str) throws BluemagParserException, IOException {
	StringReader sr;
	try {
	    sr = new StringReader(str);
	    cel = new GRBluemagLexer(sr);
	} catch (Exception e) {
	    System.err.println(e);
	    System.exit(1);
	}

	cc = cel.getNextToken();

	GramManrec();

	if (cc != null) throw new BluemagParserException("La pila no esta vacía: ",  cc);
	return;
    }

    /**
     * Método que crea los estados para la 1era regla de la gramática.
     * @throws BluemagParserException
     * @throws java.io.IOException
     */
    //-------------------LISTO-------------------------------------------
    private void GramManrec()throws BluemagParserException, IOException {
	// Estado 0
	Manrec();
	// Estado 1
	if(cc == null){
		
	}

	else throw new BluemagParserException("Se espera EOF", cc);
	// Estado 2
	return; 
    }
    //-------------------------------------------------------------------

    /**
     * Método que crea los estados para la 2da regla de la gramática.
     * @throws BluemagParserException
     * @throws java.io.IOException
     */
    //--------------------LISTO------------------------------------------
    private void Manrec()throws BluemagParserException, IOException {
	// Estado 3
	Declaraciones();
	// Estado 4
	Instrucciones();
	// Estado 5
	return;
    }

    /**
     * Método que crea los estados para la 3era regla de la gramática.
     * @throws BluemagParserException
     * @throws java.io.IOException
     */

    private void Declaraciones()throws BluemagParserException, IOException {
        if(cc instanceof PalabrasReservadas&& cc.getString().equals("clase")){
                cc = cel.getNextToken();
        }
        else throw new BluemagParserException("Se espera 'clase'", cc);
        do{
                cc = cel.getNextToken();
                if(cc instanceof EnteroDecTokens){
                    cc = cel.getNextToken();
                    if(cc instanceof PalabrasReservadas && cc.getString().equals(";")){
                        cc = cel.getNextToken();
                        if(cc instanceof PalabrasReservadas && cc.getString().equals("clase")){
                            cc = cel.getNextToken();
                        }else if((cc instanceof PalabrasReservadas && cc.getString().equals("solicitar")) || cc instanceof LlaveITokens
                                || cc instanceof VaridTokens || (cc.getString().equals("si"))
                                || (cc instanceof PalabrasReservadas && cc.getString().equals("mientras")) || cc instanceof EndofStringTokens){
                            return;
                        } 
                    } else throw new BluemagParserException("Se espera ';'", cc); 
                } else throw new BluemagParserException("Se espera ENTERO", cc);  
        }while(cc instanceof IDTokens);
        return;
    }

    /**
     * Método que crea los estados para la 4ta regla de la gramática.
     * @throws BluemagParserException
     * @throws java.io.IOException
     */
    private void Instrucciones() throws BluemagParserException, IOException{
    	boolean continua = true;
    	while(continua){
        if((cc instanceof PalabrasReservadas && ((cc.getString().equals("mientras")) || (cc.getString().equals("si")) 
        	|| (cc.getString().equals("solicitar")))) || cc instanceof LlaveITokens || cc instanceof VaridTokens){
            Instruccion();
        }else if(cc instanceof LlaveDTokens || cc == null){

        }else {
        	continua = false;
            throw new BluemagParserException("Se espera: 'solicitar', '{' , ' Varid', 'si' , 'mientras'",cc);
        }
    	}
        return;
    }
    

    /**
     * Método que crea los estados para la 5ta regla de la gramática.
     * @throws BluemagParserException
     * @throws java.io.IOException
     */
    private void Instruccion() throws BluemagParserException, IOException{

	if (cc instanceof PalabrasReservadas) {
	    // Estado 18
	    if(cc.getString().equals("solicitar")){
		cc = cel.getNextToken();
		// Estado 19
		if(cc instanceof IDTokens){
		    cc = cel.getNextToken();
		    // Estado 20
		    if(cc.getString().equals("cuando")){
			cc =cel.getNextToken();
			// Estado 21
			ExprAnd();
			// Estado 22
			Bloque();
			// Estado 23
		    }else if(cc instanceof LlaveITokens){
			// Estado 24
			Bloque();
			// Estado 25
		    }
		}
	    }
	}else if( cc instanceof LlaveITokens){
		Bloque();
	}else if( cc instanceof VaridTokens){
		Asignacion();
	}else if( cc instanceof PalabrasReservadas){
		if(cc.getString().equals("si")){
		Condicional();
	}
	}else if ( cc instanceof PalabrasReservadas) {
		if(cc.getString().equals("mientras")){
			Ciclo();
		}
    }
    return;
}

    /**
     * Método que crea los estados para la 6ta regla de la gramática.
     * @throws BluemagParserException
     * @throws java.io.IOException
     */
    //---------------------------LISTO---------------------------------------
    private void Bloque() throws BluemagParserException, IOException {
        // Estado 19                                                                                                                                  
        if(cc instanceof LlaveITokens){
            cc= cel.getNextToken();
            // Estado 20                                                                                                                              
            BloquePR();
            // Estado 21                                                                                                                              
        }
        else throw new BluemagParserException("se espera '{'", cc);
        return;
    }
    
    //-------------------------------------------------------------------------

    /**
     * Método que crea los estados para la 7ma regla de la gramática.
     * @throws BluemagParserException
     * @throws java.io.IOException
     */
    private void BloquePR() throws BluemagParserException, IOException{
        if(cc instanceof ORDTokens){
	    DeclVars();
	    Instrucciones();
	    if(cc instanceof LlaveDTokens){
		cc = cel.getNextToken();
	    }
        }else if((cc instanceof PalabrasReservadas && ((cc.getString().equals("solicitar")) && (cc.getString().equals("mientras"))
        	|| (cc.getString().equals("si")))) || cc instanceof LlaveITokens ||cc instanceof VaridTokens|| cc == null){
            Instrucciones();
            if(cc instanceof LlaveDTokens){
			cc = cel.getNextToken();
	    	}
        }else throw new BluemagParserException("Se espera: 'solicitar', '{' , ' Varid', 'si' , 'mientras'",cc);
        return;
    }
/**
 * Método que crea los estados para la 8va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void Asignacion() throws BluemagParserException, IOException{
    // Estado 26
    if (cc instanceof VaridTokens) {
	cc = cel.getNextToken();
	// Estado 27
	if(cc instanceof PalabrasReservadas){
	    if(cc.getString().equals("<-")){
		//estado 28
		cc =cel.getNextToken();
		//System.out.println("Recibió <-");
		//estado 29
		ExprAnd();
		if(cc instanceof PalabrasReservadas){
		    if(cc.getString().equals(";")){
			cc =cel.getNextToken();
			//estado 30
			//System.out.println("recibio ;");
		    }else{
			throw new BluemagParserException("Se espera ';", cc);
		    }
		}
	    }else{
	    	throw new BluemagParserException("Se espera '<-", cc);
	    }
	}
    }else{
   	throw new BluemagParserException("Se espera 'varid'", cc);
    }
    return;
}

/**
 * Método que crea los estados para la 9na regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void Condicional() throws BluemagParserException, IOException{
    if (cc instanceof PalabrasReservadas) {
	if(cc.getString().equals("si")){
	    cc = cel.getNextToken();
	    //System.out.println("recibio si");
	    // Estado 32
	    ExprAnd();
	    // Estado 33
	    if(cc.getString().equals("ent")){
		cc =cel.getNextToken();
		//System.out.println("recibio ent");
		// Estado 34
		Instruccion();
		// Estado 35
		CondicionalPR();
		// Estado 36
	    }else throw new BluemagParserException("Se espera 'ent'", cc);    
	}else throw new BluemagParserException("Se espera 'si'", cc);
    }
    return;
}

/**
 * Método que crea los estados para la 10ma regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void CondicionalPR() throws BluemagParserException ,IOException{
    // Estado 37
    if (cc instanceof PalabrasReservadas){
	if(cc.getString().equals("sino")){
	    cc =cel.getNextToken();
	    //System.out.println("recibio sino");
	    // Estado 38
	    Instruccion();
	    if(cc.getString().equals("finsi")){
		cc = cel.getNextToken();
		//System.out.println("recibio finsi");
		// Estado 40
	    }
	}else if(cc.getString().equals("finsi")){

	}else throw new BluemagParserException("Se espera 'finsi'", cc);
	}
	return;
}
	   

/**
 * Método que crea los estados para la 11va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void Ciclo() throws BluemagParserException, IOException{
    // Estado 41
    if (cc instanceof PalabrasReservadas){	    
	if(cc.getString().equals("mientras")){
	    cc =cel.getNextToken();
	    //System.out.println("recibio mientras");
	    // Estado 42-
	    ExprAnd();

	    if(cc.getString().equals("hacer")){
		cc = cel.getNextToken();
		//System.out.println("recibio hacer");
		// Estado 44
		Instruccion();
		// Estado 45
	    }else throw new BluemagParserException("Se espera 'hacer'", cc);
	}else throw new BluemagParserException("Se espera 'mientras'", cc);
    }
    return;
}

/**
 * Método que crea los estados para la 12va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void DeclVars()throws BluemagParserException, IOException{
    // Estado 46
    if(cc instanceof ORDTokens){
	cc = cel.getNextToken();
	// Estado 47
	if(cc instanceof VaridTokens){
	    cc =cel.getNextToken();
	    // Estado 48
	    
	    while(cc instanceof VaridTokens){
	    	cc = cel.getNextToken();
	    }
	    if(cc instanceof ORDTokens){
	    	cc = cel.getNextToken();
	    }else throw new BluemagParserException("Se espera '|'", cc);
	}else throw new BluemagParserException("Se espera VARID", cc);	   		
    }else throw new BluemagParserException("Se espera '|'", cc);
}

/**
 * Método que crea los estados para la 13va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void ExprAnd()throws BluemagParserException, IOException{
    // Estado 79
    ExprMIgual();
    // Estado 80
    RestExprAndPR();
    // Estado 81
    return;
}

/**
 * Método que crea los estados para la 14va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void RestExprAnd() throws BluemagParserException, IOException{
    // Estado 82
    if(cc instanceof OperadorTokens){
	// Estado 83
	if(cc.getString().equals("y")){
	    cc = cel.getNextToken();
	    // Estado 84
	    ExprMIgual();
	    // Estado 85
	    RestExprAndPR();
	    // Estado 86
	}
	else throw new BluemagParserException("Se espera 'y'", cc);
    }
    return;
}

/**
 * Método que crea los estados para la 15va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void RestExprAndPR() throws BluemagParserException, IOException{
    if(cc instanceof OperadorTokens){
	if(cc.getString().equals("y")){
	    RestExprAnd();
	}
    }
    else if((cc instanceof OperadorTokens && cc.getString().equals(")")) ||
	    (cc == null)){

    }
    else throw new BluemagParserException("Se espera ')'", cc);
    return;
}

/**
 * Método que crea los estados para la 16va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void ExprMIgual()throws BluemagParserException, IOException{
    // Estado 91
    ExprIgual();
    // Estado 92
    RestExprMIgualPR();
    // Estado 93
    return;
}

/**
 * Método que crea los estados para la 17va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void RestExprMIgual() throws BluemagParserException, IOException{
    // Estado 94
    if(cc instanceof OperadorTokens){
	if(cc.getString().equals("<=")){
	    cc = cel.getNextToken();
	    // Estado 95
	    ExprIgual();
	    // Estado 96
	    RestExprMIgualPR();
	    // Estado 97
	}
        else throw new BluemagParserException("Se espera '<='", cc);
    }
    return;
}

/**
 * Método que crea los estados para la 18va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void RestExprMIgualPR() throws BluemagParserException, IOException{
    if(cc instanceof OperadorTokens){
	if(cc.getString().equals("<=")){
	    RestExprMIgual();
	}
    }
    else if((cc instanceof OperadorTokens && ((cc.getString().equals(")")) 
    	|| (cc.getString().equals("y")) )) ||
	    (cc == null)){

    }
    else throw new BluemagParserException("Se espera 'y',')'", cc);
    return;
}

/**
 * Método que crea los estados para la 19va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void ExprIgual()throws BluemagParserException, IOException{
    // Estado 102
    ExprSum();
    // Estado 103
    RestExprIgualPR();
    // Estado 104
    return;
}

/**
 * Método que crea los estados para la 20va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void RestExprIgual() throws BluemagParserException, IOException{
    // Estado 105
    if(cc instanceof OperadorTokens){
	if(cc.getString().equals("=")){
	    cc = cel.getNextToken();
	    // Estado 106
	    ExprSum();
	    // Estado 107
	    RestExprIgualPR();
	    // Estado 108
	}
        else throw new BluemagParserException("Se espera '='", cc);
    }
    return;
}

/**
 * Método que crea los estados para la 21va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void RestExprIgualPR() throws BluemagParserException, IOException{
    if(cc instanceof OperadorTokens){
	if(cc.getString().equals("=")){
	    RestExprIgual();
	}
    }
    else if((cc instanceof OperadorTokens && ((cc.getString().equals(")"))
	     || (cc.getString().equals("y")) || (cc.getString().equals("<=")))) ||
	    (cc == null)){

    }
    else throw new BluemagParserException("Se espera '<=','y',')'", cc);
    return;
}

/**
 * Método que crea los estados para la 22va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void ExprSum()throws BluemagParserException, IOException{
    // Estado 113
    ExprMul();
    // Estado 114
    RestExprSumPR();
    // Estado 115
    return;
}

/**
 * Método que crea los estados para la 23va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void RestExprSum() throws BluemagParserException, IOException{
    // Estado 116
    if(cc instanceof OperadorTokens){
	if(cc.getString().equals("+")){
	    cc = cel.getNextToken();
	    // Estado 117
	    ExprMul();
	    // Estado 118
	    RestExprSumPR();
	    // Estado 119
	}
        else throw new BluemagParserException("Se espera '+'", cc);
    }
    return;
}

/**
 * Método que crea los estados para la 24va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void RestExprSumPR() throws BluemagParserException, IOException{
    if(cc instanceof OperadorTokens){
	if(cc.getString().equals("+")){
	    RestExprSum();
	}
    }
    else if((cc instanceof OperadorTokens && ((cc.getString().equals(")"))
	     || (cc.getString().equals("y")) || (cc.getString().equals("<=")) 
	     || (cc.getString().equals("=")))) ||
	    (cc == null)){

    }
    else throw new BluemagParserException("Se espera '=','<=','y',')'", cc);
    return;
}

/**
 * Método que crea los estados para la 25va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void ExprMul()throws BluemagParserException, IOException{
    // Estado 124
    Negation();
    // Estado 125
    RestExprMulPR();
    // Estado 126
    return;
}

/**
 * Método que crea los estados para la 26va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void RestExprMul() throws BluemagParserException, IOException{
    // Estado 127
    if(cc instanceof OperadorTokens){
	if(cc.getString().equals("*")){
	    cc = cel.getNextToken();
	    // Estado 128
	    Negation();
	    // Estado 129
	    RestExprMulPR();
	    // Estado 130
	}
        else throw new BluemagParserException("Se espera '*'", cc);
    }
    return;
}

/**
 * Método que crea los estados para la 27va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void RestExprMulPR() throws BluemagParserException, IOException{
    if(cc instanceof OperadorTokens){
	if(cc.getString().equals("*")){
	    RestExprMul();
	}
    }
    else if((cc instanceof OperadorTokens && ((cc.getString().equals(")"))
	     || (cc.getString().equals("y")) || (cc.getString().equals("<=")) 
	     || (cc.getString().equals("=")) || (cc.getString().equals("+")))) ||
	    (cc == null)){

    }
    else throw new BluemagParserException("Se espera '+','=','<=','y',')'", cc);
    return;
}

/**
 * Método que crea los estados para la 28va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void Negation() throws BluemagParserException, IOException{
    // Estado 135
    if(cc instanceof PalabrasReservadas){
	if(cc.getString().equals("no")){
	    // Estado 136
	    cc = cel.getNextToken();
	    Factor();
	}
    }
    else if(cc == null){
    	Factor();
    }
    else throw new BluemagParserException("Se espera EOL", cc);
    return;
}

/**
 * Método que crea los estados para la 29va regla de la gramática.
 * @throws BluemagParserException
 * @throws java.io.IOException
 */
private void Factor() throws BluemagParserException, IOException{
    if(cc instanceof VaridTokens ||
       cc instanceof BooleanTokens ||
       cc instanceof EnteroDecTokens){
	cc = cel.getNextToken();
    }
    else if(cc instanceof PalabrasReservadas){
	if(cc.getString().equals("(")){
	    cc = cel.getNextToken();
	    ExprAnd();
	    if(cc.getString().equals(")")){
		cc = cel.getNextToken();
	    }
	    else throw new BluemagParserException("Se espera ')'", cc);
	}
    }
    else throw new BluemagParserException("Se espera varid, entero, booleano, '('", cc);
    return;
}
}
