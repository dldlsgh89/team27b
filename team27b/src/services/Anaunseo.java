//27기 B조 이인호

package services;

public class Anaunseo {

	private int anaunseoid;  
	private String anaunseoname;
	private int anaunseoage;
	
	public int getAnaunseoid() {
		return anaunseoid;
	}
	public void setAnaunseoid(int anaunseo_id) {
		this.anaunseoid = anaunseo_id;
	}
	public String getAnaunseoname() {
		return anaunseoname;
	}
	public void setAnaunseoname(String anaunseo_name) {
		this.anaunseoname = anaunseo_name;
	}
	public int getAnaunseoage() {
		return anaunseoage;
	}
	public void setAnaunseoage(int anaunseo_age) {
		this.anaunseoage = anaunseo_age;
	}
	@Override //아직 뭔소리인지를 모르겠지만 단위테스트할때 사용한다더라~
	public String toString() {
		return "Anaunseo [anaunseoid=" + anaunseoid + ", anaunseoname=" + anaunseoname + ", anaunseoage=" + anaunseoage
				+ "]";
	}
	
	
	
	
}
