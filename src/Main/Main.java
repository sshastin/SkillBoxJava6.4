package Main;

import AutoTests.WorkersAutoCreate;
import CompanyClass.EngineeringCompany;
import CompanyClass.ITCompany;
import Enums.Positions;
import WorkerInterfaces.Employee;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Создаем компании
        EngineeringCompany engineeringCompany = new EngineeringCompany("EngComp", "987654321");
        ITCompany itCompany = new ITCompany("IOI", "Qwerty123");

        WorkersAutoCreate workersAutoCreator = WorkersAutoCreate.getInstance();

        //Создаем лист Топ менеджеров для EngComp

        List<Employee> listOfTopManagersEngComp = workersAutoCreator.getDefinedNumberListOfEmployees(Positions.TOP_MANAGER, 10, engineeringCompany);

        for (Employee employee : listOfTopManagersEngComp) {
            System.out.println(employee);
        }


        // write your code here
    }
}