package com.automation.lms;

import java.util.ArrayList;
import java.util.List;

public class BookMain {
    public static void main(String[] args) {
        List<Book> employeeList = new ArrayList<>();
        employeeList.add(new Book("1","User1","Engg", 50000.0));
        employeeList.add(new Book("2","User2","HR", 60000.0));
        employeeList.add(new Book("3","User3","Management", 50000.0));
        employeeList.add(new Book("4","User4","Engg", 70000.0));
        employeeList.add(new Book("5","User5","HR", 60000.0));
        employeeList.add(new Book("6","User6","Management", 40000.0));
        LibraryOperationsImpl employeeOperations = new LibraryOperationsImpl();
        employeeOperations.addEmployee(employeeList, new Book("7","User7","Engg",50000.0));
        employeeOperations.removeEmployee(employeeList,"2");
        System.out.println("-------------------------------------------");
        employeeList.forEach(System.out::println);
        System.out.println("-------------------------------------------");
        }
    }