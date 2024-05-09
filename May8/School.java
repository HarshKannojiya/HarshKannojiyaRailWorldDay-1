package May8;

public class School {
	private String sch;
	public School(String sch) {
		this.sch=sch;
		setSch(sch);
	}
	public void setSch(String sch) {
		this.sch = sch;
	}
	public String getSch() {
		return this.sch;
	}
	public String toString() {
		return sch;
	}
}
