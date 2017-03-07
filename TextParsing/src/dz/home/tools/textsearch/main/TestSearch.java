/**
 * 
 */
package dz.home.tools.textsearch.main;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import dz.home.tools.textsearch.PageFilter;
import dz.home.tools.textsearch.PageTextSearch;
import dz.home.tools.textsearch.TextSearchFilter;

/**
 * @author eaziaou
 *
 */
public class TestSearch {
	
	public static void main(String[] args){
		try {
			TestSearch.buildTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void buildTest() throws IOException{
		PageTextSearch search=new PageTextSearch();
		PageFilter filter=new PageFilter();
		TextSearchFilter filterText=new TextSearchFilter();
		filterText.setPage(filter);
		filterText.readFileFilter("c:\\testsearch\\config.txt");
		filter=filterText.getPage();
		List<String> results=search.readLineByLine("c:\\testsearch\\datas.txt", filter);
		writeIt(results);
	}
	private static void writeIt(List<String> datas) throws IOException{
		FileOutputStream fileOut=new FileOutputStream(new File("c:\\testsearch\\datas_out.txt"));
		DataOutputStream out=new DataOutputStream(fileOut);
		out.writeBytes("hop;network;ntwk a-end;ntwk z-end;st a-end;st z-end;tx;rx\n" );
	    for(int i=0;i<datas.size();i++)
	    	out.writeBytes(datas.get(i));
	    out.close();
	    
	}

}
