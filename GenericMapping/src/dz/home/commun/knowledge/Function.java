/**
 * 
 */
package dz.home.commun.knowledge;

/**
 * @author eaziaou
 *
 */
public abstract class Function {
	
	public static final String SESSION_KEY="session:";
	public static final String FUNCTION_KEY="function:";
	
	public abstract Object runFunction(String args);
	
	public Object processFunction(String function){
		int indexSession=function.indexOf(SESSION_KEY)+SESSION_KEY.length();
		function=function.substring(indexSession);
		int indexFunction=function.indexOf(FUNCTION_KEY)+FUNCTION_KEY.length();
		function=function.substring(indexFunction);
		int indexArgs=function.indexOf(getFunctionName())+getFunctionName().length();
		function=function.substring(indexArgs);
		String args=function.substring(1,function.length()-1);
		return runFunction(args);
	}
	public abstract String getFunctionName();
	public Object argProcessing(String arg){
		if(arg.charAt(0)=='\'')
			return ""+arg.substring(1,arg.length()-1)+"";
		
		return SessionManager.getKSession().getObject(arg);
	}

}
