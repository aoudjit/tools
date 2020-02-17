/**
 * 
 */
package dz.home.commun.knowledge;


/**
 * @author eaziaou
 *
 */
public class SessionManager {
	

	public static final KnowledgeSession kSession=new KnowledgeSession();

	
	public static KnowledgeSession getKSession(){
		//if(kSession==null)return new KnowledgeSession();
		return kSession;
		
	}

}
