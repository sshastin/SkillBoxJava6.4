package WorkerClass;

import CompanyClass.Company;
import Enums.BonusRates;
import Enums.Positions;
import WorkerInterfaces.CanGetBonuses;
import WorkerInterfaces.CanIncreaseTotalIncome;

public class Manager extends Worker implements CanIncreaseTotalIncome, CanGetBonuses {

    Double individualManagerIncome = 0.0;

    @Override
    public void addIndividualManagerIncome(Double money) {
        individualManagerIncome += money;
        addToTotalCompanyIncome(money);
    }

    @Override
    public Double getIndividualManagerIncome() {
        return individualManagerIncome;
    }

    private void addToTotalCompanyIncome(Double money) {
        getCompany().addTotalIncome(money);
    }

    public Manager(String name, String familyName, Integer age, Positions position, Double salary, Company company) {
        super(name, familyName, age, position, salary, company);
    }

    @Override
    public String getPositionName() {
        return super.getPositionName();
    }

    @Override
    public void setPosition(Positions position) {
        super.setPosition(position);
    }

    @Override
    public Double getMonthSalary() {
        return (super.getMonthSalary() + getBonus());
    }

    @Override
    public void setMonthSalary(Double monthSalary) {
        super.setMonthSalary(monthSalary);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setAge(Integer age) {
        super.setAge(age);
    }

    @Override
    public String getCompanyName() {
        return super.getCompanyName();
    }

    @Override
    public void setCompany(Company company) {
        super.setCompany(company);
    }

    @Override
    protected Company getCompany() {
        return super.getCompany();
    }

    @Override
    public Integer getAge() {
        return super.getAge();
    }

    @Override
    public String getFamilyName() {
        return super.getFamilyName();
    }

    @Override
    public void setFamilyName(String familyName) {
        super.setFamilyName(familyName);
    }

    @Override
    public String getWorkerFullName() {
        return super.getWorkerFullName();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Double getBonus() {
        return (getIndividualManagerIncome() * BonusRates.MANAGER_BONUS_RATE.getBONUS_RATE());
    }
}
