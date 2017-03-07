/**
 * 
 */
package dz.home.commun.parsing;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import dz.home.commun.parsing.exception.TextException;
import dz.home.commun.parsing.txt.DesignFile;

/**
 * @author eaziaou
 *
 */
// H.P ->Abstarct One.. Purpose of this file is read from a file or array of strings 
// line by line and 
// add it to datas which is list of String. Design file yet to understand.
public abstract class FileParsing {
	
	private DesignFile designFile;// H.P-> what is design file?
	private List<String> datas; 
	
	public void loadData(String fileName) throws TextException{
		File file = new File(fileName);
		datas=new ArrayList<String>();
		FileInputStream input=null;
		DataInputStream data=null;
		String temp="";
		try {
			input = new FileInputStream(file);
		    UnicodeBOMInputStream ubis = new UnicodeBOMInputStream(input);// Hillol Added
		    //String b = ubis.getBOM().toString();
		    ubis.skipBOM();
		    InputStreamReader isr = new InputStreamReader(ubis);
		    BufferedReader br = new BufferedReader(isr);
            
			try {
				while((temp = br.readLine()) != null){
				 //String temp =br.readLine();
				
				 //System.out.println("Each Line: "+ temp.trim());
				 datas.add(temp.trim());
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}
	public void loadData(String[] lines) throws TextException{
		
		datas=new ArrayList<String>();
		FileInputStream input=null;
		DataInputStream data=null;
		
	 
        
		if(lines!=null)
			for(int i=0;i<lines.length;i++){
				if(lines[i]!=null && lines[i].length()>0){
					byte[] bytes=lines[i].getBytes();
					byte[] bytesResult=new byte[1];
					boolean skip=true;
					if(bytes.length>3){
						 if ((bytes[0] == (byte)0xEF) &&
						            (bytes[1] == (byte)0xBB) &&
						            (bytes[2] == (byte)0xBF)  )
						        {
							 bytesResult=copyBytes(bytesResult,bytes,3);
							 skip=false;
							 
						        }
					}
				try {
					if(!skip)
					lines[i]=new String(bytesResult,"UTF-8");
					
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		
		if(lines.length==1){
			//System.out.println("flow length=1");
			//int index=0;
			StringTokenizer tokens=new StringTokenizer(lines[0],"\n");
			while(tokens.hasMoreTokens()){
				//System.out.println("Token:"+index);
				datas.add(tokens.nextToken());
				//index++;
			}
			
		}else{
			 for(String line:lines){
			   if(line!=null&& line.length()>0)
				datas.add(line);
			 }
			 if(datas.size()==1){
				String line=new String(datas.get(0));
				datas.remove(0);
				StringTokenizer tokens=new StringTokenizer(line,"\n");
				while(tokens.hasMoreTokens()){
					//System.out.println("Token:"+index);
					datas.add(tokens.nextToken());
					//index++;
				}
			 }
		}

			
		
		
		

	}
	public abstract Object processData(DesignFile design);
	public abstract Object processData();
	public List<String> getData(){
		return this.datas;
	}
	private byte[] copyBytes(byte[] result,byte[] bytes,int from){
		result=new byte[bytes.length-from];
		for(int i=from;i<bytes.length;i++)
			result[i-from]=bytes[i];
		return result;
	}

}
