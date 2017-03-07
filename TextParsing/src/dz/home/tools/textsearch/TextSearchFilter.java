/**
 * 
 */
package dz.home.tools.textsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import dz.home.commun.parsing.txt.filter.AbstractFilter;
import dz.home.commun.parsing.txt.filter.Filter;
import dz.home.commun.parsing.txt.filter.LineDescription;
import dz.home.tools.textsearch.udtype.LinkTextType;
import dz.home.tools.textsearch.udtype.PortTextType;
import dz.home.tools.textsearch.udtype.StationTextType;

/**
 * @author eaziaou
 *
 */
public class TextSearchFilter extends AbstractFilter{
    private PageFilter page;
	
	@Override
	public LineDescription readLine(String line) {
		// TODO Auto-generated method stub
		int pageLength=-1;
		if((pageLength=line.indexOf("page_lenth"))!=-1)
			page.setPageLength(pageLength);
		else{
			
			StringTokenizer tokens=new StringTokenizer(line,";");
			List<String> sTokens=new ArrayList<String>();
			while(tokens.hasMoreTokens())
				sTokens.add(tokens.nextToken());
			LineDescription lineDS=buildLineDescription(sTokens);
			page.addLineConfiguration(lineDS);
			return lineDS;
			
		}
		return null;
	}
	
	private List buildItemsLocation(String items){
		String cleanString=items.replace('\'', ' ').trim();
		StringTokenizer tokens=new StringTokenizer(cleanString,",");
		List results=new ArrayList();
		while(tokens.hasMoreTokens()){
			results.add((new Integer(tokens.nextToken())).intValue());
		}
		return results;
	}
	private LineDescription buildLineDescription(List<String> sTokens){
		if("unknown".equalsIgnoreCase(sTokens.get(0))){
			LineDataSearch lineDS=new LineDataSearch();
			lineDS.setLineNumber((new Integer(sTokens.get(1))));
			lineDS.setItemName(sTokens.get(2));
			lineDS.setItemsSeparator(sTokens.get(3).replace('\'', (char)(0)));
			lineDS.setItemsNumber((new Integer(sTokens.get(4))));
			lineDS.setItemsLocation(buildItemsLocation(sTokens.get(5)));
			return lineDS;
		}else if("port".equalsIgnoreCase(sTokens.get(0))){
			PortTextType lineDS=new PortTextType((new Integer(sTokens.get(1))).intValue());
			return lineDS;
		}else if("link".equalsIgnoreCase(sTokens.get(0))){
			LinkTextType lineDS=new LinkTextType((new Integer(sTokens.get(1))).intValue());
			return lineDS;
		}else if("station".equalsIgnoreCase(sTokens.get(0))){
			StationTextType lineDS=new StationTextType((new Integer(sTokens.get(1))).intValue());
			return lineDS;
		}
			return null;
	}

	public PageFilter getPage() {
		return page;
	}

	public void setPage(PageFilter page) {
		this.page = page;
	}
	

}
