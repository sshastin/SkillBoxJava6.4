package CompanyInterfaces;

import Enums.FireReasons;
import WorkerInterfaces.Employee;

import java.util.ArrayList;
import java.util.List;

public interface StaffManage {

    void hire(Employee worker);

    void hireAll(ArrayList<Employee> listOfWorkersToHire);

    void fire(Employee worker, FireReasons fireReason, String password);

    void fireAll(ArrayList<Employee> listOfWorkersToFire, FireReasons fireReason, String password);

    List<Employee> getTopSalaryStaff(int count);//count - число сотрудников, которых необходимо вернуть в результате работы метода

    List<Employee> getLowestSalaryStaff(int count);//count - число сотрудников, которых необходимо вернуть в результате работы метода
}
