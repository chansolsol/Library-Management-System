/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package book;

/**
 *
 * @author cyc53
 */
public class Book {
    private String title;
    private String author;
    private String id;

    public Book(String title, String author, String id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
    public void setTitle(String title) {
    this.title = title;
    }
    public void setAuthor(String title) {
    this.title = title;
}


}
