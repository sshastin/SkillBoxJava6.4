package WorkerClass;

import CompanyClass.Company;
import Enums.Positions;
import WorkerInterfaces.Employee;

public abstract class Worker implements Employee {

    private Double salary;
    private Positions position;
    private Integer age;
    private String name;
    private String familyName;
    private Company company;

    public Worker(String name, String familyName, Integer age, Positions position, Double salary, Company company) {
        setName(name);
        setFamilyName(familyName);
        setAge(age);
        setPosition(position);
        setMonthSalary(salary);
        setCompany(company);
    }

    @Override
    public String getPositionName() {
        return position.getPOSITION_NAME();
    }

    @Override
    public void setPosition(Positions position) {
        this.position = position;
    }

    @Override
    public Double getMonthSalary() {
        return salary;
    }

    @Override
    public void setMonthSalary(Double monthSalary) {
        this.salary = monthSalary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getCompanyName() {
        return company.getCompanyName();
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    protected Company getCompany() {
        return company;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public String getFamilyName() {
        return familyName;
    }

    @Override
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String getWorkerFullName() {
        return (getName() + " " + getFamilyName());
    }

    @Override
    public String toString() {
        return ("Досье работника:\nИмя: " + getName() + "\nФамилия: " + getFamilyName() + "\nВозраст: " +
                getAge() + "\nДолжность в компании: " + getPositionName() + "\nЗароботная плата: " + getMonthSalary());
    }
}
