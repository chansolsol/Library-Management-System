/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookCRUD;

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
        this.books.add(book);   // Book 객체를 받아서 "books" 목록에 추가합니다.
    }

    public void removeBook(String id) {
        this.books = this.books.stream().filter(b -> !b.getId().equals(id)).collect(Collectors.toList());
        //  "books" 목록에서 해당하는 id 값을 가진 Book 객체를 제거합니다.
    }

    public void updateBook(String id, String title, String author, String publisher, String year ) {
        this.books.stream().filter(b -> b.getId().equals(id)).findFirst().ifPresent(b -> {
            b.setTitle(title);
            b.setAuthor(author);
            b.setPublisher(publisher);
            b.setYear(year);
        }); // 해당하는 id 값을 가진 Book 객체의 제목과 작가, 출판사, 출판연도 를 수정합니다.
    }

    public List<Book> searchBooks(String keyword) {
        return this.books.stream().filter(b -> b.getTitle().contains(keyword) || b.getAuthor().contains(keyword)).collect(Collectors.toList());
        //주어진 키워드를 포함하는 Book 객체를 검색하여 목록으로 반환합니다.
    }

    public List<Book> getAllBooks() {
        return this.books;
        // "books" 목록을 반환합니다.
    }

    public List<Book> detailBooks(String keyword) {
        return this.books.stream().filter(b -> b.getId().contains(keyword) || b.getAuthor().contains(keyword)).collect(Collectors.toList());
        //주어진 키워드를 포함하는 Book 객체를 검색하여 목록으로 반환합니다.
    }

    public void addAll(List<Book> books) {
        this.books.addAll(books);
        //addAll(List<Book> books): 목록에 주어진 Book 객체 목록을 추가합니다.
    }

}
