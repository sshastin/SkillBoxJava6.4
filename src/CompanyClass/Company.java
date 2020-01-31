package CompanyClass;

import ComparatorClasses.SalaryAscendingComparator;
import Enums.FireReasons;
import CompanyInterfaces.FinancesManage;
import CompanyInterfaces.StaffManage;
import ComparatorClasses.SalaryDescendingComparator;
import WorkerInterfaces.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Company implements FinancesManage, StaffManage {

    private String companyName;
    private final String passwordToFire;
    private List<Employee> companyStaffList = new ArrayList<>();
    private Double totalIncome = 0.0;

    public Company(String companyName, String passwordToFire) {
        setCompanyName(companyName);
        this.passwordToFire = passwordToFire;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Employee> getCompanyStaff() {
        return companyStaffList;
    }

    @Override
    public Double getIncome() {
        return totalIncome;
    }

    @Override
    public void addTotalIncome(Double income) {
        this.totalIncome += income;
    }

    @Override
    public void hire(Employee worker) {
        this.companyStaffList.add(worker);
    }

    @Override
    public void hireAll(List<Employee> listOfWorkersToHire) {
        this.companyStaffList.addAll(listOfWorkersToHire);
    }

    @Override
    public void fire(Employee employee, FireReasons fireReason, String password) {
        if (isPasswordValid(password)) {
            fireAndRemoveWorkerFromList(employee, fireReason);
        } else {
            System.out.println("Password invalid. Please check the password and try again later.");
        }
    }

    @Override
    public void fireAll(List<Employee> listOfWorkersToFire, FireReasons fireReason, String password) {
        if (isPasswordValid(password)) {
            for (Employee employee : listOfWorkersToFire) {
                fireAndRemoveWorkerFromList(employee, fireReason);
            }
        } else {
            System.out.println("Password invalid. Please check the password and try again later.");
        }
    }

    protected void fireAndRemoveWorkerFromList(Employee employee, FireReasons fireReason) {//} throws VacantPositionException {
        if (companyStaffList.contains(employee)) {
            this.companyStaffList.remove(employee);
            System.out.println("Ваше выходное пособие составит " + calculateSeverancePay(fireReason, employee.getMonthSalary()));
        } else {
            System.out.println("Такой работник не числится в компании.");
        }
    }

    protected Boolean isPasswordValid(String password) {
        return passwordToFire.equals(password);
    }

    @Override
    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> listOfTopSalaryStaff = new ArrayList<>();
        Collections.sort(companyStaffList, new SalaryDescendingComparator());
        listOfTopSalaryStaff.addAll(companyStaffList.subList(0, Math.min(count, companyStaffList.size())));
        return listOfTopSalaryStaff;
    }

    @Override
    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> listOfLowestSalaryStaff = new ArrayList<>();
        Collections.sort(companyStaffList, new SalaryAscendingComparator());
        listOfLowestSalaryStaff.addAll(companyStaffList.subList(0, Math.min(count, companyStaffList.size())));
        return listOfLowestSalaryStaff;
    }

    protected Double calculateSeverancePay(FireReasons fireReason, Double workerSalary) {
        Double severancePay;
        switch (fireReason) {
            case DEPT_CLOSURE:
            case POSITION_CLOSURE:
                severancePay = workerSalary * 2;
                break;
            case OWN_FREE_WILL:
                severancePay = workerSalary;
                break;
            case DISCIPLINARY_REASONS:
                severancePay = 0.0;
                break;
            case MUTUAL_SIDED_DECISION:
                severancePay = workerSalary * 1.5;
                break;
            default:
                throw new IllegalStateException("Неизвестная причина увольнения: " + fireReason);
        }
        return severancePay;
    }

    @Override
    public String toString() {
        return ("Досье компании:\nКомпания: " + getCompanyName() + "\nКоличество сотрудников: " + getCompanyStaff().size() +
                "\nОборот компании: " + getIncome());
    }
}
