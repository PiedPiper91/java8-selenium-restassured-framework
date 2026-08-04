package com.automation.lms;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface LibraryOperations {
    public List<Book> addBook(List<Book> bookList, Book newbook) throws DuplicateBookException;

    public List<Book> removeBook(List<Book> bookList, String bookId) throws BookNotFoundException;

    public boolean searchById(List<Book> bookList, String id);

    public boolean searchByTitle(List<Book> bookList, String title);

    public boolean searchByAuthor(List<Book> bookList, String author);

    public boolean searchByGenre(List<Book> bookList, String genre);

    public Book updateBookPrice(Book book, Double price);

    public int borrowBook(Book book) throws BookNotAvailableException;

    public int returnBook(Book book);

    public long totalBooks(List<Book> bookList);

    public Optional<Book> averagePrice(List<Book> bookList);

    public Optional<Book> mostExpensiveBook(List<Book> bookList);

    public Optional<Book> cheapestBook(List<Book> bookList);

    public List<Book> booksPublishedAfter2015(List<Book> bookList);

    public List<Book> booksWithPriceGreaterThan500(List<Book> bookList);

    public List<Book> sortByTitle(List<Book> bookList);

    public List<Book> sortByPrice(List<Book> bookList);

    public List<Book> sortByPublicationYear(List<Book> bookList);

    Map<String, List<Book>> groupByGenre(List<Book> bookList);

    Map<String, List<Book>> groupByAuthor(List<Book> bookList);

    Map<String, Long> countPerGenre(List<Book> bookList);

//    Group books by genre - Map<String, List<Book>>
//    Group books by author - Map<String, List<Book>>
//    Count books per genre - Map<String, Long>

}
