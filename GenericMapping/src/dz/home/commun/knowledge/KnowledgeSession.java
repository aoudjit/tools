/**
 * 
 */
package dz.home.commun.knowledge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eaziaou
 *
 */
public class KnowledgeSession {
	
	private Map<String,Object> session=new HashMap<String,Object>();

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Object getObject(String key){
		return session.get(Thread.currentThread().getId()+"$"+key);
	}
	public void put(String key,Object value){
		
		session.put(Thread.currentThread().getId()+"$"+key, value);
	}

}
