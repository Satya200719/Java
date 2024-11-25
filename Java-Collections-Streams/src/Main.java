import com.java.collections.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(25, "Satya", 5000));
        employees.add(new Employee(24, "Kajal", 9500));
        employees.add(new Employee(32, "Anushka", 7000));
        employees.add(new Employee(30, "Trisha", 8000));

        Collections.sort(employees, new Sort());
        System.out.println(employees);

        //with anonymous
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getAge() - o2.getAge());
            }
        });
        System.out.println(employees);

        //with lambda expressions
        Collections.sort(employees, (o1, o2) -> (int) (o2.getName().compareTo(o1.getName())));
        System.out.println(employees);

        employees.sort((o1, o2) -> (int) (o2.getName().compareTo(o1.getName())));
        System.out.println(employees);
    }
}

class Sort implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o2.getSalary() - o1.getSalary());
    }
}