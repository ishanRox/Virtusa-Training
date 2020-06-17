import java.util.ArrayList;
import java.util.List;

/**
 * compositeTest
 */
public class compositeTest {

    public static void main(String[] args) {
        System.out.println("Composite pattern this is a structural design pattern ");
        System.out.println("_______________________________________________");
        Employee principal = new Employee("Principal", 80000);
        Employee teacher = new Employee("teacher", 50000);

        Employee teacher1 = new Employee("teacher1", 60000);
        principal.add(teacher);
        principal.add(teacher1);

        Employee student1 = new Employee("stu1", 800);
        Employee student2 = new Employee("stu2", 800);
        Employee student3 = new Employee("stu3", 800);
        Employee student4 = new Employee("stu4", 800);

        Employee studentPrefect = new Employee("prefect", 1800);

        studentPrefect.add(student1);
        studentPrefect.add(student2);
        studentPrefect.add(student3);
        studentPrefect.add(student4);
        teacher.add(studentPrefect);

        principal.printTree();

    }
}

class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        subordinates = new ArrayList<>();
    }
    // subordinates mean workers under this employee
    // a person under the authority or control of another within an organization.

    private List<Employee> subordinates;

    // methods to add and remove employees from the list
    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    // get subordinates under this employee

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void printTree() {
        if (subordinates.size() != 0) {
            System.out.println("___________________________________ under " + this.name);
            for (Employee employee : subordinates) {
                System.out.println(employee);
                employee.printTree();
            }
            System.out.println("___________________________________over "+this.name);
        } else {
            return;
        }
    }

    @Override
    public String toString() {
        return ("Employee :[ Name : " + name + ", salary" + salary + "]");

    }

}