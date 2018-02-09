//27기 B조 이인호

package services;

public class Comedian {
	
	private int comedianid;  
	private String comedianname;
	private int comedianage;
	
	public int getComedianid() {
		return comedianid;
	}
	public void setComedianid(int comedianid) {
		this.comedianid = comedianid;
	}
	public String getComedianname() {
		return comedianname;
	}
	public void setComedianname(String comedianname) {
		this.comedianname = comedianname;
	}
	public int getComedianage() {
		return comedianage;
	}
	public void setComedianage(int comedianage) {
		this.comedianage = comedianage;
	}
	@Override
	public String toString() {
		return "Comedian [comedianid=" + comedianid + ", comedianname=" + comedianname + ", comedianage=" + comedianage
				+ "]";
	}
	
	
	
	

}
