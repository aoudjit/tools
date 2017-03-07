/**
 * 
 */
package dz.home.commun.parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import dz.home.commun.parsing.domain.GenericObject;
import dz.home.commun.parsing.domain.TextObject;
import dz.home.commun.parsing.exception.TextException;
import dz.home.commun.parsing.txt.DesignFile;
import dz.home.commun.parsing.txt.SeparatorDesignFile;

/**
 * @author eaziaou
 *
 */
public class FlatFileParsing extends FileParsing{
	
	public DesignFile designFile;
	
	public FlatFileParsing(String fileName) throws TextException{
		try {
			loadData(fileName);
			
			//System.out.println(getData().get(0)+","+designFile.getSeparator());
			//String [] lines=split(getData().get(designFile.getHeaderLineIndex()),(designFile.getSeparator()));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			throw new TextException("File Not Found:"+fileName);
		}
	}
	public FlatFileParsing(String[] flow) throws TextException{
	
			loadData(flow);
			
			//System.out.println(getData().get(0)+","+designFile.getSeparator());
			
	
	}

	@Override
	public Object processData(DesignFile design) {
		// TODO Auto-generated method stub
		List<GenericObject> objects=new ArrayList<GenericObject>();
		
		
		for(String data:getData()){
			//System.out.println(data);
			//skip header line
			if(data!=null && data.length()>0){
				GenericObject object= new TextObject();
		        object.buildFields(data);
		        objects.add(object);
			}
			}
			
		
		
		return objects;
	}

	@Override
	public Object processData() {
		// TODO Auto-generated method stub
		return processData(null);
	}
	public String[] split(String line,String sep){
		int max=200;
		String[] result=new String[max];
		StringTokenizer tokens=new StringTokenizer(line,sep);
		int index=0;
		while(tokens.hasMoreTokens()){
			if(index<max)
			result[index]=tokens.nextToken()+"="+index;
			index++;
		}
			
		return result;
		
	}

}
