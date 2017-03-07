/**
 * 
 */
package dz.home.commun.parsing.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import dz.home.commun.parsing.CSVSpliter;
import dz.home.commun.parsing.txt.DesignFile;

/**
 * @author eaziaou
 * 
 */
public class TextObject extends GenericObject {

    @Override
    public void buildFields(String line, DesignFile design) {
	// TODO Auto-generated method stub
	if (line == null || "".equalsIgnoreCase(line))
	    return;
//	StringTokenizerCustom tokens = new StringTokenizerCustom(line, design.getSeparator());
//	int indexKey = 0;
//	while (tokens.hasMoreTokens()) {
//	    String token = tokens.nextToken();
//	   
//	    String str2 = design.getAttributeByValue("" + indexKey);
//	   // System.out.println(indexKey+"->"+design.getAttributeByValue(""+indexKey)+","+token);
//	    if (str2 == null) {
//		if (token.indexOf("=") != -1)
//		    addField(token.substring(0, token.indexOf("=")), token.substring(token.indexOf("=") + 1));
//		else
//		    addField("" + indexKey, token);
//	    } else
//		addField(str2, token);
//	    indexKey++;
//	}
	String[] tokenTab = line.split(design.getSeparator());
	for (int i =0; i<tokenTab.length; i++) {
		String token = tokenTab[i];
		String str2 = design.getAttributeByValue("" + i);
		   // System.out.println(indexKey+"->"+design.getAttributeByValue(""+indexKey)+","+token);
		    if (str2 == null) {
			if (token.indexOf("=") != -1)
			    addField(token.substring(0, token.indexOf("=")), token.substring(token.indexOf("=") + 1));
			else
			    addField("" + i, token);
		    } else
			addField(str2, token);
	}
	// System.out.println(indexKey+"->"+design.getAttributeByValue(""+indexKey)+","+token
	// );
	// addField(design.getAttributeByValue(""+indexKey), token);

    }

    @Override
    public void buildFields(String line) {
	// TODO Auto-generated method stub
	if (line == null || "".equalsIgnoreCase(line))
	    return;
	StringTokenizer tokens = new StringTokenizer(line, ",");
	int indexKey = 0;
	while (tokens.hasMoreTokens()) {
	    String token = tokens.nextToken();
	    // System.out.println(indexKey+"->"+design.getAttributeByValue(""+indexKey)+","+token
	    // );
	    addField("" + indexKey, token);
	    indexKey++;
	}
    }

    @Override
    public void buildFields(String line, String separator, List<String> filters) {
	// TODO Auto-generated method stub
	StringTokenizer tokens = new StringTokenizer(line, separator);
	int indexKey = 0;
	if (line == null || "".equalsIgnoreCase(line))
	    return;
	List<String> elements=new ArrayList<String>();
	while (tokens.hasMoreTokens()) {
	    String token = tokens.nextToken();
	   /* if ((indexKey == 0 && !inList(token, filters)) || (indexKey == 0 && (token == null || "".equalsIgnoreCase(token)))) {

		break;
	    }
	    else{
		// System.out.println(indexKey+"->"+design.getAttributeByValue(""+indexKey)+","+token
		// );
		addField("" + indexKey, token);
	    }*/
	    elements.add(token);
	   // indexKey++;
	}
	if(inList(elements,filters)){
	    for(String st:elements){
		addField("" + indexKey, st);
		 indexKey++;
	    }
	}
    }

    private boolean inList(String str, List<String> strs) {
	for (String st : strs)
	    if (str.contains(st))
		return true;
	return false;
    }
    private boolean inList(List<String>  str, List<String> strs) {
	for (String st : str)
	    if (inList(st,strs))
		return true;
	return false;
    }

	@Override
	public boolean buildFields(String line, DesignFile design,List<String> filters) {
		// TODO Auto-generated method stub
		if (line == null || "".equalsIgnoreCase(line))
		    return false;
		boolean processing=false;
		if(filters!=null){
			for(String item:filters){
				if(item!=null && line.contains(item)){
					processing=true;
				}
			}
		}else{
			processing=true;	
		}
		if(processing){
		StringTokenizer tokens = new StringTokenizer(line, design.getSeparator());
		String[] tabTokens = line.split(design.getSeparator());
//		String[] tabTokens = CSVSpliter.split(design.getSeparator(), line);
		int indexKey = 0;
		//while (tokens.hasMoreTokens())
		for (int i=0; i < tabTokens.length; i++) 
		{
		    String token = tabTokens[i];//tokens.nextToken();
		    String str2 = design.getAttributeByValue("" + indexKey);
			  
			    if (str2 == null) {
				if (token.indexOf("=") != -1)
				    addField(token.substring(0, token.indexOf("=")), token.substring(token.indexOf("=") + 1));
				else
				    addField("" + indexKey, token);
			    } else
				addField(str2, token);
			    indexKey++;
		}
		return true;
	    }
		return false;
	   }

	
	public static List<TextObject> filterByCriteria(List<TextObject> objects, List<String> filters) {
		List<TextObject> result = new ArrayList<TextObject>();
		for (TextObject obj : objects) {
			Map filedsMap = obj.getFields();
			Iterator entries = filedsMap.entrySet().iterator();
			while (entries.hasNext()) {
				 Entry thisEntry = (Entry) entries.next();
				 String key = (String)thisEntry.getKey();
				 String value = (String)filedsMap.get(key);
				 for(String item:filters){
					 if (value.equalsIgnoreCase(item)) {
						 result.add(obj);
					 }
				 }
				 
			}
		}
		return result;
	}

}
