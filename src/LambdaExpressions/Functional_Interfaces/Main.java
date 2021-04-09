package LambdaExpressions.Functional_Interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        printEmployees(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployees(employees, "Employees 30 or younger", employee -> employee.getAge() <= 30);
        printEmployees(employees, "Employees younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThen100 = i -> i < 100;
        System.out.println(greaterThan15.and(lessThen100).test(50));
        System.out.println(greaterThan15.and(lessThen100).test(15));

        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for(int i=0; i<10; i++){
            System.out.println(randomSupplier.get());
        }

        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(" ") + 1);
            System.out.println("Last Name is: " + lastName);
        });

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        Random random1 = new Random();
        for(Employee employee : employees){
            if(random1.nextBoolean()){
                System.out.println(getAName(getLastName, employee));
            } else {
                System.out.println(getAName(getFirstName, employee));
            }
        }
    }

    private static String getAName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
    }

    private static void printEmployees(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println("\n" + ageText);
        System.out.println("====================");
        for(Employee employee : employees) {
            if(ageCondition.test(employee)){
                System.out.println(employee.getName() + " " + employee.getAge());
            }
        }
    }
}
