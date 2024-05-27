package May8;
import May8.Subject;
import May8.School;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		May8.Student student=new May8.Student();
        //Address address=new Address();
        Scanner sc=new Scanner(System.in);
        student.setName(sc.nextLine());
        student.setSchool(new School("BBPS"));
        student.setSubject(new Subject("MATHEMATICS"));

        System.out.println(student.toString());

	}

}
