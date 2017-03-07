package dz.home.commun.mapping.test;

import java.util.HashMap;
import java.util.Map;

public class GenericObjectTest{
	public Map<String,String> fields;
	public GenericObjectTest(){
		fields=new HashMap<String,String>();
	}
	public void addAttribute(String key,String value){
		fields.put(key, value);
	}
	public String getField(String key){
		return fields.get(key);
	}
}
