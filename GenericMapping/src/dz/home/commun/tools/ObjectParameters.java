/**
 * 
 */
package dz.home.commun.tools;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author eaziaou
 *
 */
public final class ObjectParameters {
  public  Class[] classParams;
  public  Object[] objectParams;
  public int semaphore=0;
  
  
  
  public ObjectParameters(int size){
	  classParams=new Class[size];
	  objectParams=new Object[size];
  }
  public synchronized void addClassParam(Class param){
	  classParams[semaphore]=param;
  }
  public synchronized void addObjectParam(Object param){
	 
	  objectParams[semaphore]=MappingTools.getNormalizeValue(classParams[semaphore], param);
	  semaphore++;
  }
public Class[] getClassParams() {
	return classParams;
}
public Object[] getObjectParams() {
	return objectParams;
}
  
  
}
