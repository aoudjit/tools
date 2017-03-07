/**
 * 
 */
package dz.home.commun.tools;

import java.util.List;

import dz.home.commun.knowledge.ConcatenationFunction;
import dz.home.commun.knowledge.NoFunction;
import dz.home.commun.knowledge.SessionManager;
import dz.home.commun.mapping.domain.Attribute;
import dz.home.commun.mapping.domain.Function;
import dz.home.commun.mapping.domain.InputParam;
import dz.home.commun.mapping.domain.Mapping;
import dz.home.commun.mapping.domain.Mappings;
import dz.home.commun.mapping.domain.Parameter;

/**
 * @author eaziaou
 *
 */
public class ObjectCreator {
	private Mappings mappings;
	private String defaultPackage;
	private static final String INTERNAL_PARAM="internal:";
	private static final String EXTERNAL_PARAM="external:";
	private static final String FUNCTION_PARAM="function:";
	private static final String FUNCTION_CONCAT_PARAM="CONCAT";
	private static final String SESSION_PARAM="session:";
	public Object createObject(String type,Object externalObject,Object internalObject){
		if(internalObject==null)return createObject(type,externalObject);
		Mapping mapping=MappingTools.getMappingByType(type, mappings);
		for(Attribute attribute:mapping.getAttributes().getAttribute())
			processAttribute(internalObject,externalObject,attribute);
		return internalObject;
	}
	public Object createObject(String type,Object externalObject){
		Mapping mapping=MappingTools.getMappingByType(type, mappings);
		Object object=null;
		//if(!mapping.getInternalObject().equalsIgnoreCase(externalObject.getClass().getName()))
		if(mapping.getParamType()!=null){
			Object[] parameterValues=new Object[2];
			Class[] parameterTypes={MappingTools.getClass(mapping.getParamType())};
			Object param=mapping.getParamValue();
			if(mapping.getParamValue().indexOf(SESSION_PARAM)!=-1){
				param=mapping.getParamValue().substring(mapping.getParamValue().indexOf(SESSION_PARAM)+SESSION_PARAM.length());
			    param=SessionManager.getKSession().getObject((String)param);
			}
			parameterValues[0]=	MappingTools.getClass(mapping.getParamType());
		 parameterValues[1]=param;
		 object=MappingTools.createObject(mapping.getInternalObject(),parameterValues);
		}else{
		object=MappingTools.createObject(mapping.getInternalObject());
		}
		for(Attribute attribute:mapping.getAttributes().getAttribute())
			processAttribute(object,externalObject,attribute);//attribute.getParameters().getInternalParameters().getParameter().get(0).getType();
		//MappingTools.updateObject(object, method, params)
		return object;
	}
	
	public void init(String mappingFileName){
		
	mappings=(Mappings) MarshallerUnmarshaller.Unmarshaller(mappingFileName,MarshallerUnmarshaller.CONTEXT)	;
	}
	private void processAttribute(Object object,Object externalObject,Attribute attribute){
		if(externalObject!=null){
		if(attribute.getParameters()!=null && attribute.getParameters().getInternalParameters()!=null )
		for(Parameter param:attribute.getParameters().getInternalParameters().getParameter())
			processParameter(object,externalObject,attribute,param);
		else{
			
		}
		}
			
	}
	private void processParameter(Object object,Object externalObject,Attribute attribute,Parameter parameter){
		String internalAttribute =attribute.getInternalAttribute();
		
		int sizeInternalParam=attribute.getParameters().getInternalParameters().getParameter().size();
		
		
		Object[] objectInternalParams=new Object[sizeInternalParam];
		
		
		ObjectParameters objectParameters=getObjectParameters(objectInternalParams, externalObject, attribute, parameter);
		
		MappingTools.updateObject(object, internalAttribute, objectParameters.getClassParams(),objectParameters.getObjectParams());
			
		
	}
	private Object getSessionObjectParameters(Parameter param){
		if(param.getValue().indexOf(FUNCTION_PARAM)!=-1){
			if(param.getValue().indexOf(FUNCTION_CONCAT_PARAM)!=-1){
				ConcatenationFunction concatenationFunction=new ConcatenationFunction();
				return concatenationFunction.processFunction(param.getValue());
			}else return null;
		}else{
			NoFunction noFunction=new NoFunction();
			return noFunction.processFunction(param.getValue());
		}
		
	}
	private ObjectParameters getObjectParameters(Object object,Object externalObject,Attribute attribute,Parameter parameter){
		
		String externalAttribute=attribute.getExternalAttribute();
		int sizeInternalParam=attribute.getParameters().getInternalParameters().getParameter().size();
		ObjectParameters objectParameters=new ObjectParameters(sizeInternalParam);
		
		
		for(int i=0;i<sizeInternalParam;i++)
		{
			Parameter param=attribute.getParameters().getInternalParameters().getParameter().get(i);
			objectParameters.addClassParam(MappingTools.getClass(param.getType()));
			if(param.getValue().indexOf(SESSION_PARAM)!=-1){
				objectParameters.addObjectParam(getSessionObjectParameters( param));
			}else
			if(param.getValue().indexOf(INTERNAL_PARAM)==-1 && param.getValue().indexOf(EXTERNAL_PARAM)==-1 && param.getValue().indexOf(FUNCTION_PARAM)==-1)
				objectParameters.addObjectParam(param.getValue());
			else if(param.getValue().indexOf(EXTERNAL_PARAM)!=-1){
				if(param.getValue().substring(param.getValue().indexOf(EXTERNAL_PARAM)+EXTERNAL_PARAM.length()).length()==0){
					Object obj=MappingTools.getObject(externalObject, externalAttribute,null,null);	
					objectParameters.addObjectParam(obj);
				}else{
				Parameter externalParameter=MappingTools.getParameterByName(attribute.getParameters().getExternalParameters().getParameter(), param.getValue().substring(param.getValue().indexOf(EXTERNAL_PARAM)+EXTERNAL_PARAM.length()));
				if(externalParameter!=null){
				Class[] parameterTypes={MappingTools.getClass(externalParameter.getType())};
				Object[] parameterValues={externalParameter.getValue()};
				Object obj=MappingTools.getObject(externalObject, externalAttribute, parameterTypes, parameterValues);
				
				objectParameters.addObjectParam(obj);
				}
				}
			}else if(param.getValue().indexOf(FUNCTION_PARAM)!=-1){
				String functionName= param.getValue().substring(param.getValue().indexOf(FUNCTION_PARAM)+FUNCTION_PARAM.length());
				objectParameters.addObjectParam(processMethodParameter(object,externalObject,attribute, functionName));
				
			}
			
				
		}
		
		
		return objectParameters;	
	}
	private Object processMethodParameter(Object object,Object externalObject,Attribute attribute,String functionName){
		Function function=MappingTools.getFunctionByName(attribute.getParameters().getInternalParameters().getFunction(),functionName);
		Object externalObjectFunction=MappingTools.createObject(function.getObjectClass());
		ObjectParameters objectParameters=new ObjectParameters(function.getInputParam().size());
		List<InputParam> inputParams=function.getInputParam();
		for(int i=0;i<inputParams.size();i++){
			objectParameters.addClassParam(MappingTools.getClass(inputParams.get(i).getType()));
			if(inputParams.get(i).getValue().indexOf(":")==-1)
				objectParameters.addObjectParam(inputParams.get(i).getValue());
			else  if(inputParams.get(i).getValue().indexOf(EXTERNAL_PARAM)!=-1){
				Parameter externalParameter=MappingTools.getParameterByName(attribute.getParameters().getExternalParameters().getParameter(), inputParams.get(i).getValue().substring(inputParams.get(i).getValue().indexOf(EXTERNAL_PARAM)+EXTERNAL_PARAM.length()));
				if(externalParameter!=null){
				Class[] parameterTypes={MappingTools.getClass(externalParameter.getType())};
				Object[] parameterValues={externalParameter.getValue()};
				Object obj=MappingTools.getObject(externalObject, attribute.getExternalAttribute(), parameterTypes, parameterValues);
				
				objectParameters.addObjectParam(obj);
				}
				
			}
		}
		Object object_=MappingTools.getObject(externalObjectFunction, function.getMethodName(), objectParameters.getClassParams(), objectParameters.getObjectParams());
		
		return object_;
		
	}

	public Mappings getMappings() {
		return mappings;
	}

}
