//27�� B�� ����ȣ

package services;

public class Anaunseo {

	private int anaunseoId;  
	private String anaunseoName;
	private int anaunseoAge;
	
	public int getAnaunseoId() {
		return anaunseoId;
	}
	public void setAnaunseoId(int anaunseoId) {
		this.anaunseoId = anaunseoId;
	}
	public String getAnaunseoName() {
		return anaunseoName;
	}
	public void setAnaunseoName(String anaunseoName) {
		this.anaunseoName = anaunseoName;
	}
	public int getAnaunseoAge() {
		return anaunseoAge;
	}
	public void setAnaunseoAge(int anaunseoAge) {
		this.anaunseoAge = anaunseoAge;
	}
	@Override
	public String toString() {
		return "Anaunseo [anaunseoId=" + anaunseoId + ", anaunseoName=" + anaunseoName + ", anaunseoAge=" + anaunseoAge
				+ "]";
	}
	
	
	
}
