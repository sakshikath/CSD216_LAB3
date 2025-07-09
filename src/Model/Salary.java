package src.model;

public class Salary {
    private int id;
    private int employeeId;
    private double monthlySalary;
    private double bonus;

    public Salary() {}

    public Salary(int id, int employeeId, double monthlySalary, double bonus) {
        this.id = id; this.employeeId = employeeId;
        this.monthlySalary = monthlySalary; this.bonus = bonus;
    }

    
}
