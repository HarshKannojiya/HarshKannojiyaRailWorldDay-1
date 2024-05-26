package May8;
import May8.Subject;
import May8.School;
public class Student {

	private String name;
	private School school;
	private Subject subject;
	
	public Student() {
		
	}
	public Student(String name, May8.School school, Subject subject) {
		this.name = name;
		this.school=school;
		this.subject=subject;
		
	}
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", School=" + school +
                ", Subject=" + subject +
                '}';
    }


}
