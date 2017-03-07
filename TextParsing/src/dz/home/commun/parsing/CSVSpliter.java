package dz.home.commun.parsing;

import java.util.ArrayList;
import java.util.List;

public class CSVSpliter {

	public static String[] split(String sep, String inputStr) {

	    StringBuffer sb = new StringBuffer (inputStr);
	    List<String> splitStringList = new ArrayList<String> ();
	    boolean insideDoubleQuotes = false;
	    StringBuffer field = new StringBuffer ();

	    for (int i=0; i < sb.length(); i++) {
	        if (sb.charAt (i) == '"' && !insideDoubleQuotes) {
	            insideDoubleQuotes = true;
	        } else if (sb.charAt(i) == '"' && insideDoubleQuotes) {
	            insideDoubleQuotes = false;
	            splitStringList.add (field.toString().trim());
	            field.setLength(0);
	        } else if (Character.toString(sb.charAt(i)).equals(sep.replace("\\", "")) && !insideDoubleQuotes) {
	            // ignore the comma after double quotes.
	            if (field.length() > 0) {
	                splitStringList.add (field.toString().trim());
	            }
	            // clear the field for next word
	            field.setLength(0);
	        } else {
	            field.append (sb.charAt(i));
	        }
	    }
	    splitStringList.add (field.toString().trim());
        field.setLength(0);
	    for (String str: splitStringList) {
	       // System.out.println ("Split fields: "+str);
	    }
	    String[] array = splitStringList.toArray(new String[splitStringList.size()]);
	    return array;
	}
	  public static void main (String [] args) {
	    String inputStr = "value1, value2, value3, value4, \"value5, 1234\", value6, value7, \"value8\", value9, \"value10, 123.23\"";
	    split(",", inputStr);
	  }
	}