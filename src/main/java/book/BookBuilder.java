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
    private String publisher;
    private String year;
    private String id;

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }
    public BookBuilder setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }
    public BookBuilder setYear(String year) {
        this.year = year;
        return this;
    }
    public BookBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public Book build() {
        return new Book(title, author, publisher , year, id);
    }
}
/*
BookBuilder는 빌더 패턴을 구현한 클래스입니다.
빌더 패턴은 복잡한 객체 생성을 단순화하고, 가독성과 유지보수성을 높이기 위한 디자인 패턴입니다.
이 클래스는 Book 객체를 생성하기 위한 빌더 클래스로, Book 클래스의 생성자의 매개변수를 하나씩 세팅해주는 메소드들과 build() 메소드를 가지고 있습니다.
BookBuilder 클래스의 각 메소드는 해당 값을 설정한 뒤, 자기 자신을 반환하여 메소드 체이닝이 가능하도록 합니다.
*/