/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;

/**
 *
 * @author cyc53
 */
public class BookBuilder {
    private String title;
    private String author;
    private String id;

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public Book build() {
        return new Book(title, author, id);
    }
}
