//27기 B조 이인호

package services;

public class Comedion {
	
	private int comedionid;  
	private String comedionname;
	private int comedionage;
	
	
	public int getComedionid() {
		return comedionid;
	}
	public void setComedionid(int comedion_id) {
		this.comedionid = comedion_id;
	}
	public String getComedionname() {
		return comedionname;
	}
	public void setComedionname(String comedion_name) {
		this.comedionname = comedion_name;
	}
	public int getComedionage() {
		return comedionage;
	}
	public void setComedionage(int comedion_age) {
		this.comedionage = comedion_age;
	}
	@Override
	public String toString() {
		return "Comedion [comedionid=" + comedionid + ", comedionname=" + comedionname + ", comedionage=" + comedionage
				+ "]";
	}
	

}
