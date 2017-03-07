/**
 * 
 */
package dz.home.commun.knowledge;

import java.util.StringTokenizer;

/**
 * @author eaziaou
 *
 */
public class ConcatenationFunction extends Function{
	
	

	@Override
	public Object runFunction(String args) {
		// TODO Auto-generated method stub
		String result="";
		StringTokenizer tokens=new StringTokenizer(args,",");
		if(!tokens.hasMoreTokens()) return args;
		while(tokens.hasMoreTokens())
			result=result+argProcessing(tokens.nextToken());
		return result;
	}

	@Override
	public String getFunctionName() {
		// TODO Auto-generated method stub
		return "CONCAT";
	}
	
	public static void main(String args[]){
		ConcatenationFunction concatenationFunction = new ConcatenationFunction();
		System.out.println(concatenationFunction.processFunction("session:function:CONCAT(subslotName)").toString());
	}

}
