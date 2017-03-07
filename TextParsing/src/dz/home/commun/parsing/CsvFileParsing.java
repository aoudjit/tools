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
public class CsvFileParsing extends FileParsing{
	
	public DesignFile designFile;
	
	public CsvFileParsing(String fileName,DesignFile design) throws TextException{
		try {
			loadData(fileName);
			if(design==null)
			designFile=new SeparatorDesignFile();
			else
				designFile=design;
			//System.out.println(getData().get(0)+","+designFile.getSeparator());
			String [] lines=split(getData().get(designFile.getHeaderLineIndex()),(designFile.getSeparator()));
			designFile.buildAttributes(lines);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			throw new TextException("File Not Found:"+fileName);
		}
	}
	public CsvFileParsing(String[] flow) throws TextException{
	
			loadData(flow);
			designFile=new SeparatorDesignFile();
			//System.out.println(getData().get(0)+","+designFile.getSeparator());
			String [] lines=split(getData().get(designFile.getHeaderLineIndex()),(designFile.getSeparator()));
			designFile.buildAttributes(lines);
	
	}
	public CsvFileParsing(String[] flow,DesignFile design) throws TextException{
		
		loadData(flow);
		if(design==null)
			designFile=new SeparatorDesignFile();
			else
				designFile=design;
		//System.out.println(getData().get(0)+","+designFile.getSeparator());
		String [] lines=split(getData().get(designFile.getHeaderLineIndex()),(designFile.getSeparator()));
		designFile.buildAttributes(lines);

}

	@Override
	public Object processData(DesignFile design) {
		// TODO Auto-generated method stub
		List<GenericObject> objects=new ArrayList<GenericObject>();
		
		int headerLine=0;
		for(String data:getData()){
			//System.out.println(data);
			//skip header line
			if(headerLine!=design.getHeaderLineIndex()){
				GenericObject object= new TextObject();
		object.buildFields(data, design);
		objects.add(object);
			}
			headerLine++;
		
		}
		return objects;
	}

	@Override
	public Object processData() {
		// TODO Auto-generated method stub
		return processData(this.designFile);
	}
	public String[] split(String line,String sep){
		int max=200;
		String[] result=new String[max];
		String[] result_indexed=new String[max];
		if (line == null) return result;
		result = line.split(sep);
		for (int i=0; i<result.length; i++) {
			if (i >= max) break;
			result_indexed[i] = result[i] + "=" + i;
		}
		return result_indexed;
	}
	public String[] split_bis(String line,String sep){
		int max=200;
		String[] result=new String[max];
		StringTokenizer tokens=new StringTokenizer(line,sep);
		int index=0;
		while(tokens.hasMoreTokens()){
			if(index<max)
			result[index]=tokens.nextToken()+"="+index;
			else break;
			index++;
		}
			
		return result;
		
	}

}
