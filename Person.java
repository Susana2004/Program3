package Program3;
import java.util.Calendar;
public class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public void displayName() {
        System.out.println("Name: " + name);
    }
   public void displayAge(String dobStr) {String[] parts;
        int day = 0, month = 0, year = 0;
        if (dobStr.contains("-")) {
            parts = dobStr.split("-");
            if (dobStr.matches("\\d{2}-\\d{2}-\\d{4}")) {
                day = Integer.parseInt(parts[0]);
                month = Integer.parseInt(parts[1]) - 1; // Calendar month is 0-based
                year = Integer.parseInt(parts[2]);
            } else if (dobStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
                year = Integer.parseInt(parts[0]);
                month = Integer.parseInt(parts[1]) - 1;
                day = Integer.parseInt(parts[2]);
            }
        }
       Calendar dob = Calendar.getInstance();
        dob.set(year, month, day);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        System.out.println("Age: " + age);
    }
}
class Employee extends Person {
    private int empId;
    private double salary;
    public Employee(String name, int empId, double salary) {
        super(name);
        this.empId = empId;
        this.salary = salary;
    }
    public void displayEmployeeDetails() {
        displayName();
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: $" + salary);
    }
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 101, 60000.0);
        emp.displayEmployeeDetails();
        emp.displayAge("15-04-1995"); // or use "1995-04-15"
    }
}
