/**
 * 
 */
package dz.home.commun.parsing.txt;

import java.util.HashMap;
import java.util.Map;

import dz.home.commun.parsing.exception.TextException;

/**
 * @author eaziaou
 *
 */
public abstract class DesignFile {
 
  private Map<String,String> attributes;
  public boolean withSeparator;
  public String separator;
  private int headerLineIndex;
  
  public abstract void buildAttributes(String[] lines);
  // order by keys =0, order by values=1
  public void orderAttributes(int order){
	  //attributes.
  }
  
  public void addAttribute(String attributeKey,String attributeValue){
	  if(attributes==null) attributes=new HashMap<String,String>();
	  attributes.put(attributeKey, attributeValue);
  }
  public String getAttributeByKey(String attributeKey){
	  if(attributes==null) attributes=new HashMap<String,String>();
	  return attributes.get(attributeKey);
  }
  public String getAttributeByValue(String value){
	  if(attributes==null) return null;
	  String result=null;
	  
	  for(int index=0;index<attributes.values().size();index++)
		  if(value.equalsIgnoreCase(""+attributes.values().toArray()[index]))
			  return ""+attributes.keySet().toArray()[index];
	  return result;
	  
  }
  public abstract void setWithSeparator();
  public abstract void setSeparator(String separator);
  public  void setHeaderLineIndex(int index){
	  this.headerLineIndex=index;
  }
  public  int getHeaderLineIndex(){
	 return this.headerLineIndex;
  }
  public String getSeparator(){
	  return separator;
  }
  private void setSeparator(String[] lines) throws TextException{
		int index=-1;
		if((index=lines[0].indexOf("separator"))!=-1)
			separator=lines[0].substring(index+10);
		else throw new TextException("DesignFile Not Correct , doesnt contain 'separator=??'");
	}
	  

}
