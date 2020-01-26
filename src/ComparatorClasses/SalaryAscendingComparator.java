package ComparatorClasses;

import WorkerInterfaces.Employee;

import java.util.Comparator;

public class SalaryAscendingComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getMonthSalary().compareTo(o2.getMonthSalary());
    }
}
