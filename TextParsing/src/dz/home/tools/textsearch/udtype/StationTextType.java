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
public class StationTextType implements LineDescription{
	private int lineNumber;

	
	public StationTextType(int lineNumber){
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
		if(sTokens.size()>4){
			String temp="";
			for(int j=1;j<sTokens.size()-1;j++)
				temp=temp+sTokens.get(j);
			if(sTokens.get(sTokens.size()-1).indexOf("/")==-1)
				temp=temp+";"+sTokens.get(sTokens.size()-1);
			else
			temp=temp+sTokens.get(sTokens.size()-1).replaceFirst("/", ";");
		result=/*sTokens.get(1)+";"+*/temp;//sTokens.get(2)+sTokens.get(3).replace('/', ';');
		}
		else
			if(sTokens.size()>=3)
		result=sTokens.get(1)+";"+sTokens.get(2)/*.replaceFirst("/", ";")*/;
			else result=sTokens.get(1)+";"+" ; ";
				
		return result;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	

}
