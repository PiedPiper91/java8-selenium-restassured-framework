package com.automation.lms;

import java.lang.Exception;
import java.util.List;

public interface LibraryOperations {
    public List<Book> addBook(List<Book> bookList, Book newbook) throws Exception;

    public List<Book> removeBook(List<Book> bookList, String bookId);

    public boolean searchById(List<Book> bookList, String id);

    public boolean searchByTitle(List<Book> bookList, String title);

    public boolean searchByAuthor(List<Book> bookList, String author);

    public boolean searchByGenre(List<Book> bookList, String genre);

    public Book updateBookPrice(Book book, Double price);

    public int borrowBook(Book book);

    public int returnBook(Book book);

    public long totalBooks(List<Book> bookList);

    public double averagePrice(List<Book> bookList);

    public double mostExpensiveBook(List<Book> bookList);

    public double cheapestBook(List<Book> bookList);

    public List<Book> booksPublishedAfter2015(List<Book> bookList);

    public List<Book> booksWithPriceGreaterThan500(List<Book> bookList);

    public List<Book> sortByTitle(List<Book> bookList);

    public List<Book> sortByPrice(List<Book> bookList);

    public List<Book> sortByPublicationYear(List<Book> bookList);

//    Group books by genre - Map<String, List<Book>>
//    Group books by author - Map<String, List<Book>>
//    Count books per genre - Map<String, Long>

}
