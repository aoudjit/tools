/**
 * 
 */
package dz.home.tools.textsearch.udtype;

import dz.home.commun.parsing.txt.filter.LineDescription;

/**
 * @author eaziaou
 *
 */
public abstract class TypeText implements LineDescription{
	
	public abstract String buildType(String line);

}
