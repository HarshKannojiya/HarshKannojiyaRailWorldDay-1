package May8;

public class Subject {
	private String sub;
	public Subject(String sub) {
		this.sub=sub;
		setSub(sub);
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getSub() {
		return this.sub;
	}
	public String toString() {
		return sub;
	}
}
