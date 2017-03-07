/**
 * 
 */
package dz.home.commun.parsing.test;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dz.home.commun.parsing.CsvFileParsing;
import dz.home.commun.parsing.domain.TextObject;
import dz.home.commun.parsing.exception.TextException;

/**
 * @author eaziaou
 *
 */
public class RuBuilder {

    /**
     * @param args
     */
    private static DataOutputStream dataWriter;
    private static FileOutputStream streamWriter;
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	buildDiscrepancies();
    }
    
    private static void buildDiscrepancies(){
	openFile("/export/home/wtauser/result_ossrc.csv");
	List<TextObject> newRu=readNewNetwork();
	List<TextObject> oldRu=readOldNetwork();
	List<TextObject> graniteRu=readGranite();
	List<String> siteUsed=new ArrayList<String>();
	for(int i=0;i<newRu.size();i++){
	    String  siteName= ""+newRu.get(i).getField("1");
	    if(!siteUsed.contains(siteName)){
	    //System.out.println(siteName);
		siteUsed.add(siteName);
	    List<TextObject> newFilteredRu=getInfoByKey(siteName,newRu,1);
		List<TextObject> oldFilteredRu=getInfoByKey(siteName,oldRu,1);
		List<TextObject> graniteFilteredRu=getInfoByKey(siteName,graniteRu,2);
	 
	 DiscrObject obj=getDiscObject(siteName, graniteFilteredRu, oldFilteredRu, newFilteredRu);
	 System.out.println(obj);
	 try {
	    dataWriter.writeBytes(obj.toString());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	 
	    }
	}
	closeFile();
    }
   
    private static void openFile(String fileName){
	File file=new File(fileName);
	try {
	     streamWriter =new FileOutputStream(file);
	    dataWriter=new DataOutputStream(streamWriter);
	    
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    private static void closeFile(){
	try {
	    dataWriter.close();
	    streamWriter.close();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    }
    
    private static RuObject getRuObject(DiscrObject object, int freq){
	if(freq==900) return object.getRuList().get(0);
	if(freq==1800) return object.getRuList().get(1);
	if(freq==2800) return object.getRuList().get(2);
	return new RuObject();
    }
    
    private static DiscrObject getDiscObject(String siteName,List<TextObject> graniteValues,List<TextObject> oldValues,List<TextObject> newValues){
	DiscrObject object=new DiscrObject();
	object.setSiteName(siteName);
	if(oldValues!=null && oldValues.size()>0){
	
	for(TextObject txt:oldValues){
	    String ruTxt=txt.getField("2")+"";
	    int freq=RuObject.getFrequency(ruTxt);
	    RuObject obj=getRuObject(object, freq);
	    obj.setOldBscName(txt.getField("0")+"");
	    obj.setOldRu(ruTxt);
	    obj.setOldSiteName(txt.getField("1")+"");
	}
	}
	if(newValues!=null && newValues.size()>0){
		
		
		for(TextObject txt:newValues){
		    String ruTxt=txt.getField("2")+"";
		    int freq=RuObject.getFrequency(ruTxt);
		    RuObject obj=getRuObject(object, freq);
		    obj.setNewBscName(txt.getField("0")+"");
		    obj.setNewRu(ruTxt);
		    obj.setNewSiteName(txt.getField("1")+"");
		}
		}
	if(graniteValues!=null && graniteValues.size()>0){
		
		
		for(TextObject txt:graniteValues){
		    String ruTxt=txt.getField("3")+"";
		    int freq=RuObject.getFrequency(ruTxt);
		    RuObject obj=getRuObject(object, freq);
		    obj.setEquName(txt.getField("0")+"");
		    obj.setRu(ruTxt);
		    obj.setSiteName(txt.getField("2")+"");
		}
		}
	return object;
    }
    private static List<TextObject> getInfoByKey(String key, List<TextObject> objects,int indexKey){
	List<TextObject> result=new ArrayList<TextObject>();
	for(TextObject txt:objects){
	    try{
	    if(key.equalsIgnoreCase(""+txt.getField(""+indexKey))){
		result.add(txt);
	    }
	    }catch(Exception exp){
		
	    }
	}
	return result;
    }
    
    private static List<TextObject> readOldNetwork(){
	CsvFileParsing file_;
	try {
	    file_ = new CsvFileParsing("/export/home/wtauser/old_network.csv",null);
	
	    Object object_=file_.processData();
		   
	    List<TextObject> list = (List<TextObject>)object_;
	    return list;
	} catch (TextException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	return null;
	
    }
    private static List<TextObject> readNewNetwork(){
	CsvFileParsing file_;
	try {
	    file_ = new CsvFileParsing("/export/home/wtauser/new_network.csv",null);
	
	    Object object_=file_.processData();
		   
	    List<TextObject> list = (List<TextObject>)object_;
	    return list;
	} catch (TextException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	return null;
	
    }
    private static List<TextObject> readGranite(){
	CsvFileParsing file_;
	try {
	    file_ = new CsvFileParsing("/export/home/wtauser/granite_values.csv",null);
	
	    Object object_=file_.processData();
		   
	    List<TextObject> list = (List<TextObject>)object_;
	    return list;
	} catch (TextException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	return null;
	
    }

}
