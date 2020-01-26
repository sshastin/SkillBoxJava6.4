package ComparatorClasses;

import WorkerInterfaces.Employee;

import java.util.Comparator;

public class SalaryDescendingComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return (-1 * o1.getMonthSalary().compareTo(o2.getMonthSalary()));
    }
}
