package WorkerClass;

import WorkerInterfaces.Employee;

public abstract class Worker implements Employee {

    private String position;

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPosition() {
        this.position = position;
    }
}
