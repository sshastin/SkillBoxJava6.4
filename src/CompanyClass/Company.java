package CompanyClass;

import WorkerClass.Worker;
import Enums.FireReasons;
import CompanyInterfaces.FinancesManageable;
import CompanyInterfaces.StaffManageable;

public abstract class Company implements FinancesManageable, StaffManageable {

    private Double calculateSeverancePay(Worker worker, FireReasons fireReason, Double workerSalary) {
        Double severancePay;
        switch (fireReason){
            case DEPT_CLOSURE:
            case POSITION_CLOSURE: severancePay = workerSalary * 2;break;
            case OWN_FREE_WILL:severancePay = workerSalary;break;
            case DISCIPLINARY_REASONS:severancePay = 0.0;break;
            case MUTUAL_SIDED_DECISION:severancePay = workerSalary * 1.5;break;
            default:
                throw new IllegalStateException("Неизвестная причина: " + fireReason);
        }
        return severancePay;
    }



}
