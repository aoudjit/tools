/**
 * 
 */
package dz.home.commun.parsing.txt.filter;

/**
 * @author eaziaou
 *
 */
public interface LineDescription {
	
	public int getLineNumber();
	public void setLineNumber(int lineNumber);
	public String buildType(String line);

}
