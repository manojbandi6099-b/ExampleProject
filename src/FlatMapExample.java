import java.util.*;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5,3)
        );


        List<Employee> teamA = new ArrayList<>();
        teamA.add(new Employee("Alice", 601));
        teamA.add(new Employee("Bob", 102));

        // Create second team
        List<Employee> teamB = new ArrayList<>();
        teamB.add(new Employee("Charlie", 201));
        teamB.add(new Employee("David", 202));

        // Create third team
        List<Employee> teamC = new ArrayList<>();
        teamC.add(new Employee("Alice", 301));

        // Combine teams into a List of Lists
        List<List<Employee>> allTeams = new ArrayList<>();
        allTeams.add(teamA);
        allTeams.add(teamB);
        allTeams.add(teamC);
        allTeams.stream().flatMap(Collection::stream).sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)).forEach(System.out::println);
numbers.stream().flatMap(Collection::stream).map(number->number*number).toList().forEach(System.out::println);
    }
    public static class Employee {
        String name;
        int age;
        public Employee(String name, int age) {
            this.name = name;
            this.age=age;
        }
        public String toString(){
            return  name+" "+age;
        }
        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
    }
}
