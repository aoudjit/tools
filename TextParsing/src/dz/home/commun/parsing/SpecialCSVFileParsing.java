/**
 * 
 */
package dz.home.commun.parsing;

import java.util.ArrayList;
import java.util.List;

import dz.home.commun.parsing.domain.GenericObject;
import dz.home.commun.parsing.domain.TextObject;
import dz.home.commun.parsing.exception.TextException;
import dz.home.commun.parsing.txt.DesignFile;
import dz.home.commun.parsing.txt.SeparatorDesignFile;

/**
 * @author eaziaou
 *
 */
public class SpecialCSVFileParsing extends CsvFileParsing{

	public SpecialCSVFileParsing(String fileName, DesignFile design)
			throws TextException {
		super(fileName, design);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object processData() {
		// TODO Auto-generated method stub
	List<GenericObject> objects=new ArrayList<GenericObject>();
	
		for(int i=0 ;i<getData().size();i=i+3){
			if(i+2<getData().size()){
			String[] flow={getData().get(i),getData().get(i+1),getData().get(i+2)};
			
			designFile=new SeparatorDesignFile();
			designFile.setHeaderLineIndex(1);
			//System.out.println(getData().get(0)+","+designFile.getSeparator());
			String [] lines=split(flow[designFile.getHeaderLineIndex()],(designFile.getSeparator()));
			designFile.buildAttributes(lines);
			//System.out.println(data);
			//skip header line
			
				GenericObject object= new TextObject();
		object.buildFields(getData().get(i));
		GenericObject objectChild= new TextObject();
		objectChild.buildFields(getData().get(i+2), designFile);
		object.addField("child", objectChild);
		objects.add(object);
			
			
		
		}
		}
		return objects;
	}

	
	

}
