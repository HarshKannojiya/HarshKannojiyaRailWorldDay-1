package ComparatorExample;

import java.util.Comparator;

public class Employee {
    int id;
    String name;
    public Employee(int id,String name){
        this.id = id;
        this.name = name;
    }
    String getName(){
        return this.name;
    }
     public String toString(){
        return this.getName();
    }
}
