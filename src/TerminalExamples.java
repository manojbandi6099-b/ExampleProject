import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TerminalExamples {
    public static void main(String[] args)
        {
            List<Employeee> employees = Arrays.asList(
                    new Employeee("Alice", 30, "IT", 60000),
                    new Employeee("Bob", 22, "HR", 40000),
                    new Employeee("Charlie", 28, "Sales", 50000),
                    new Employeee("Diana", 35, "IT", 75000)
            );
            //anyMatch – Is any employee in the Sales department?
         boolean result=   employees.stream().anyMatch(employee->employee.getDepartment().equals("Sales"));
         System.out.println(result);
        boolean result1= employees.stream().allMatch(employee->employee.getSalary()<30000);
        System.out.println(result1);
       boolean result2= employees.stream().noneMatch(employee->employee.getAge()<20);
       System.out.println(result2);
       employees.stream().findFirst().ifPresent(System.out::println);
       employees.stream().findAny().ifPresent(System.out::println);
       System.out.println("====min and max");
      int age= employees.stream().min(Comparator.comparing(Employeee::getAge)).get().getAge();
      System.out.println(age);
      double salary =employees.stream().max(Comparator.comparing(Employeee::getSalary)).get().getSalary();
      System.out.println(salary);

            List<Integer> numbers = Arrays.asList(5, 2, 10, 4);
            List<String> str=Arrays.asList("a", "b", "c", "d");
           Integer numbers1= numbers.stream().reduce(Integer::sum).get();
            System.out.println(numbers1);
            numbers.stream().reduce(Integer::max).ifPresent(System.out::println);
            numbers.stream().reduce(Integer::min).ifPresent(System.out::println);
            numbers.stream().reduce(Integer::sum).ifPresent(System.out::println);
            System.out.println("============");
            numbers.stream().reduce(Integer::compare).ifPresent(System.out::println);
            numbers.stream().reduce((a,b)->a*b).ifPresent(System.out::println);
            str.stream().reduce(String::join).ifPresent(System.out::println);
            System.out.println("{{{{{{{{{{{{{{}}}}}}}}}}");

            List<Integer> num = Arrays.asList(1, 2, 3, 4);
            num.stream().forEach(n->{
                if(n.equals(5)){
                    System.out.println(n);
                }
                else {
                    System.out.println(n);
                }
            });


//System.out.println("terminalExamples");


        }
}
