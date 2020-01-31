package WorkerClass;

import CompanyClass.Company;
import Enums.BonusRates;
import Enums.Positions;
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
    public Double getBonus() {
        Double bonus = 0.0;
        if (this.getCompany().getIncome() > 10_000_000) {
            bonus = getMonthSalary() * BonusRates.TOP_MANAGER_BONUS_RATE.getBONUS_RATE();
        }
        return bonus;
    }
}
