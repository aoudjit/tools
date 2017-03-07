/**
 * 
 */
package dz.home.tools.textsearch.udtype;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import dz.home.commun.parsing.txt.filter.LineDescription;

/**
 * @author eaziaou
 *
 */
public class PortTextType implements LineDescription{
	private int lineNumber;

	
	public PortTextType(int lineNumber){
		this.lineNumber=lineNumber;
	}
	@Override
	public String buildType(String line) {
		// TODO Auto-generated method stub
		StringTokenizer tokens=new StringTokenizer(line," ");
		String result="";
		List<String> sTokens=new ArrayList<String>();
		while(tokens.hasMoreTokens()){
			sTokens.add(tokens.nextToken());
			
		}
		System.out.println("tokens:"+sTokens);
		result=sTokens.get(2)+sTokens.get(3)+sTokens.get(4)+";"+sTokens.get(5)+sTokens.get(6)+sTokens.get(7);
		return result;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	

}
