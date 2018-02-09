//³ª¼º¼ö

package services;

public class Rapper {
	private int rapperId;
	private String rapperName;
	private int rapperAge;
	
	public int getRapperId() {
		return rapperId;
	}

	public void setRapperId(int rapperId) {
		this.rapperId = rapperId;
	}

	public String getRapperName() {
		return rapperName;
	}

	public void setRapperName(String rapperName) {
		this.rapperName = rapperName;
	}

	public int getRapperAge() {
		return rapperAge;
	}

	public void setRapperAge(int rapperAge) {
		this.rapperAge = rapperAge;
	}

	@Override
	public String toString() {
		return "Rapper [rapperId=" + rapperId + ", rapperName=" + rapperName + ", rapperAge=" + rapperAge + "]";
	}
	
}
