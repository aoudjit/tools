/**
 * 
 */
package dz.home.commun.parsing.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eaziaou
 * 
 */
public class DiscrObject {

    private static final String SWAP = "SWAP";
    private static final String REHOME = "REHOMING";
    private static final String OK = "OK";

    private List<RuObject> ruList;

    private String siteName;

    public DiscrObject() {

	ruList = new ArrayList<RuObject>();
	RuObject ruObject_900=new RuObject();
	ruList.add(ruObject_900);
	RuObject ruObject_1800=new RuObject();
	ruList.add(ruObject_1800);
	RuObject ruObject_1800_2=new RuObject();
	ruList.add(ruObject_1800_2);

    }

    public String toString() {
	reoderRU(ruList);

	StringBuffer buffer = new StringBuffer();
	int index = 0;
	for (RuObject newRu : ruList) {
	    if(!newRu.isNull())
	    buffer.append(newRu + "\n");

	}
	return buffer.toString();
    }

    public List<RuObject> getRuList() {
	return ruList;
    }

    public void setRuList(List<RuObject> ruList) {
	this.ruList = ruList;
    }

    public String getSiteName() {
	return siteName;
    }

    public void setSiteName(String siteName) {
	this.siteName = siteName;
    }

    public void addRu(RuObject ru) {
	if (ruList == null)
	    ruList = new ArrayList<RuObject>();
	ruList.add(ru);
    }

    private void reoderRU(List<RuObject> rus) {

    }
}
