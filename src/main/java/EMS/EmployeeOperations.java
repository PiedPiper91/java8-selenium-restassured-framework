package EMS;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeOperations implements EmployeeOperationsManager {
    @Override
    public List<Employee> addEmployee(List<Employee> employeeList,Employee e) {
        employeeList.add(e);
        return employeeList;
    }

    @Override
    public List<Employee> removeEmployee(List<Employee> employeeList,String employeeId) {
        Employee e = employeeList.get(Integer.parseInt(employeeId)-1);
        employeeList.remove(e);
        return employeeList;
    }

    @Override
    public boolean searchEmployee(List<Employee> employeeList,String employeeId) {
        Employee e = employeeList.get(Integer.parseInt(employeeId)-1);
        return employeeList.contains(e);
    }

    @Override
    public double highestSalary(List<Employee> employeeList) {
        return employeeList.stream().mapToDouble(Employee::getSalary).max().getAsDouble();
    }

    @Override
    public double averageSalary(List<Employee> employeeList) {
        return employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();

    }

    //TODO
    @Override
    public List<Employee> groupByDepartment(List<Employee> employeeList) {
        return List.of();
    }

    @Override
    public List<Employee> sortBySalaryDesc(List<Employee> employeeList) {
        Comparator<Employee> byEmployeeSalary = Comparator.comparing(Employee::getSalary).reversed();
        employeeList.sort(byEmployeeSalary);
        return employeeList;
    }

    @Override
    public List<Employee> sortByNameAsc(List<Employee> employeeList) {
        Comparator<Employee> byEmployeeName = Comparator.comparing(Employee::getName);
        employeeList.sort(byEmployeeName);
        return employeeList;
    }

    //TODO
    @Override
    public Set<String> duplicateNames(List<Employee> employeeList) {
        return employeeList.stream().map(Employee::getName).collect(Collectors.toSet());
    }

    @Override
    public double employeeCount(List<Employee> employeeList) {
        return employeeList.stream().count();
    }

    @Override
    public List<Employee> highEarningEmployees(List<Employee> employeeList) {
        return employeeList.stream().filter(employee -> employee.getSalary()>50000).collect(Collectors.toList());
    }
}