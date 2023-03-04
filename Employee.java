import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private String department;
    private double salary;

    public Employee(String firstName, String lastName, String department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return this.firstName.equals(employee.firstName) && this.lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return firstName.hashCode() + lastName.hashCode();
    }
}