/**
 * 
 */
package dz.home.commun.tools;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import dz.home.commun.mapping.domain.AddField;
import dz.home.commun.mapping.domain.DeclareVariable;
import dz.home.commun.mapping.domain.FileKey;
import dz.home.commun.mapping.domain.Function;
import dz.home.commun.mapping.domain.Mapping;
import dz.home.commun.mapping.domain.Mappings;
import dz.home.commun.mapping.domain.Parameter;



/**
 * @author eaziaou
 *
 */
public class MappingTools {
	public static final Logger log=Logger.getLogger(MappingTools.class);
	public static void setObject(Object object,String path,Object value){
		if(path!=null){
			//List listTokens=parseString(path, ".");
			
		}
	}
	
	public static Object createObjectWithConstructor(String name,Object ...args  ){
		try {
			Class clazz=	Class.forName(name);
			try {
				Constructor constructor=clazz.getConstructor((Class)args[0]);
				try {
					log.debug("create Object:"+name);
					return constructor.newInstance(args[1]);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static Object createObject(String name,Object ...args ){
		if(args!=null && args.length>1)
			return createObjectWithConstructor(name, args);
	try {
		Class clazz=	Class.forName(name);
		Object result;
		try {
			result = clazz.newInstance();
			return result;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
		
	}
	private static List parseString(String text,String separator){
		List result=new ArrayList();
		StringTokenizer tokens=new StringTokenizer(text,separator);
		while(tokens.hasMoreTokens());
		result.add(tokens.nextToken());
		
		return result;
		
	}
	
	private static Object instanciateObject(Object object,String fieldName){
		Method setMethod=null;
		Method getMethod=null;
		try {
			setMethod=object.getClass().getDeclaredMethod("set"+firstUpperCase(fieldName));
			getMethod=object.getClass().getDeclaredMethod("get"+firstUpperCase(fieldName));
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private static String firstUpperCase(String text){
		String result=null;
		if(text!=null && text.length()>1)
			result=text.substring(0,1).toUpperCase()+text.substring(1);
			return result;
			
	}
	private static Method getMethod(Class clazz,String method,Object... params){
		Method m=null;
		
		try {
			
			m=clazz.getDeclaredMethod(method, (Class[])params[0]);
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			try {
				//System.out.println("Object className="+clazz.getName());
				if(!clazz.getName().equalsIgnoreCase("java.lang.Object"))
				m=getMethod(clazz.getSuperclass(), method, params);
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
		}
		return m;
	}
	public static void updateObject(Object object,String method,Object... params ){
		//log.debug("updateObject :O="+object+",m="+method+",v="+params);
		Method m=null;
			
		/*try {
			m=object.getClass().getDeclaredMethod(method, (Class[])params[0]);
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			try {
				m=object.getClass().getSuperclass().getDeclaredMethod(method, (Class[])params[0]);
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}*/
		m=getMethod(object.getClass(), method, params);
		try {
			Object[] value=(Object[])params[1];
			if(m!=null){
							
			//log.debug("UpdateObject "+object+" with value :"+value+"[class=]"+value.getClass().getCanonicalName());
				if(value!=null && value.length>0){
				   boolean valueNull=false;
				   for(Object obj:value){
					   if(obj==null || obj.toString().equalsIgnoreCase("null") || obj.toString().isEmpty() ) valueNull=true;
				   }
				   if(!valueNull){
					  
						   m.invoke(object, value);
					  
			      
				   }
				}
			}
			else
				;//log.debug("UpdateObject No Method:"+method+",Object:"+object+",value:"+value);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage()+"->"+method+":"+((params!=null && params.length>1)?params[1].toString():null));
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage()+"->"+method+":"+((params!=null && params.length>1)?params[1].toString():null));
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage()+"->"+method+":"+((params!=null && params.length>1)?params[1].toString():null));
		}
	}
	
	public static Object getObject(Object object,String methodName,Class[] parameterTypes,Object[] parameterValues){
		Object obj=object;
		List<String> __tokens=new ArrayList<String>();
		StringTokenizer tokens=new StringTokenizer(methodName,".");
		while(tokens.hasMoreTokens()){
			__tokens.add(tokens.nextToken());
		}
		//log.debug("token:"+__tokens);
		int index=__tokens.size();
		if(index==1) {
			return getObjectValue(object, methodName, parameterTypes, parameterValues);
		}
		obj=getObjectValue(object, __tokens.get(0), parameterTypes, parameterValues);
		String __methodName="";
		for(int i=1;i<index;i++)
			if(i==1)
			__methodName=__methodName+__tokens.get(i);
			else __methodName=__methodName+"."+__tokens.get(i);
		obj=getObject(obj, __methodName, parameterTypes, parameterValues) ;
		
		return obj;
		
	}
	public static Object getObjectValue(Object object,String methodName,Class[] parameterTypes,Object[] parameterValues){
		
		if(methodName.equalsIgnoreCase("this")){
			return object;
		}
		Method m=null;
		try {
			if(parameterTypes==null)
				m=object.getClass().getDeclaredMethod(methodName);
			else
			m=object.getClass().getDeclaredMethod(methodName, parameterTypes);

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			try {
				if(parameterTypes==null)
					m=object.getClass().getSuperclass().getDeclaredMethod(methodName);
				else
				m=object.getClass().getSuperclass().getDeclaredMethod(methodName, parameterTypes);
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			if(m!=null)
				if(parameterTypes==null && parameterValues==null)
					return  m.invoke(object);
			return m.invoke(object, parameterValues);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	public static Mapping getMappingByType(String type,Mappings mappings){
		for(Mapping mapping:mappings.getMapping()){
			if(type.equalsIgnoreCase(mapping.getType()))
				return mapping;
		}
	return null;	
	}
	public static Parameter getParameterByName(List<Parameter> parameters,String paramName){
		for(Parameter param:parameters)
			if(paramName.equalsIgnoreCase(param.getName()))
				return param;
		return null;
	}
	public static Function getFunctionByName(List<Function> functions , String functionName){
		for(Function function:functions){
			if(functionName.equalsIgnoreCase(function.getName()))
				return function;
			
		}
		return null;
	}
	public static Class getClass(String type){
		/*
		 * Pickup list
Text
MultiLine
date
Decimal
Latitude
Longitude
Character

		 */
		if("string".equalsIgnoreCase(type))
			return String.class;
		if("Object".equalsIgnoreCase(type))
			return Object.class;
		if("BigDecimal".equalsIgnoreCase(type))
			return BigDecimal.class;
		if("BigInteger".equalsIgnoreCase(type))
			return BigInteger.class;
		if("Pickup list".equalsIgnoreCase(type))
			return String.class;
		if("Text".equalsIgnoreCase(type))
			return String.class;
		if("MultiLine".equalsIgnoreCase(type))
			return String.class;
		if("date".equalsIgnoreCase(type))
			return Date.class;
		if("Decimal".equalsIgnoreCase(type))
			return BigDecimal.class;
		if("Latitude".equalsIgnoreCase(type))
			return String.class;
		if("Longitude".equalsIgnoreCase(type))
			return String.class;
		if("Character".equalsIgnoreCase(type))
			return String.class;
		if("Double".equalsIgnoreCase(type))
			return Double.class;
		return String.class;
		
	}
	
	public static String getTextFileKey(Mappings mappings,String textFileName){
		for(FileKey fileKey:mappings.getExternalObjectInput().getFilesKeys().getFileKey())
			if(textFileName.equalsIgnoreCase(fileKey.getName()))
					return fileKey.getKey();
		return "Null";
			
	}
	public static String getTextFileField(Mappings mappings,String fieldOrder){
		for(AddField addField:mappings.getExternalObjectInput().getFileRelationShip().getAddField())
			if(fieldOrder.equalsIgnoreCase(""+addField.getOrder()))
					return addField.getName();
		return "Null";
			
	}
	public static String getVarByKey(Mappings mappings,String varKey){
		for(DeclareVariable var:mappings.getVariableDeclaration().getDeclareVariable())
			if(varKey.equalsIgnoreCase(""+var.getKey()))
					return var.getName();
		return "Null";
			
	}
	
	public static Object getNormalizeValue(Class clazz,Object value){
		/** AZE */
		if(clazz== Double.class){
			 
			  try{
			  return new Double(""+value); 
			  }catch(Exception exp){
				 log.error("ERROR Normalization:"+clazz+"->"+value+" cause:"+exp.getMessage());
				  
				 return "0";
			  }
		  
	    } 
		if(clazz== BigInteger.class){
			 
			  try{
			  return new BigInteger(""+value); 
			  }catch(Exception exp){
				 log.error("ERROR Normalization:"+clazz+"->"+value+" cause:"+exp.getMessage());
				  
				 return "0";
			  }
		  
	    }
		 
		 if(clazz== String.class){
			 
			  try{
				  if(value instanceof BigDecimal){
						return ((BigDecimal)value).doubleValue();  
					  }
			  return ""+value; 
			  }catch(Exception exp){
				  exp.printStackTrace();
				  return value;
			  }
		  
	    }
		 if(clazz== Date.class){
			 
			  try{
			  return new Date(""+value); 
			  }catch(Exception exp){
				  exp.printStackTrace();
				  return value;
			  }
		  
	    }
		 if(clazz== XMLGregorianCalendar.class){
			 
			  try{
			  return  DatatypeFactory.newInstance().newXMLGregorianCalendar(""+value); 
			  }catch(Exception exp){
				  exp.printStackTrace();
				  return value;
			  }
		  
	    }
		 if(clazz== BigDecimal.class){
			 
			  try{
			  return  new BigDecimal(""+value); 
			  }catch(Exception exp){
				  exp.printStackTrace();
				  return value;
			  }
		  
	    }
		return value;
	}
	

}

