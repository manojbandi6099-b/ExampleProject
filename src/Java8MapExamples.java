import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8MapExamples {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("java", "stream", "map");
        input.stream().map(String::toLowerCase).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(2, 4, 6, 8);
    numbers.stream().map(x->x*x).forEach(System.out::println);
        List<Person> people = Arrays.asList(
                new Person("Alice", 28),
                new Person("Bob", 34)
        );
       List<Integer> nameLenght= people.stream().map(Person::getName).map(String::length).toList();
       nameLenght.forEach(System.out::println);

        List<String> fullNames = Arrays.asList("John Doe", "Jane Smith");
        //below code make java8 simple

fullNames.stream().map(s->
    s.split(" ")).map(e->e[0]).forEach(System.out::println);

        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2023, 5, 12),
                LocalDate.of(2024, 11, 3)
        );
        //dates.stream().map(e->e.format(dayOfMonth,month,year))


    }
    static class Person {

        String name;
        int age;
        // constructor + getters
         Person(String firstName, int lastName) {
            this.name=firstName;
            this.age=lastName;
        }
        public String getName() {
             return name;
        }
       public int getAge() {
             return age;
       }
       public String toString() {
             return "Person [name=" + name + ", age=" + age + "]";
       }
    }



}
