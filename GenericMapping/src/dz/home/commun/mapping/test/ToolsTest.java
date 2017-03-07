/**
 * 
 */
package dz.home.commun.mapping.test;

/**
 * @author eaziaou
 *
 */
public class ToolsTest {
	
	public String getRefData(String args1,String args2){
		return "isReferenced";
	}
	public String getCategoryData(String args1){
		if("sral xd".equalsIgnoreCase(args1))
		return "isReferenced";
		return null;
	}

}
