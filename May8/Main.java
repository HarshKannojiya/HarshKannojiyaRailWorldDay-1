package May8;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Student student=new Student();
        //Address address=new Address();
        Scanner sc=new Scanner(System.in);
        student.setName(sc.nextLine());
        student.setSchool(new School("BBPS"));
        student.setSubject(new Subject("MATHEMATICS"));

        System.out.println(student.toString());

	}

}
