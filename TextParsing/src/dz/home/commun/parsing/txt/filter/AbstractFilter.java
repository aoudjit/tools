/**
 * 
 */
package dz.home.commun.parsing.txt.filter;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eaziaou
 *
 */
public abstract class AbstractFilter {
	
	public  List<LineDescription> readFileFilter(String fileName) throws IOException{
		List<LineDescription> filters=new ArrayList<LineDescription>();
		FileInputStream fileIn=new FileInputStream(new File(fileName));
		DataInputStream in=new DataInputStream(fileIn);
		while(in.available()>0)
			
		filters.add(readLine(in.readLine()));
		return filters;
	}
	
	
	public abstract LineDescription readLine(String line);

}
