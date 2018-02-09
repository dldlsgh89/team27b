package services;

public class Actor {
	private int ActorId;
	private String ActorName;
	private int ActorAge;
	public int getActorId() {
		return ActorId;
	}
	public void setActorId(int actorId) {
		ActorId = actorId;
	}
	public String getActorName() {
		return ActorName;
	}
	public void setActorName(String actorName) {
		ActorName = actorName;
	}
	public int getActorAge() {
		return ActorAge;
	}
	public void setActorAge(int actorAge) {
		ActorAge = actorAge;
	}
	@Override
	public String toString() {
		return "Actor [ActorId=" + ActorId + ", ActorName=" + ActorName + ", ActorAge=" + ActorAge + ", getActorId()="
				+ getActorId() + ", getActorName()=" + getActorName() + ", getActorAge()=" + getActorAge() + "]";
	}
	
}
	
	

