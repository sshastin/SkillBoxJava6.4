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
    private Employee CEO;
    private Employee CAO;
    private Employee CTO;
    private Employee CFO;
    private Employee CIO;
    private Employee CMO;
    private Employee CVO;
    private Employee COO;
    private Employee CSO;
    private Employee CISO;
    private Double totalIncome;

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

    public Employee getCEO() {
        return CEO;
    }

    public void setCEO(Employee CEO) {
        this.CEO = CEO;
    }

    public Employee getCAO() {
        return CAO;
    }

    public void setCAO(Employee CAO) {
        this.CAO = CAO;
    }

    public Employee getCTO() {
        return CTO;
    }

    public void setCTO(Employee CTO) {
        this.CTO = CTO;
    }

    public Employee getCFO() {
        return CFO;
    }

    public void setCFO(Employee CFO) {
        this.CFO = CFO;
    }

    public Employee getCIO() {
        return CIO;
    }

    public void setCIO(Employee CIO) {
        this.CIO = CIO;
    }

    public Employee getCMO() {
        return CMO;
    }

    public void setCMO(Employee CMO) {
        this.CMO = CMO;
    }

    public Employee getCVO() {
        return CVO;
    }

    public void setCVO(Employee CVO) {
        this.CVO = CVO;
    }

    public Employee getCOO() {
        return COO;
    }

    public void setCOO(Employee COO) {
        this.COO = COO;
    }

    public Employee getCSO() {
        return CSO;
    }

    public void setCSO(Employee CSO) {
        this.CSO = CSO;
    }

    public Employee getCISO() {
        return CISO;
    }

    public void setCISO(Employee CISO) {
        this.CISO = CISO;
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
    public void hireAll(ArrayList<Employee> listOfWorkersToHire) {
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
    public void fireAll(ArrayList<Employee> listOfWorkersToFire, FireReasons fireReason, String password) {
        if (isPasswordValid(password)) {
            for (Employee employee : listOfWorkersToFire) {
                fireAndRemoveWorkerFromList(employee, fireReason);
            }
        } else {
            System.out.println("Password invalid. Please check the password and try again later.");
        }
    }

    protected void fireAndRemoveWorkerFromList(Employee employee, FireReasons fireReason) {
        if (companyStaffList.contains(employee)) {
            companyStaffList.remove(employee);
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
        List<Employee> copyOfCompanyStaffList = new ArrayList<>();
        copyOfCompanyStaffList.addAll(getCompanyStaff());
        Collections.sort(copyOfCompanyStaffList, new SalaryDescendingComparator());

        count = checkWorkerListLength(copyOfCompanyStaffList, count);

        for (int i = 0; i < count; i++) {
            listOfTopSalaryStaff.add(copyOfCompanyStaffList.get(i));
        }
        return listOfTopSalaryStaff;
    }

    @Override
    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> listOfLowestSalaryStaff = new ArrayList<>();
        List<Employee> copyOfCompanyStaffList = new ArrayList<>();
        copyOfCompanyStaffList.addAll(getCompanyStaff());
        Collections.sort(copyOfCompanyStaffList, new SalaryAscendingComparator());

        count = checkWorkerListLength(copyOfCompanyStaffList, count);

        for (int i = 0; i < count; i++) {
            listOfLowestSalaryStaff.add(copyOfCompanyStaffList.get(i));
        }
        return listOfLowestSalaryStaff;
    }

    protected Integer checkWorkerListLength(List<Employee> list, Integer size) {
        return (list.size() > size) ? size : list.size();
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
                "\nCEO: " + getCEO() + "\nОборот компании: " + getIncome());
    }
}
