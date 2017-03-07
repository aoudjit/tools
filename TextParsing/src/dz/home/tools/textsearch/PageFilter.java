/**
 * 
 */
package dz.home.tools.textsearch;

import java.util.ArrayList;
import java.util.List;

import dz.home.commun.parsing.txt.filter.Filter;
import dz.home.commun.parsing.txt.filter.LineDescription;

/**
 * @author eaziaou
 *
 */
/**
 * File Configuration Format
 * page_lenth=70
 * "unknown;10;antennas;' ';2;'0,1'"
 * "19;empty;' ';2;'0,1'"
 * "17;empty;' ';2;'0,1'"
 */
public class PageFilter implements Filter{
	private int pageLength;
	
	
	private List<LineDescription> lineConfiguration;
	public int getPageLength() {
		return pageLength;
	}
	public void setPageLength(int pageLength) {
		this.pageLength = pageLength;
	}
	public List<LineDescription> getLineConfiguration() {
		return lineConfiguration;
	}
	public void setLineConfiguration(List<LineDescription> lineConfiguration) {
		this.lineConfiguration = lineConfiguration;
	}
	public void addLineConfiguration(LineDescription line){
		if(lineConfiguration==null)lineConfiguration=new ArrayList<LineDescription>();
		lineConfiguration.add(line);
		
	}
	public LineDescription getLineConfiguration(int index){
		if(lineConfiguration==null) return null;
		return lineConfiguration.get(index);
	}
	
	

}
