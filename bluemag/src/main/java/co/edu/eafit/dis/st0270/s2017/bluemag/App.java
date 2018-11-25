package co.edu.eafit.dis.st0270.s2017.bluemag;

import co.edu.eafit.dis.st0270.s2017.bluemag.parser.*;
import co.edu.eafit.dis.st0270.s2017.bluemag.tokens.*;
import co.edu.eafit.dis.st0270.s2017.bluemag.lexer.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.StringBufferInputStream;
import java.io.InputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.BitSet;


public class App {

   static String inputFile = null;
   static BufferedReader buffer = null;
   static boolean errorParser = false;
   static boolean errorLexer = false;
   static RecognitionException exceptionParser = null;
   static RecognitionException exceptionLexer  = null;

    
   static class ParserAppAntlrErrorListener
      extends BaseErrorListener {
      public void syntaxError(Recognizer<?,?> recognizer,
                              Object offendingSymbol,
                              int line, int charPositionInLine,
                              String msg,
                              RecognitionException e)
      {   
         //System.err.println("Error en la expresión: " + e);
         App.errorParser = true;
         App.exceptionParser = e;
      }
   }

   static class LexerAppAntlrErrorListener
      extends BaseErrorListener {
      public void syntaxError(Recognizer<?,?> recognizer,
                              Object offendingSymbol,
                              int line, int charPositionInLine,
                              String msg,
                              RecognitionException e)
      {
         App.errorLexer = true;
         App.exceptionLexer = e;
      }
   }

	/**
	* Método que imprime el manual de uso de la aplicación.
	*/
    public static void uso() {
	System.err.println("Uso: java co.edu.eafit.st270.s2017.bluemag.App [manual | auto | manual_auto] Fichero");
	System.exit(1);
    }

    /**
    * Método principal de la aplicación que lee un argumento indicando
    * la acción a ejecutar y el fichero con la expresión a evaluar.
    * @param args
    */
    public static void main(String args[]) {
	if (args.length >= 1) {
		try{
			if(args[0].equals("manual")){
				for (int i = 1; i < args.length; i++) {
				inputFile = args[i];
				String nameFile = args[i].substring(0, args[i].indexOf('.'));
				System.out.print(nameFile + " ");
				analizadorJFLEX(inputFile);
				}
			}else if(args[0].equals("auto")){
				for (int i = 1; i < args.length; i++) {
				inputFile = args[i];
				String nameFile = args[i].substring(0, args[i].indexOf('.'));
				System.out.print(nameFile + " ");
				analizadorANTLR(inputFile);
				}
			}else if(args[0].equals("manual_auto")){
				for (int i = 1; i < args.length; i++) {
				inputFile = args[i];
				String nameFile = args[i].substring(0, args[i].indexOf('.'));
				System.out.print(nameFile + " ");
				analizadorJFLEX(inputFile);
				System.out.print(nameFile + " ");
				analizadorANTLR(inputFile);
				}
			}else if(!args[0].equals("manual")){
				for (int i = 0; i < args.length ; i++ ) {
				inputFile = args[i];
				String nameFile = args[i].substring(0, args[i].indexOf('.'));
				System.out.print(nameFile + " ");
				analizadorJFLEX(inputFile);
				}
			}
	 }catch(Exception e){
    System.err.println(e);
   }
   }else{
    uso();
   }
 }

   public static String read(String fileName) throws FileNotFoundException, IOException{
   	String input = "";
   	String tmp;
   	FileReader file = new FileReader(fileName);
   	BufferedReader buffer = new BufferedReader(file);
   	while((tmp = buffer.readLine())!=null){
   		input += " "+tmp;
   	}
   	buffer.close();
   	return input;
   }

   public static void analizadorJFLEX(String fileName){
      try{
      BluemagParserGen analizadorJFLEX = new BluemagParserGen();
      analizadorJFLEX.parser(read(fileName));
      System.out.println("valido");
      
    }catch(Exception e){
     System.out.println("invalido");
      //System.err.println(e.getMessage());
      //System.exit(3);
    }
   }

   public static void analizadorANTLR(String inputFile){
   		InputStream is = System.in;
	
      try {

         if (inputFile != null) is = new FileInputStream(inputFile);
	
         ANTLRInputStream input = new ANTLRInputStream(is);
	    
         BluemagAntlrLexer lexer = new BluemagAntlrLexer(input);
         lexer.removeErrorListeners();
         lexer.addErrorListener(new LexerAppAntlrErrorListener());

         CommonTokenStream tokens = new CommonTokenStream(lexer);

         BluemagAntlrParser parser = new BluemagAntlrParser(tokens);
         parser.removeErrorListeners();
         parser.addErrorListener(new ParserAppAntlrErrorListener());

         ParseTree tree = parser.gramManRec();

         if (errorLexer || errorParser) {
            System.out.println("invalido");
            System.exit(1);
         }
         else {
      System.out.println("valido");
         }

      } catch (RecognitionException re) {

         //System.err.println("Invalid expression line: " + re.getOffendingToken().getLine() +
                            //" col: " + re.getOffendingToken().getCharPositionInLine() +
                            //" type: " + re.getOffendingToken().getType()); 
         //System.exit(1);
      } catch (Exception e) {

         //System.err.println("Exception class: " + e.getClass().toString());
         PrintWriter errWriter = new PrintWriter(System.err);
         //e.printStackTrace(errWriter);
         //System.exit(1);
      }
   }

}
