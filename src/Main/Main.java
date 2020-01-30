package Main;

import AutoTests.WorkersAutoTester;
import CompanyClass.EngineeringCompany;
import CompanyClass.ITCompany;
import Enums.FireReasons;
import Enums.Positions;
//import Exceptions.VacantPositionException;
import WorkerClass.Manager;
import WorkerClass.TopManager;
import WorkerInterfaces.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {//} throws VacantPositionException {
        //Создаем компании
        EngineeringCompany engineeringCompany = new EngineeringCompany("EngComp", "987654321");
        ITCompany itCompany = new ITCompany("IOI", "Qwerty123");

        WorkersAutoTester workersAutoTester = WorkersAutoTester.getInstance();

        //Создаем лист Топ менеджеров для EngComp

        List<Employee> listOfTopManagersEngComp = workersAutoTester.getDefinedNumberListOfEmployees(Positions.TOP_MANAGER, 10, engineeringCompany);
        List<Employee> listOfManagersEngComp = workersAutoTester.getDefinedNumberListOfEmployees(Positions.MANAGER, 80, engineeringCompany);
        List<Employee> listOfOperatorsEngComp = workersAutoTester.getDefinedNumberListOfEmployees(Positions.OPERATOR, 180, engineeringCompany);

        engineeringCompany.hireAll(listOfManagersEngComp);
        engineeringCompany.hireAll(listOfOperatorsEngComp);

        int i = listOfTopManagersEngComp.size();
        engineeringCompany.setCEO(listOfTopManagersEngComp.get(--i));
        engineeringCompany.setCAO(listOfTopManagersEngComp.get(--i));
        engineeringCompany.setCFO(listOfTopManagersEngComp.get(--i));
        engineeringCompany.setCIO(listOfTopManagersEngComp.get(--i));
        engineeringCompany.setCISO(listOfTopManagersEngComp.get(--i));
        engineeringCompany.setCOO(listOfTopManagersEngComp.get(--i));
        engineeringCompany.setCSO(listOfTopManagersEngComp.get(--i));
        engineeringCompany.setCTO(listOfTopManagersEngComp.get(--i));
        engineeringCompany.setCVO(listOfTopManagersEngComp.get(--i));
        engineeringCompany.setCMO(listOfTopManagersEngComp.get(--i));

        List<Employee> lowestSalaries = engineeringCompany.getLowestSalaryStaff(30);
        List<Employee> highestSalaries = engineeringCompany.getTopSalaryStaff(15);

        i = 1;
        System.out.println("\nСамые низкие зарплаты:");
        for (Employee employee : lowestSalaries) {
            System.out.println(i++ + ". " + employee.getPositionName() + " " + employee.getMonthSalary());
        }

        i = 1;
        System.out.println("\nСамые высокие зарплаты:");
        for (Employee employee : highestSalaries) {
            System.out.println(i++ + ". " + employee.getPositionName() + " " + employee.getMonthSalary());
        }

        for (Employee employee : listOfTopManagersEngComp) {
            System.out.println(employee.getMonthSalary());
        }

        List<Manager> managerList = new ArrayList<>();

        for (Employee employee : listOfManagersEngComp) {
            managerList.add((Manager) employee);
        }

        System.out.println("Зарплаты Топов до поступления денег на счет компании:");
        i = 1;
        for (Employee employee : listOfTopManagersEngComp) {
            System.out.println(i++ + ". " + ((TopManager) employee).getFullReward());
        }

        workersAutoTester.increaseCompanyIncomeByManagers(listOfManagersEngComp, 100_000.0, 5_000_000.0);

        System.out.printf("Доход компании %.2f\n", engineeringCompany.getIncome());

        System.out.println("Зарплаты Топов после поступления денег на счет компании:");
        i = 1;
        for (Employee employee : listOfTopManagersEngComp) {
            System.out.println(i++ + ". " + ((TopManager) employee).getFullReward());
        }

        List<Integer> listOfNumbersToFire = workersAutoTester.getDefinedNumberListOfEmployeesToFire(engineeringCompany.getCompanyStaff(), engineeringCompany.getCompanyStaff().size() / 2);
        List<Employee> listToFire = new ArrayList<>();

        for (Integer index : listOfNumbersToFire) {
            listToFire.add(engineeringCompany.getCompanyStaff().get(index));
        }
        System.out.println("Fire CAO ");
        engineeringCompany.fire(engineeringCompany.getCAO(), FireReasons.OWN_FREE_WILL, "987654321");
        System.out.println(engineeringCompany.getCAO().toString());

        highestSalaries = engineeringCompany.getTopSalaryStaff(10);
        lowestSalaries = engineeringCompany.getLowestSalaryStaff(30);

        i = 1;
        System.out.println("\nСамые низкие зарплаты:");
        for (Employee employee : lowestSalaries) {
            System.out.println(i++ + ". " + employee.getPositionName() + " " + employee.getMonthSalary());
        }

        i = 1;
        System.out.println("\nСамые высокие зарплаты:");
        for (Employee employee : highestSalaries) {
            System.out.println(i++ + ". " + employee.getPositionName() + " " + employee.getMonthSalary());
        }

        System.out.println("Количество сотрудников до сокращения: " + engineeringCompany.getCompanyStaff().size());
        engineeringCompany.fireAll(listToFire, FireReasons.DEPT_CLOSURE, "987654321");
        System.out.println("Количество сотрудников после сокращения: " + engineeringCompany.getCompanyStaff().size());

        highestSalaries = engineeringCompany.getTopSalaryStaff(10);
        lowestSalaries = engineeringCompany.getLowestSalaryStaff(30);

        i = 1;
        System.out.println("\nСамые низкие зарплаты:");
        for (Employee employee : lowestSalaries) {
            System.out.println(i++ + ". " + employee.getPositionName() + " " + employee.getMonthSalary());
        }

        i = 1;
        System.out.println("\nСамые высокие зарплаты:");
        for (Employee employee : highestSalaries) {
            System.out.println(i++ + ". " + employee.getPositionName() + " " + employee.getMonthSalary());
        }
        // write your code here
    }
}