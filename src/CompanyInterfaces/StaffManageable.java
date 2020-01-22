package CompanyInterfaces;

import WorkerClass.Worker;
import Enums.FireReasons;

import java.util.ArrayList;

public interface StaffManageable {
    void hire(Worker worker);
    void hireAll(ArrayList<Worker> workerArrayList);

    void fire(Worker worker, FireReasons fireReason);
    void fireAll(Worker worker, FireReasons fireReason, String password);

    void hiredStaffRegistration(Worker worker, String position);
}
