/**
 * 
 */
package dz.home.commun.parsing.txt;


/**
 * @author eaziaou
 *
 */
public class SeparatorDesignFile extends DesignFile{
	
	
	
	public SeparatorDesignFile(){
		setSeparator(",");
	}

	@Override
	public void buildAttributes(String[] lines) {
		// TODO Auto-generated method stub
		for(String line:lines)
			if(line!=null && line.length()>0)
			    if(line.indexOf("=")!=-1)
		this.addAttribute(line.substring(0,line.indexOf("=")).trim(), line.substring(line.indexOf("=")+1).trim());
			    else
				this.addAttribute(line, line);
	}
	
	@Override
	public void setWithSeparator() {
		// TODO Auto-generated method stub
		this.withSeparator=true;
	}
	@Override
	public void setSeparator(String separator) {
		// TODO Auto-generated method stub
		this.separator=separator;
	}

	

}
