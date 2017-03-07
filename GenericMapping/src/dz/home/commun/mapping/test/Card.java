package dz.home.commun.mapping.test;

import java.util.HashMap;
import java.util.Map;

public class Card{
	private String Name;
	public Card(String name){
		this.Name=name;
	}
	public Map<String,String> attributes;
	public Card(){
		attributes=new HashMap<String,String>();
	}
	public void addAttribute(String key,String value){
		attributes.put(key, value);
	}
	public String getAttribute(String key){
		return attributes.get(key);
	}
	public int getSize(){
		return attributes.size();
	}
	
	public String toString(){
		StringBuffer buffer=new StringBuffer();
		buffer.append("card:"+Name+"\n");
		for(int i=0;i<getSize();i++)
			buffer.append("key="+attributes.keySet().toArray()[i]+", value="+getAttribute(""+attributes.keySet().toArray()[i])+"\n");
		return buffer.toString();
	}
}