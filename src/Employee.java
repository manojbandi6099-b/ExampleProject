import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Employee {

        private String name;
        private double salary;
        private String department;

    public Employee(String name, double salary, String department){
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

        // Getters
        public String getName () {
        return name;
    }
        public double getSalary () {
        return salary;
    }
        public String getDepartment () {
        return department;
    }
        public void setName (String name){
        this.name = name;
    }
    public String toString(){
        return name+" "+salary+" "+department;
    }
    public static void main(String[] args)

    {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 60000, "HR"),
                new Employee("Bob", 60000, "IT"),
                new Employee("Charlie", 55000, "HR"),
                new Employee("David", 70000, "IT"),
                new Employee("Alice",40000,"HR")
        );
        employees.stream().map(Employee::getName).forEach(System.out::println);
        List<Double> salaries=employees.stream().map(Employee::getSalary).toList();
        employees.stream().map(e->e.getSalary()*1.10).forEach(System.out::println);
        employees.stream().filter(emp->emp.getSalary()>5500).map(Employee::getDepartment).forEach(System.out::println);
        System.out.println("------------------------------");
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
        employees.stream().map(Employee::getSalary).skip(1).forEach(System.out::println);
        employees.stream().map(Employee::getName).sorted().forEach(System.out::println);
        employees.stream().map(Employee::getDepartment).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)).forEach(System.out::println);
        System.out.println("-----SALARY");
        employees.stream().sorted((e1,e2)-> (int) (e2.getSalary()-e1.salary)).forEach(System.out::println);

    }

}

