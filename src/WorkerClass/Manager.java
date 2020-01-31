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

    @Override
    public Double getFullReward() {
        return (getMonthSalary() + getBonus());
    }

    public Manager(String name, String familyName, Integer age, Positions position, Double salary, Company company) {
        super(name, familyName, age, position, salary, company);
    }

    @Override
    public Double getBonus() {
        return (getIndividualManagerIncome() * BonusRates.MANAGER_BONUS_RATE.getBONUS_RATE());
    }
}
