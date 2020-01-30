package CompanyInterfaces;

import Enums.FireReasons;
//import Exceptions.VacantPositionException;
import WorkerInterfaces.Employee;

import java.util.ArrayList;
import java.util.List;

public interface StaffManage {

    void hire(Employee worker);

    void hireAll(List<Employee> listOfWorkersToHire);

    void fire(Employee worker, FireReasons fireReason, String password);// throws VacantPositionException;

    void fireAll(List<Employee> listOfWorkersToFire, FireReasons fireReason, String password);// throws VacantPositionException;

    List<Employee> getTopSalaryStaff(int count);//count - число сотрудников, которых необходимо вернуть в результате работы метода

    List<Employee> getLowestSalaryStaff(int count);//count - число сотрудников, которых необходимо вернуть в результате работы метода
}
