package WorkerClass;

import CompanyClass.Company;
import Enums.Positions;

public class Operator extends Worker {
    public Operator(String name, String familyName, Integer age, Positions position, Double salary, Company company) {
        super(name, familyName, age, position, salary, company);
    }
}
