/**
 * 
 */
package dz.home.tools.textsearch;

import dz.home.commun.parsing.txt.filter.Filter;
import dz.home.commun.search.txt.TextSearch;
import dz.home.tools.textsearch.udtype.TypeText;

/**
 * @author eaziaou
 *
 */
public class PageTextSearch extends TextSearch{

	@Override
	public String applyFilter(Filter filter, String line, int lineNumber) {
		// TODO Auto-generated method stub
		for(int i=0;i<((PageFilter)filter).getLineConfiguration().size();i++){
		if(lineNumber==((PageFilter)filter).getLineConfiguration(i).getLineNumber()){
				
		return (((PageFilter)filter).getLineConfiguration(i)).buildType(line);
		}
		
		}
		
		return null;
			
				
	}
	
	

}
