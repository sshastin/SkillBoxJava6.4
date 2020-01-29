package AutoTests;

import CompanyClass.Company;
import Enums.Positions;
import WorkerClass.Manager;
import WorkerClass.Operator;
import WorkerClass.TopManager;
import WorkerClass.Worker;
import WorkerInterfaces.Employee;

import java.util.*;

public class WorkersAutoCreate {

    private static WorkersAutoCreate instance = null;
    private final Integer MIN_VALUE_UPPER_CASE = 0x0041;
    private final Integer MAX_VALUE_UPPER_CASE = 0x005A;
    private final Integer MIN_VALUE_LOWER_CASE = 0x0061;
    private final Integer MAX_VALUE_LOWER_CASE = 0x007A;
    private final Integer MIN_NAME_LENGTH = 5;
    private final Integer MAX_NAME_LENGTH = 15;
    private final Integer MIN_AGE = 18;
    private final Integer MAX_AGE = 65;
    private final Double MAX_TOP_MANAGER_SALARY = 1_000_000.0;
    private final Double MIN_TOP_MANAGER_SALARY = 200_000.0;
    private final Double MAX_MANAGER_SALARY = 150_000.0;
    private final Double MIN_MANAGER_SALARY = 50_000.0;
    private final Double MAX_OPERATOR_SALARY = 50_000.0;
    private final Double MIN_OPERATOR_SALARY = 20_000.0;


    private Random random = new Random();


    private WorkersAutoCreate() {

    }

    public static WorkersAutoCreate getInstance() {
        if (instance == null) {
            instance = new WorkersAutoCreate();
        }
        return instance;
    }

    public List<Employee> getDefinedNumberListOfEmployees(Positions position, Integer numberOfEmployees, Company company) {
        /**
         * String name, String familyName, Integer age, Positions position, Double salary, Company company
         */
        String name;
        String familyName;
        Integer age;
        Double salary;

        List<Employee> employeeList = new ArrayList<>();

        /**
         * Manager, Top manager, Operator
         */

        if (position.getPOSITION_NAME().equals("Top manager")) {
            for (int i = 0; i < numberOfEmployees; i++) {
                name = getRandomName();
                familyName = getRandomFamilyName();
                age = getRandomNumberWithinRange(MIN_AGE, MAX_AGE);
                salary = getRandomDoubleWithinRange(MIN_TOP_MANAGER_SALARY, MAX_TOP_MANAGER_SALARY);
                employeeList.add(new TopManager(name, familyName, age, position, salary, company));
            }
        } else if (position.getPOSITION_NAME().equals("Manager")) {
            for (int i = 0; i < numberOfEmployees; i++) {
                name = getRandomName();
                familyName = getRandomFamilyName();
                age = getRandomNumberWithinRange(MIN_AGE, MAX_AGE);
                salary = getRandomDoubleWithinRange(MIN_MANAGER_SALARY, MAX_MANAGER_SALARY);
                employeeList.add(new Manager(name, familyName, age, position, salary, company));
            }
        } else if (position.getPOSITION_NAME().equals("Operator")) {
            for (int i = 0; i < 0; i++) {
                name = getRandomName();
                familyName = getRandomFamilyName();
                age = getRandomNumberWithinRange(MIN_AGE, MAX_AGE);
                salary = getRandomDoubleWithinRange(MIN_OPERATOR_SALARY, MAX_OPERATOR_SALARY);
                employeeList.add(new Operator(name, familyName, age, position, salary, company));
            }
        }
        return employeeList;
    }

    public List<Integer> getDefinedNumberListOfEmployeesToFire(List<Employee> employeeList, Integer number) {
        HashSet<Integer> numbers = new HashSet<>();

        if (employeeList.size() < number) {
            number = employeeList.size();
        }

        while (numbers.size() < number) {
            numbers.add(getRandomNumberWithinRange(0, number + 1));
        }

        List<Integer> numbersOfWorkersToFire = new ArrayList<>();
        numbersOfWorkersToFire.addAll(numbers);
        return numbersOfWorkersToFire;
    }

    private String getRandomName() {
        return getRandomCharactersWithinRange(MIN_VALUE_LOWER_CASE, MAX_VALUE_LOWER_CASE, getRandomNumberWithinRange(MIN_NAME_LENGTH, MAX_NAME_LENGTH));
    }

    private String getRandomFamilyName() {
        return getRandomCharactersWithinRange(MIN_VALUE_UPPER_CASE, MAX_VALUE_UPPER_CASE, getRandomNumberWithinRange(MIN_NAME_LENGTH, MAX_NAME_LENGTH));
    }

    private Integer getRandomNumberWithinRange(Integer min, Integer max) {
        return (min + random.nextInt(max - min + 1));
    }

    private String getRandomCharactersWithinRange(Integer min, Integer max, Integer length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(Character.toChars(getRandomNumberWithinRange(min, max)));
        }
        return stringBuilder.toString();
    }

    private Double getRandomDoubleWithinRange(Double min, Double max) {
        return (min + random.nextInt((int) (max - min + 1.0)));
    }
}
