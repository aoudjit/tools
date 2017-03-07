/**
 * 
 */
package dz.home.commun.parsing.exception;

/**
 * @author eaziaou
 *
 */
public class TextException extends Exception{

	
	public TextException(String errorTxt){
		System.err.append("TextExceptionClass -> "+errorTxt);
	}
}
