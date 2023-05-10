/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BookCRUD;

/**
 *
 * @author cyc53
 */
public class Book {
    private String title;   //책 제목
    private String author;  //책 저자
    private String publisher; //책 출판사
    private String year; //책 출판연도
    private String id;  //책 고유 식별자
    private String state = "available";   //책 상태

    // Book 클래스의 생성자
    public Book(String title, String author, String publisher, String year, String id) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.id = id;
    }
    //Getter 메서드들
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getYear() {
        return year;
    }
    public String getId() {
        return id;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year='" + year + '\'' +
                ", id='" + id + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
    // Setter 메서드들
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setYear(String year) {
        this.year = year;
    }

}
/*Book 클래스의 멤버 변수들은 private으로 선언되어 있습니다. 이는 외부에서 Book 클래스의 멤버 변수에 접근하는 것을 막기 위해서입니다. 멤버 변수에 접근하려면 Getter와 Setter 메서드를 사용해야 합니다.

Book 클래스의 생성자는 title, author, publisher, year, id를 인자로 받습니다. 이들은 Book 객체가 생성될 때 초기화됩니다. 생성자는 클래스 이름과 동일한 이름을 가지고 있습니다.

Book 클래스의 toString() 메서드는 문자열로 변환된 객체를 반환합니다. 이 메서드를 호출하면 책의 제목, 저자, 그리고 고유 식별자가 문자열로 반환됩니다.

마지막으로, Book 클래스의 Setter 메서드들은 각 멤버 변수를 업데이트할 때 사용됩니다. Setter 메서드들은 public으로 선언되어 있으므로 외부에서 호출이 가능합니다.*/
