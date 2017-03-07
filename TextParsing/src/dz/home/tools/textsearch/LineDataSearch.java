/**
 * 
 */
package dz.home.tools.textsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import dz.home.commun.parsing.txt.filter.LineDescription;

/**
 * @author eaziaou
 *
 */
/**
 * Line Configuration Format
 * Example "10;antennas|empty;' ';2;'0,1'"
 * 
 * 
 */
public class LineDataSearch implements LineDescription{
	private int lineNumber;
	private String itemName;
	private String itemsSeparator;
	private int itemsNumber;
	private List itemsLocation;
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemsSeparator() {
		return itemsSeparator;
	}
	public void setItemsSeparator(String itemsSeparator) {
		this.itemsSeparator = itemsSeparator;
	}
	public int getItemsNumber() {
		return itemsNumber;
	}
	public void setItemsNumber(int itemsNumber) {
		this.itemsNumber = itemsNumber;
	}
	public List getItemsLocation() {
		return itemsLocation;
	}
	public void setItemsLocation(List itemsLocation) {
		this.itemsLocation = itemsLocation;
	}
	public void addItemLocation(int itemLocation){
		if(itemsLocation==null)itemsLocation=new ArrayList();
		itemsLocation.add(itemLocation);
	}
	@Override
	public String buildType(String line) {
		// TODO Auto-generated method stub
		StringTokenizer tokens=new StringTokenizer(line,itemsSeparator);
		List<String> sTokens=new ArrayList<String>();
		while (tokens.hasMoreTokens()){
			sTokens.add(tokens.nextToken());
		}
		//sTokens.add("test");
		System.out.println("tokens:"+sTokens);
		String result=itemName+sTokens.get((Integer)itemsLocation.get(0));
		for(int i=1;i<itemsLocation.size();i++){
			int index=(Integer)itemsLocation.get(i);
			if(index<sTokens.size())
			result=result+";"+sTokens.get(index);
		}
		return result;
	}
	

}
