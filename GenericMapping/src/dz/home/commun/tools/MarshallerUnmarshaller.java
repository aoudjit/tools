/**
 * 
 */
package dz.home.commun.tools;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;

/**
 * @author eaziaou
 *
 */
public class MarshallerUnmarshaller {
	public static final Logger log=Logger.getLogger(MarshallerUnmarshaller.class);
	public static JAXBContext CONTEXT;
	public static JAXBContext NSN_CONTEXT;
	public static JAXBContext CONFIG_CONTEXT;
	public static JAXBContext CONFIG_CONTEXT_TN_RT;
	static{
	try{
		CONTEXT =JAXBContext.newInstance(ParserConstants.CONTEXT_PACKAGE);
		NSN_CONTEXT =JAXBContext.newInstance(ParserConstants.CONTEXT_NSN_PACKAGE);
		
	}catch(Exception exp){
		
	}
	}
	
	public static Object Unmarshaller(String fileName,JAXBContext CONTEXT){
		
		 Object data=null;
		try {
			
			 javax.xml.bind.Unmarshaller unmarshaller = CONTEXT.createUnmarshaller();
			  try {
				data= unmarshaller.unmarshal(new InputStreamReader(new FileInputStream(new File(fileName)),"UTF-8"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  log.debug("data="+data);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	       

		return data;
		
	}
	public static Object Unmarshaller(String[] flow,JAXBContext CONTEXT){
		
		 Object data=null;
		 String flow_ = "";
			for (int i = 0; i < flow.length; i++) {
				flow_ = flow_ + flow[i];

			}
			byte[] byteFlow = new byte[flow_.length()];
			try {
				byteFlow = flow_.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 ByteArrayInputStream stream=new ByteArrayInputStream(byteFlow);
		try {
			
			 javax.xml.bind.Unmarshaller unmarshaller = CONTEXT.createUnmarshaller();
			
			  data=unmarshaller.unmarshal(stream);
			  log.debug("data="+data);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	       

		return data;
		
	}
}