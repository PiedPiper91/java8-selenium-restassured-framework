package com.automation.ems;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeOperationsImpl implements EmployeeOperations {
    @Override
    public List<Employee> addEmployee(List<Employee> employeeList,Employee e) {
        employeeList.add(e);
        return employeeList;
    }

    @Override
    public List<Employee> removeEmployee(List<Employee> employeeList,String employeeId) {
        employeeList.removeIf(employee -> employee.getId().equals(employeeId));
        return employeeList;
    }

    @Override
    public boolean searchEmployee(List<Employee> employeeList,String employeeId) {
        return employeeList.stream().anyMatch(employee -> employee.getId().equals(employeeId));
    }

    @Override
    public double highestSalary(List<Employee> employeeList) {
        return employeeList.stream().mapToDouble(Employee::getSalary).max().orElse(0.0);
    }

    @Override
    public double averageSalary(List<Employee> employeeList) {
        return employeeList.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }

    @Override
    public List<Employee> sortBySalaryDesc(List<Employee> employeeList) {
        Comparator<Employee> byEmployeeSalary = Comparator.comparing(Employee::getSalary).reversed();
        return employeeList.stream().sorted(byEmployeeSalary).collect(Collectors.toList());
    }

    @Override
    public List<Employee> sortByNameAsc(List<Employee> employeeList) {
        Comparator<Employee> byEmployeeName = Comparator.comparing(Employee::getName);
        return employeeList.stream().sorted(byEmployeeName).collect(Collectors.toList());
    }

    //TODO
    @Override
    public Set<String> duplicateNames(List<Employee> employeeList) {
        return employeeList.stream().map(Employee::getName).collect(Collectors.toSet());
    }

    @Override
    public long employeeCount(List<Employee> employeeList) {
        return employeeList.stream().count();
    }

    @Override
    public List<Employee> highEarningEmployees(List<Employee> employeeList) {
        return employeeList.stream().filter(employee -> employee.getSalary()>50000).collect(Collectors.toList());
    }
}