package ComparatorExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import ComparatorExample.Employee;

public class MainClassRunner {
    public static void main(String[] args) {
        ArrayList<Employee> arrayList1 = new ArrayList<>();
        arrayList1.add(new Employee(1,"Dhruv"));
        arrayList1.add(new Employee(2,"Harsh"));
        Set<Employee> set1 = new HashSet<>();
        Employee e = new ComparatorExample.Employee(1,"Harsh");
        Employee e1 = new Employee(1,"Harsh");
        set1.add(e);
        set1.add(e1);
        System.out.println(e+" "+e1);
        System.out.println(set1);

//        arrayList1.add(new Employee(3,"Abhi"));
//        arrayList1.add(new Employee(4,"Anuj"));
//        Collections.sort(arrayList1,new EmployeeByName());
////        System.out.println(arrayList1.get(0).getName());
//        for(Employee e: arrayList1){
//            System.out.println(e.getName());
//        }
    }
}
