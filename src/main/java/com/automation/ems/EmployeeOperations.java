package com.automation.ems;
//Implement the Employee Management System using Java 8 Streams for all querying, filtering, sorting, and aggregation operations.
//Focus on clean object-oriented design rather than squeezing everything into a main() method.


import java.util.List;
import java.util.Set;

public interface EmployeeOperations {
    public List<Employee> addEmployee(List<Employee> employeelist, Employee e);

    public List<Employee> removeEmployee(List<Employee> employeelist,String employeeId);

    public boolean searchEmployee(List<Employee> employeelist,String employeeId);

    public double highestSalary(List<Employee> employeelist);

    public double averageSalary(List<Employee> employeelist);

    public List<Employee> groupByDepartment(List<Employee> employeeList);

    public List<Employee> sortBySalaryDesc(List<Employee> employeeList);

    public List<Employee> sortByNameAsc(List<Employee> employeeList);

    public Set<String> duplicateNames(List<Employee> employeeList);

    public long employeeCount(List<Employee> employeelist);

    public List<Employee> highEarningEmployees(List<Employee> employeelist);
}
