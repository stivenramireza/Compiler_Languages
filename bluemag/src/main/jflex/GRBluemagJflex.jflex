/* Analizador lexico para el lenguaje Jay - Tucker y Nan */
package co.edu.eafit.dis.st0270.s2017.bluemag.lexer;

import co.edu.eafit.dis.st0270.s2017.bluemag.tokens.*;

%%
%class GRBluemagLexer
%unicode
%line
%column
%function getNextToken
%type GRToken
%public
%{
public int obtenerLinea() {
   return yyline;
}
%}

LineTerminator = \r | \n | \r\n

WhiteSpace     = {LineTerminator} | [\t\n\f\r] | \v | " "

BOOLEANO = "verdad" | "falso"

VARID = [a-z]([a-z] | [A-Z] | [0-9])*

ID = [A-Z]([a-z] | [A-Z] | [0-9])*

ENTERO = ([1-9][0-9]* | 0)

keyword = "clase" | "solicitar" | "cuando" | "si" | "ent" | "sino" | "finsi" | "mientras" | "hacer" | ";" | "<-"

operador = "y" | "<=" | "=" | "+" | "*" | "no" | "(" | ")" 

%%

<YYINITIAL> {
   {WhiteSpace}                  { /* Ignore */ }
   {BOOLEANO}					      {return new BooleanTokens(yytext(), yyline, yycolumn);}
   {ENTERO}                      { return new EnteroDecTokens(yytext(), yyline, yycolumn); }
   {keyword}                     { return new PalabrasReservadas(yytext(), yyline, yycolumn); }
   {ID}                          { return new IDTokens(yytext(), yyline, yycolumn); }
   {VARID}                       { return new VaridTokens(yytext(),yyline, yycolumn);  }
   {operador}                    { return new OperadorTokens(yytext(), yyline, yycolumn); }
   "{"                           { return new LlaveITokens( yyline, yycolumn); }
   "}"                           { return new LlaveDTokens( yyline, yycolumn); }
   "|"                           { return new ORDTokens( yyline, yycolumn);}
	}

((_)|[0-9]|[a-zA-Z])+         { throw new Error("Identificador invalido: " + yytext() + " linea: " + (yyline + 1) + " columna: " + yycolumn); }

<<EOF>>              		  { return new EndofStringTokens();}

