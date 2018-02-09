//27±â BÁ¶ ¹è°ÇÇý
package services;

public class Actress {
	private int ActressId;
	private String ActressName;
	private int ActressAge;
	public int getActressId() {
		return ActressId;
	}
	public void setActressId(int actressId) {
		ActressId = actressId;
	}
	public String getActressName() {
		return ActressName;
	}
	public void setActressName(String actressName) {
		ActressName = actressName;
	}
	public int getActressAge() {
		return ActressAge;
	}
	public void setActressAge(int actressAge) {
		ActressAge = actressAge;
	}
	@Override
	public String toString() {
		return "Actress [ActressId=" + ActressId + ", ActressName=" + ActressName + ", ActressAge=" + ActressAge + "]";
	}
	
	
}
