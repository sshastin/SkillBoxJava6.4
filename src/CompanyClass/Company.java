package CompanyClass;

import ComparatorClasses.SalaryAscendingComparator;
import Enums.FireReasons;
import CompanyInterfaces.FinancesManage;
import CompanyInterfaces.StaffManage;
import ComparatorClasses.SalaryDescendingComparator;
//import Exceptions.VacantPositionException;
import Enums.Positions;
import WorkerClass.Worker;
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

    public Employee getCEO() {
        return CEO;
    }

    public void setCEO(Employee CEO) {
        hire(CEO);
        this.CEO = CEO;
    }

    public Employee getCAO() {
        return CAO;
    }

    public void setCAO(Employee CAO) {
        hire(CAO);
        this.CAO = CAO;
    }

    public Employee getCTO() {
        return CTO;
    }

    public void setCTO(Employee CTO) {
        hire(CTO);
        this.CTO = CTO;
    }

    public Employee getCFO() {
        return CFO;
    }

    public void setCFO(Employee CFO) {
        hire(CFO);
        this.CFO = CFO;
    }

    public Employee getCIO() {
        return CIO;
    }

    public void setCIO(Employee CIO) {
        hire(CIO);
        this.CIO = CIO;
    }

    public Employee getCMO() {
        return CMO;
    }

    public void setCMO(Employee CMO) {
        hire(CMO);
        this.CMO = CMO;
    }

    public Employee getCVO() {
        return CVO;
    }

    public void setCVO(Employee CVO) {
        hire(CVO);
        this.CVO = CVO;
    }

    public Employee getCOO() {
        return COO;
    }

    public void setCOO(Employee COO) {
        hire(COO);
        this.COO = COO;
    }

    public Employee getCSO() {
        return CSO;
    }

    public void setCSO(Employee CSO) {
        hire(CSO);
        this.CSO = CSO;
    }

    public Employee getCISO() {
        return CISO;
    }

    public void setCISO(Employee CISO) {
        hire(CISO);
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
    public void hireAll(List<Employee> listOfWorkersToHire) {
        this.companyStaffList.addAll(listOfWorkersToHire);
    }

    @Override
    public void fire(Employee employee, FireReasons fireReason, String password) {//} throws VacantPositionException {
        if (isPasswordValid(password)) {
            fireAndRemoveWorkerFromList(employee, fireReason);
        } else {
            System.out.println("Password invalid. Please check the password and try again later.");
        }
    }

    @Override
    public void fireAll(List<Employee> listOfWorkersToFire, FireReasons fireReason, String password) {//} throws VacantPositionException {
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
            if (employee.getPositionName().equals(Positions.TOP_MANAGER.getPOSITION_NAME())) {
                fireTopManager(employee);
            }
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
            if (copyOfCompanyStaffList.get(i).getMonthSalary() == 0.0) {
                continue;
            }
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
            if (copyOfCompanyStaffList.get(i).getMonthSalary() == 0.0) {
                continue;
            }
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

    protected void fireTopManager(Employee employee) {
        String workerFullName = employee.getWorkerFullName();
        Employee defaultEmployee = new Employee() {//Тут проще использовать анонимный класс для создания некого абстрактного работника, так как должность не может пустовать
            @Override
            public String getPositionName() {
                return "Vacant";
            }

            @Override
            public void setPosition(Positions position) {

            }

            @Override
            public Double getMonthSalary() {
                return 0.0;
            }

            @Override
            public void setMonthSalary(Double monthSalary) {

            }

            @Override
            public String getName() {
                return "N/A";
            }

            @Override
            public void setName(String name) {

            }

            @Override
            public String getFamilyName() {
                return "N/A";
            }

            @Override
            public void setFamilyName(String familyName) {

            }

            @Override
            public void setAge(Integer age) {

            }

            @Override
            public Integer getAge() {
                return 0;
            }

            @Override
            public String getWorkerFullName() {
                return "N/A";
            }

            @Override
            public String getCompanyName() {
                return companyName;
            }

            @Override
            public void setCompany(Company company) {

            }
        };
        if (workerFullName.equals(getCEO().getWorkerFullName())) {
            setCEO(defaultEmployee);
        } else if (workerFullName.equals(getCAO().getWorkerFullName())) {
            setCAO(defaultEmployee);
        } else if (workerFullName.equals(getCFO())) {
            setCFO(defaultEmployee);
        } else if (workerFullName.equals(getCIO())) {
            setCIO(defaultEmployee);
        } else if (workerFullName.equals(getCISO())) {
            setCISO(defaultEmployee);
        } else if (workerFullName.equals(getCMO())) {
            setCMO(defaultEmployee);
        } else if (workerFullName.equals(getCOO())) {
            setCOO(defaultEmployee);
        } else if (workerFullName.equals(getCSO())) {
            setCSO(defaultEmployee);
        } else if (workerFullName.equals(getCTO())) {
            setCTO(defaultEmployee);
        } else if (workerFullName.equals(getCVO())) {
            setCVO(defaultEmployee);
        }
    }
}
