package src.model;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String department;
    private String role;
    private LocalDate hireDate;

    public Employee() {}

    public Employee(int id, String name, String email, String department, String role, LocalDate hireDate) {
        this.id = id; this.name = name; this.email = email;
        this.department = department; this.role = role; this.hireDate = hireDate;
    }

    // Getters and Setters
}
