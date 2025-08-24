import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Employeee {
    private String name;
    private int age;
    private String department;
    private double salary;

    // Constructor
    public Employeee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + department + ", " + age + ", $" + salary + ")";
    }
    public static void main (String[] args){
        List<Employeee> employees = Arrays.asList(
                new Employeee("Alice", 35, "HR",6000),
                new Employeee("Bob", 30, "IT",6000),
                new Employeee("Charlie", 28, "HR",5500.0),
                new Employeee("David", 28, "IT",7000.0),
                new Employeee("Alice",46,"HR",8000)

        );
        //1.How would you filter employees who belong to the "HR" department?
        employees.stream().filter(employee->employee.getDepartment().equals("HR")).forEach(employee -> System.out.println(employee));
        //2.How can you extract a list of all employee names using streams?
        employees.stream().map(Employeee::getName).toList().forEach(System.out::println);
        //3.How do you sort employees by their salary in ascending order?
        employees.stream().sorted(Comparator.comparing(Employeee::getSalary)).forEach(System.out::println);
        System.out.println("===============");
        //4.How would you sort employees by age in descending order?
        employees.stream().sorted(Comparator.comparing(Employeee::getAge).thenComparing(Employeee::getSalary).reversed()).forEach(System.out::println);
        System.out.println("---------------");
        //5.How do you get a list of unique departments from the employee list?
        employees.stream().map(Employeee::getDepartment).distinct().forEach(System.out::println);
        System.out.println("===============++++++");
        //7. How do you get the top 3 highest-paid employees, but skip the top one?
        employees.stream().sorted(Comparator.comparing(Employeee::getSalary).reversed()).skip(1).limit(3).forEach(System.out::println);
        System.out.println("===============++++++");
        //How would you sort employees by department, and then by name within each department?
        employees.stream().sorted(Comparator.comparing(Employeee::getDepartment).thenComparing(Comparator.comparing(Employeee::getName))).forEach(System.out::println);
        System.out.println("0000000000");
        //How would you get the names of all employees under 30 working in the "IT" department?
        employees.stream().filter(em->em.getAge()<30 && em.getDepartment().equals("IT")).map(Employeee::getName).forEach(System.out::println);
        System.out.println("===============++++++duplicate");
        //How do you remove duplicate employee names from a list?
        employees.stream().map(Employeee::getName).distinct().forEach(System.out::println);
        //How would you limit the result to the first 5 employees sorted by age?
        employees.stream().sorted(Comparator.comparing(Employeee::getAge)).limit(4).forEach(System.out::println);
        System.out.println("===============++++++toUPPER");
        //How do you use map() to convert employee names to uppercase?
        employees.stream().map(Employeee::getName).map(String::toUpperCase).forEach(System.out::println);
        //How can you use filter() and map() together to get ages of employees in "HR"?
        employees.stream().filter(empp->empp.getDepartment().equals("HR")).map(Employeee::getAge).forEach(System.out::println);
        System.out.println("===============++++++count");
        //How do you count how many employees are in the "HR" department using only intermediate operations?
        employees.stream().filter(e->e.getDepartment().equals("HR"));


    }//
}

