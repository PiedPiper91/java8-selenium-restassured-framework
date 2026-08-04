package com.automation.lms;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryOperationsImpl implements LibraryOperations {
    @Override
    public List<Book> addBook(List<Book> bookList, Book newbook) throws DuplicateBookException {
        if(bookList.stream().noneMatch(book -> book.getBookId().equals(newbook.getBookId())))
        {
            bookList.add(newbook);
        }
        else
            throw new DuplicateBookException("Duplicate book is present");
        return bookList;
    }

    @Override
    public List<Book> removeBook(List<Book> bookList, String bookId) throws BookNotFoundException {
        boolean removed =
                bookList.removeIf(
                        book ->
                                book.getBookId().equals(bookId));

        if(!removed){
            throw new BookNotFoundException("Book not found");
        }
        return bookList;
    }

    @Override
    public boolean searchById(List<Book> bookList, String id) {
        return bookList.stream().anyMatch(book -> book.getBookId().equals(id));
    }

    @Override
    public boolean searchByTitle(List<Book> bookList, String title) {
        return bookList.stream().anyMatch(book -> book.getTitle().equals(title));
    }

    @Override
    public boolean searchByAuthor(List<Book> bookList, String author) {
        return bookList.stream().anyMatch(book -> book.getAuthor().equals(author));
    }

    @Override
    public boolean searchByGenre(List<Book> bookList, String genre) {
        return bookList.stream().anyMatch(book -> book.getGenre().equals(genre));
    }

    @Override
    public Book updateBookPrice(Book book, Double price) {
        book.setPrice(price);
        return book;
    }

    @Override
    public int borrowBook(Book book) throws BookNotAvailableException {
        if(book.getAvailableCopies()==0){
            throw new BookNotAvailableException(
                    "Book unavailable");
        }
        book.setAvailableCopies(
                book.getAvailableCopies()-1);
        return book.getAvailableCopies();
    }

    @Override
    public int returnBook(Book book) {
        book.setAvailableCopies(book.getAvailableCopies()+1);
        return book.getAvailableCopies();
    }

    @Override
    public long totalBooks(List<Book> bookList) {
        return bookList.stream().count();
    }

    @Override
    public double averagePrice(List<Book> bookList) {
        return bookList.stream().mapToDouble(Book::getPrice).average().orElse(0.0);
    }

    @Override
    public Optional<Book> mostExpensiveBook(List<Book> bookList) {
        return bookList.stream().max(Comparator.comparing(Book::getPrice));
    }

    @Override
    public Optional<Book> cheapestBook(List<Book> bookList) {
        return bookList.stream().min(Comparator.comparing(Book::getPrice));
    }

    @Override
    public List<Book> booksPublishedAfter2015(List<Book> bookList) {
        return bookList.stream().filter(book -> book.getPublicationYear()>2015).collect(Collectors.toList());
    }

    @Override
    public List<Book> booksWithPriceGreaterThan500(List<Book> bookList) {
        return bookList.stream().filter(book -> book.getPrice()>500).collect(Collectors.toList());
    }

    @Override
    public List<Book> sortByTitle(List<Book> bookList) {
        Comparator<Book> byTitle = Comparator.comparing(Book::getTitle);
        return bookList.stream().sorted(byTitle).collect(Collectors.toList());
    }

    @Override
    public List<Book> sortByPrice(List<Book> bookList) {
        Comparator<Book> byPrice = Comparator.comparing(Book::getPrice);
        return bookList.stream().sorted(byPrice).collect(Collectors.toList());
    }

    @Override
    public List<Book> sortByPublicationYear(List<Book> bookList) {
        Comparator<Book> byPublicationYear = Comparator.comparing(Book::getPublicationYear);
        return bookList.stream().sorted(byPublicationYear).collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Book>> groupByGenre(List<Book> bookList) {
        return bookList.stream().collect(Collectors.groupingBy(Book::getGenre));
    }

    @Override
    public Map<String, List<Book>> groupByAuthor(List<Book> bookList) {
        return bookList.stream().collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public Map<String, Long> countPerGenre(List<Book> bookList) {
        return bookList.stream().collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));
    }

}