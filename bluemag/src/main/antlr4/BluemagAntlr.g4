grammar BluemagAntlr;

@header{
package co.edu.eafit.dis.st0270.s2017.bluemag.parser;
}

 
gramManRec:manRec EOF
    ;
manRec:declaraciones instrucciones
    ;

declaraciones:('clase' ID ENTERO ';')+
    ;

instrucciones: instruccion*
             ;

instruccion:'solicitar' ID restInstruccion
           |bloque
           |asignacion
           |condicional
           |ciclo
        ;

restInstruccion:'cuando' exprAnd bloque
               | bloque
	       ;

bloque: '{' restBloque
      ;

restBloque:declVars  instrucciones '}'
          | instrucciones '}'
          ;

asignacion: VARID '<-' exprAnd ';'
           ;

condicional: 'si' exprAnd 'ent' instruccion restCondicional
           ;
restCondicional:'sino' instruccion 'finsi'
               |'finsi'
               ;
ciclo: 'mientras' exprAnd 'hacer' instruccion
     ;
declVars:'|' VARID+ '|'
        ;

/*AND='y'*/

exprAnd:exprMenIgual restExprAndPR
       ;
restExprAnd:'y' exprMenIgual restExprAndPR
           ;
restExprAndPR:restExprAnd
             |
             ;

/*MenIgual='<='*/

exprMenIgual:exprIgual restExprMenIgualPR
            ;
restExprMenIgual:'<=' exprIgual restExprMenIgualPR
                ;
restExprMenIgualPR:restExprMenIgual
                  |
                  ;

/*Igual='='*/

exprIgual:exprSum restExprIgualPR
         ;
restExprIgual: '=' exprSum restExprIgualPR
             ;
restExprIgualPR: restExprIgual
               |
               ;
/*sum='+'*/


exprSum:exprMul restExprSumPR
       ;
restExprSum:'+' exprMul restExprSumPR
           ;
restExprSumPR:restExprSum
             |
             ;

/*mult='*' */

exprMul: negation restExprMulPR
       ;
restExprMul:'*' negation restExprMulPR
           ;
restExprMulPR: restExprMul
             |
             ;

/*Negation:'no'*/

negation: 'no' factor
        | factor
        ;

factor:VARID
      |ENTERO
      |BOOLEANO
      |'('exprAnd')'
      ;

VARID: ('a'..'z')(('a'..'z') | ('A'..'Z') | ('0'..'9'))*
     ;

ID:('A'..'Z')(('a'..'z') | ('A'..'Z') | ('0'..'9'))*
  ;

BOOLEANO: 'verdad'
        | 'falso'
        ;

ENTERO: (('1'..'9')('0'..'9')* | '0')
      ;

WS: ( ' ' | '\t' | '\n' | '\r' ) + {skip(); }
  ;