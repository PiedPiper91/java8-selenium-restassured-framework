package EMS;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1","User1","Engg", 50000.0));
        employeeList.add(new Employee("2","User2","HR", 60000.0));
        employeeList.add(new Employee("3","User3","Management", 50000.0));
        employeeList.add(new Employee("4","User4","Engg", 70000.0));
        employeeList.add(new Employee("5","User5","HR", 60000.0));
        employeeList.add(new Employee("6","User6","Management", 40000.0));
        EmployeeOperations employeeOperations = new EmployeeOperations();
        employeeOperations.addEmployee(employeeList, new Employee("7","User7","Engg",50000.0));
        employeeOperations.removeEmployee(employeeList,"2");
        System.out.println("-------------------------------------------");
        employeeList.forEach(System.out::println);
        System.out.println("-------------------------------------------");
        System.out.println(employeeOperations.searchEmployee(employeeList,"5"));
        System.out.println("-------------------------------------------");
        System.out.println(employeeOperations.highestSalary(employeeList));
        System.out.println("-------------------------------------------");
        System.out.println(employeeOperations.averageSalary(employeeList));
        System.out.println("-------------------------------------------");
        System.out.println(employeeOperations.sortBySalaryDesc(employeeList));
        System.out.println("-------------------------------------------");
        System.out.println(employeeOperations.sortByNameAsc(employeeList));
        System.out.println("-------------------------------------------");
        System.out.println(employeeOperations.employeeCount(employeeList));
        System.out.println("-------------------------------------------");
        System.out.println(employeeOperations.highEarningEmployees(employeeList));
        System.out.println("-------------------------------------------");
        employeeOperations.addEmployee(employeeList, new Employee("8","User7","HR",40000.0));
        System.out.println("-------------------------------------------");
        System.out.println(employeeOperations.duplicateNames(employeeList));
        System.out.println("-------------------------------------------");
        }
    }