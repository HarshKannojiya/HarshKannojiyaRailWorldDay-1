package ComparatorExample;

import java.util.Comparator;

public class EmployeeByName implements Comparator<ComparatorExample.Employee> {

    @Override
    public int compare(ComparatorExample.Employee o1, ComparatorExample.Employee o2) {
        return Integer.compare(o1.getName().charAt(0),o2.getName().charAt(0));
    }
}
