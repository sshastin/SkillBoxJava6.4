package WorkerInterfaces;

import CompanyClass.Company;
import Enums.Positions;
//import Exceptions.VacantPositionException;

public interface Employee {

    String getPositionName();

    void setPosition(Positions position);

    Double getMonthSalary();

    void setMonthSalary(Double monthSalary);

    String getName();// throws VacantPositionException;

    void setName(String name);

    String getFamilyName();

    void setFamilyName(String familyName);

    void setAge(Integer age);

    Integer getAge();

    String getWorkerFullName();; // throws VacantPositionException;

    String getCompanyName();

    void setCompany(Company company);
}
