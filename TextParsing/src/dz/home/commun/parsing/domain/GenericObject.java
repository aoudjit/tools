/**
 * 
 */
package dz.home.commun.parsing.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dz.home.commun.parsing.txt.DesignFile;



/**
 * @author eaziaou
 *
 */
public abstract class GenericObject {
	

	private Map<String,Object> fields;
	
	public GenericObject(){
		if(fields==null) fields=new HashMap<String,Object>();
		
	}
	public void addField(String fieldName,Object value){
		fields.put(fieldName.trim(),value);
		
	}
	
	public Object getField(String fieldName){
		return fields.get(fieldName);
	}
	 public Object getFieldByIndex(int indexField){
		  if(fields==null) return null;
		  return fields.get(fields.keySet().toArray()[indexField]);
		 
		  
	  }
	public  abstract void buildFields(String line,DesignFile design);
	public  abstract void buildFields(String line);
	public  abstract boolean buildFields(String line,DesignFile design,List<String> filters);
	public  abstract void buildFields(String line,String separator,List<String> filters);
	public Map getFields(){
		return this.fields;
	}
	public boolean isEmpty(){
		if(fields.size()==0)return true;
		return false;
	}
	
	public String toString(){
		
		StringBuffer buffer=new StringBuffer();
		buffer.append("\n[Object :");
		for(int i=0;i<fields.keySet().size();i++)
			buffer.append(";key="+fields.keySet().toArray()[i]+", value="+getField(""+fields.keySet().toArray()[i]));
		buffer.append("]\n");
		return buffer.toString();
	}

}
