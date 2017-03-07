/**
 * 
 */
package dz.home.commun.parsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class FilteredFlatFileParsing extends FileParsing{
	
	private List<String> filters;
	private String fileName;
	private List<TextObject> savedObjects;
	
	
	
	public FilteredFlatFileParsing(String fileName) throws TextException{
		try {
			this.fileName=fileName;
			loadData(fileName);
			
			//System.out.println(getData().get(0)+","+designFile.getSeparator());
			//String [] lines=split(getData().get(designFile.getHeaderLineIndex()),(designFile.getSeparator()));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			throw new TextException("File Not Found:"+fileName);
		}
	}
	public FilteredFlatFileParsing(String[] flow) throws TextException{
	
			loadData(flow);
			
			//System.out.println(getData().get(0)+","+designFile.getSeparator());
			
	
	
	}
    public void setFilters(List<String> filters){
    	this.filters=filters;
    }
    public void addFilter(String filter){
    	if(filters==null) filters=new ArrayList<String>();
    	filters.add(filter);
    }
	@Override
	public Object processData(DesignFile design) {
		// TODO Auto-generated method stub
		List<TextObject> objects=new ArrayList<TextObject>();
		
		
		for(String data:getData()){
			//System.out.println(data);
			//skip header line
			if(data!=null && data.length()>0){
				TextObject object= new TextObject();
		        object.buildFields(data," ",filters);
		        if(!object.isEmpty())
		        objects.add(object);
			}
			}
			
		savedObjects=objects;
		
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
	public void saveInFile(String fileName){
		File file=new File(fileName);
		try {
			FileOutputStream stream=new FileOutputStream(file);
			for(TextObject object:savedObjects){
				for(int i=0;i<object.getFields().size();i++)
			     stream.write((""+object.getField(""+i)+" ").getBytes("UTF-8"));
			 stream.write(("\n").getBytes("UTF-8"));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void saveInFile(){
		saveInFile(fileName.substring(0,fileName.length()-4)+"_saved"+fileName.substring(fileName.length()-4,fileName.length()));
	}

}
