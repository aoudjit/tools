/**
 * 
 */
package dz.home.commun.search.txt;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dz.home.commun.parsing.txt.filter.Filter;

/**
 * @author eaziaou
 * 
 */
public abstract class TextSearch {
	public int lineIncrement = 0;

	public abstract String applyFilter(Filter filter, String line,
			int lineNumber);

	public List<String> readLineByLine(String dataFileName, Filter filter)
			throws IOException {
		FileInputStream fileIn = new FileInputStream(new File(dataFileName));
		DataInputStream in = new DataInputStream(fileIn);
		List<String> results = new ArrayList<String>();
		String result = null;
		String tempResult = null;
		while (in.available() > 0) {
			tempResult = null;
			tempResult = applyFilter(filter, in.readLine(), lineIncrement);
			if (lineIncrement != 0)
				
					result = result + ((tempResult!=null)?(";" + tempResult):"");
				else 
					result = tempResult;
			if (lineIncrement == 68)
				lineIncrement = 0;
			else
				lineIncrement++;
			if (result != null && lineIncrement == 0) {
				results.add(result + "\n");
				result = null;
			}

		}

		return results;
	}

	public int getLineIncrement() {
		return lineIncrement;
	}

	public void setLineIncrement(int lineIncrement) {
		this.lineIncrement = lineIncrement;
	}

}
