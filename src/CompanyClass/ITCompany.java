package CompanyClass;

import Enums.FireReasons;
import WorkerInterfaces.Employee;

import java.util.ArrayList;
import java.util.List;

public class ITCompany extends Company {

    public ITCompany(String companyName, String passwordToFire) {
        super(companyName, passwordToFire);
    }

    @Override
    public String getCompanyName() {
        return super.getCompanyName();
    }

    @Override
    public void setCompanyName(String companyName) {
        super.setCompanyName(companyName);
    }

    @Override
    public List<Employee> getCompanyStaff() {
        return super.getCompanyStaff();
    }

    @Override
    public Employee getCEO() {
        return super.getCEO();
    }

    @Override
    public void setCEO(Employee CEO) {
        super.setCEO(CEO);
    }

    @Override
    public Employee getCAO() {
        return super.getCAO();
    }

    @Override
    public void setCAO(Employee CAO) {
        super.setCAO(CAO);
    }

    @Override
    public Employee getCTO() {
        return super.getCTO();
    }

    @Override
    public void setCTO(Employee CTO) {
        super.setCTO(CTO);
    }

    @Override
    public Employee getCFO() {
        return super.getCFO();
    }

    @Override
    public void setCFO(Employee CFO) {
        super.setCFO(CFO);
    }

    @Override
    public Employee getCIO() {
        return super.getCIO();
    }

    @Override
    public void setCIO(Employee CIO) {
        super.setCIO(CIO);
    }

    @Override
    public Employee getCMO() {
        return super.getCMO();
    }

    @Override
    public void setCMO(Employee CMO) {
        super.setCMO(CMO);
    }

    @Override
    public Employee getCVO() {
        return super.getCVO();
    }

    @Override
    public void setCVO(Employee CVO) {
        super.setCVO(CVO);
    }

    @Override
    public Employee getCOO() {
        return super.getCOO();
    }

    @Override
    public void setCOO(Employee COO) {
        super.setCOO(COO);
    }

    @Override
    public Employee getCSO() {
        return super.getCSO();
    }

    @Override
    public void setCSO(Employee CSO) {
        super.setCSO(CSO);
    }

    @Override
    public Employee getCISO() {
        return super.getCISO();
    }

    @Override
    public void setCISO(Employee CISO) {
        super.setCISO(CISO);
    }

    @Override
    public Double getIncome() {
        return super.getIncome();
    }

    @Override
    public void addTotalIncome(Double income) {
        super.addTotalIncome(income);
    }

    @Override
    public void hire(Employee worker) {
        super.hire(worker);
    }

    @Override
    public void hireAll(ArrayList<Employee> listOfWorkersToHire) {
        super.hireAll(listOfWorkersToHire);
    }

    @Override
    public void fire(Employee worker, FireReasons fireReason, String password) {
        super.fire(worker, fireReason, password);
    }

    @Override
    public void fireAll(ArrayList<Employee> listOfWorkersToFire, FireReasons fireReason, String password) {
        super.fireAll(listOfWorkersToFire, fireReason, password);
    }

    @Override
    public List<Employee> getTopSalaryStaff(int count) {
        return super.getTopSalaryStaff(count);
    }

    @Override
    public List<Employee> getLowestSalaryStaff(int count) {
        return super.getLowestSalaryStaff(count);
    }

    @Override
    protected Double calculateSeverancePay(FireReasons fireReason, Double workerSalary) {
        return super.calculateSeverancePay(fireReason, workerSalary);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
