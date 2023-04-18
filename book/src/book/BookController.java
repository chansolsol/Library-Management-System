/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;

/**
 *
 * @author cyc53
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookController {
    private List<Book> books;

    public BookController() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(String id) {
        this.books = this.books.stream().filter(b -> !b.getId().equals(id)).collect(Collectors.toList());
    }

    public void updateBook(String id, String title, String author) {
        this.books.stream().filter(b -> b.getId().equals(id)).findFirst().ifPresent(b -> {
            b.setTitle(title);
            b.setAuthor(author);
        });
    }

    public List<Book> searchBooks(String keyword) {
        return this.books.stream().filter(b -> b.getTitle().contains(keyword) || b.getAuthor().contains(keyword)).collect(Collectors.toList());
    }

    public List<Book> getAllBooks() {
        return this.books;
    }
    public void addAll(List<Book> books) {
    this.books.addAll(books);
}

}
