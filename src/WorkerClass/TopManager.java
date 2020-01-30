package WorkerClass;

import CompanyClass.Company;
import Enums.BonusRates;
import Enums.Positions;
//import Exceptions.VacantPositionException;
import WorkerInterfaces.CanGetBonuses;

public class TopManager extends Worker implements CanGetBonuses {
    public TopManager(String name, String familyName, Integer age, Positions position, Double salary, Company company) {
        super(name, familyName, age, position, salary, company);
    }

    @Override
    public Double getFullReward() {
        return (getMonthSalary() + getBonus());
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
        return super.getMonthSalary();
    }

    @Override
    public void setMonthSalary(Double monthSalary) {
        super.setMonthSalary(monthSalary);
    }

    @Override
    public String getName() {//} throws VacantPositionException {
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
    public String getWorkerFullName() {//} throws VacantPositionException {
        return super.getWorkerFullName();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Double getBonus() {
        Double bonus = 0.0;
        if (this.getCompany().getIncome() > 10_000_000) {
            bonus = getMonthSalary() * BonusRates.TOP_MANAGER_BONUS_RATE.getBONUS_RATE();
        }
        return bonus;
    }
}
