package ComparatorExample;

import java.util.Comparator;

public class EmployeeByName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getName().charAt(0),o2.getName().charAt(0));
    }
}
