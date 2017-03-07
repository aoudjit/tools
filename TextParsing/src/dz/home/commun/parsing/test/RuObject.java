/**
 * 
 */
package dz.home.commun.parsing.test;

/**
 * @author eaziaou
 *
 */
public class RuObject {
    private static final String SWAP_NEW="SWAP/ADDED";
    private static final String SWAP_DELETED="REMOVED";
    private static final String REHOME="REHOMING";
    private static final String OK="OK";
    private static final String PROBLEM="TG-CHANGED";
    private static final String BSC_NAME_CHANGED="BSC NAME CHANGED";
    
    private String siteName;
    private String bscName;
    private String ru;
    private String equName;
    private String newSiteName;
    private String newBscName;
    private String newRu;
    private String oldSiteName;
    private String oldBscName;
    private String oldRu;
    public String getSiteName() {
        return siteName;
    }
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
    public String getBscName() {
	if(bscName==null && oldBscName!=null)return oldBscName;
	if(siteName!=null && bscName==null && oldBscName==null)return newBscName;
        return bscName;
    }
    public void setBscName(String bscName) {
        this.bscName = bscName;
    }
    public String getRu() {
        return ru;
    }
    public void setRu(String ru) {
        this.ru = ru;
    }
    public String getNewSiteName() {
        return newSiteName;
    }
    public void setNewSiteName(String newSiteName) {
        this.newSiteName = newSiteName;
    }
    public String getNewBscName() {
        return newBscName;
    }
    public void setNewBscName(String newBscName) {
        this.newBscName = newBscName;
    }
    public String getNewRu() {
        return newRu;
    }
    public void setNewRu(String newRu) {
        this.newRu = newRu;
    }
    public String getOldSiteName() {
        return oldSiteName;
    }
    public void setOldSiteName(String oldSiteName) {
        this.oldSiteName = oldSiteName;
    }
    public String getOldBscName() {
        return oldBscName;
    }
    public void setOldBscName(String oldBscName) {
        this.oldBscName = oldBscName;
    }
    public String getOldRu() {
        return oldRu;
    }
    public void setOldRu(String oldRu) {
        this.oldRu = oldRu;
    }
    
    public String getDisc(){
	if(newSiteName==null)
	    return SWAP_DELETED;
	    if( siteName==null) return SWAP_NEW;
	if( oldBscName!=null && oldBscName.equalsIgnoreCase(newBscName) && oldRu.equalsIgnoreCase(newRu)) return OK;
	if( oldBscName!=null && oldBscName.equalsIgnoreCase(newBscName) && !oldRu.equalsIgnoreCase(newRu)) return PROBLEM;
	if( oldBscName!=null && !oldBscName.equalsIgnoreCase(newBscName) && oldRu.equalsIgnoreCase(newRu)) return BSC_NAME_CHANGED;
	if(oldBscName==null && bscName==null && ru.equalsIgnoreCase(newRu))return OK;
	return REHOME;
    }
    
    public String getEquName() {
        return equName;
    }
    public void setEquName(String equName) {
        this.equName = equName;
    }
    private int getFrequency(){
	if(ru!=null) return getFrequency(ru);
	if(newRu!=null) return getFrequency(newRu);
	if(oldRu!=null) return getFrequency(oldRu);
	return 0;
    }
    public static int getFrequency(String txt){
	if(txt==null) return 0;
	String frequency=txt.substring(txt.lastIndexOf('-')+1,txt.length());
	int freq=0;
	    try{
	    freq=new Integer(frequency).intValue();
	    }catch(Exception exp){
		
	    }
	    if(freq<100) return 900;
	    if(freq>=100 && freq<300) return 1800;
	    if(freq>=300) return 2800;
	return 0;
    }
    public boolean isNull(){
	if(siteName==null && oldSiteName==null && newSiteName==null) return true;
	return false;
    }
    
    public String toString(){
	StringBuffer buffer=new StringBuffer();
	buffer.append(getEquName()+",");
	buffer.append(getSiteName()+",");
	buffer.append(getRu()+",");
	buffer.append(getBscName()+",");
	buffer.append(getOldSiteName()+",");
	buffer.append(getOldRu()+",");
	buffer.append(getOldBscName()+",");
	buffer.append(getNewSiteName()+",");
	buffer.append(getNewRu()+",");
	buffer.append(getNewBscName()+",");
	buffer.append(getDisc());
	return buffer.toString();
    }
}
