/**
 * 
 */
package dz.home.commun.knowledge;

/**
 * @author eaziaou
 *
 */
public class NoFunction extends Function{

	@Override
	public Object runFunction(String args) {
		// TODO Auto-generated method stub
		 return argProcessing(args);
	}

	@Override
	public String getFunctionName() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object processFunction(String function){
		int indexSession=function.indexOf(SESSION_KEY)+SESSION_KEY.length();
		function=function.substring(indexSession);
		
		String args=function;
		return runFunction(args);
	}

}
