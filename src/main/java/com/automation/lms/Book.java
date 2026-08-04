package com.automation.lms;

import java.util.Objects;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private int publicationYear;
    private double price;
    private int availableCopies;

    public Book(String bookId, String title, String author, String genre, int publicationYear, double price, int availableCopies){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.price = price;
        this.availableCopies = availableCopies;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                ", availableCopies=" + availableCopies +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Book other = (Book) obj;

        return Objects.equals(bookId, other.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }
}