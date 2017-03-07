/**
 * 
 */
package dz.home.commun.parsing;

import dz.home.commun.parsing.txt.DesignFile;

/**
 * @author eaziaou
 *
 */
public class ParsingFileBuilder {
	
	
	public Object buildParsingFile(FileParsing fileParsing,DesignFile design){
		return fileParsing.processData(design);
	}

}
