/**
 * 
 */
package dz.home.commun.parsing;

import java.util.ArrayList;
import java.util.List;

import dz.home.commun.parsing.domain.TextObject;
import dz.home.commun.parsing.exception.TextException;
import dz.home.commun.parsing.txt.SeparatorDesignFile;

/**
 * @author eaziaou
 *
 */
public class TestCsvFileParsing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     try {
		//CsvFileParsing file=new CsvFileParsing("C:\\Users\\ehilpal\\Desktop\\For Today-Tomorrw\\Vodafone Bill&Payment\\Month Aug\\topology_201207010656.csv",null);
    	//CsvFileParsing file=new SpecialCSVFileParsing("C:\\Users\\ehilpal\\Documents\\My Received Files\\NEC Files\\IPASOLINK 200\\invn-20120816.csv",null);
    	//CsvFileParsing file1 = new SpecialCSVFileParsing("C:\\Users\\ehilpal\\Documents\\My Received Files\\NEC Files\\invn-20120703.csv",null);
	    //Object object=file.processData();
	   // System.out.println(object);
    	SeparatorDesignFile design=new SeparatorDesignFile();
    	design.setSeparator("\\|");
    	CsvFilteredLinesParsing file_=new CsvFilteredLinesParsing("C:/export/home/huawei_user/U20000/drop/LTERNPData.csv",design);
	    List<String> filters=new ArrayList<String>();
	    filters.add(null);
	    filters.add("NAD-1009_L");
	    file_.setFilters(filters);
    	Object object_=file_.processData();
	    //System.out.println(object_.toString());
	    List<TextObject> list = (List<TextObject>)object_;
	    
	    for(TextObject obj:list){
	    	System.out.println(obj.getField("TAC"));
	    	/*TextObject child = (TextObject)obj.getField("child");
	    	if((child != null) && (child.getField("F/W Information Uncurrent")!= null) && !((String)child.getField("F/W Information Uncurrent")).isEmpty()){
	    		 
	    		System.out.println("Check Control characters:"+((String)child.getField("F/W Information Uncurrent")).trim()+":To see problem");
	    	}*/
	    }
     
     } catch (TextException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
