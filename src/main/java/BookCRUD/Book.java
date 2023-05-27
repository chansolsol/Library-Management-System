
package BookCRUD;

import java.time.LocalDate;

public class Book {
    private String title;   //책 제목
    private String author;  //책 저자
    private String publisher; //책 출판사
    private String year; //책 출판연도
    private String id;  //책 고유 식별자
    private String state = "AvailableState";   //책 상태
    private LocalDate borrowedDate; // 빌린 날짜
    private LocalDate dueDate;  // 만기 날짜
    private String memberID = "";    // 사용자 ID
    private boolean reserved; // 책 예약 여부
    private String reservedID = ""; // 책 예약 ID


    // Book 클래스의 생성자
    public Book(String title, String author, String publisher, String year, String id) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.id = id;
        this.reserved = false;
        this.reservedID = "";
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
    public String getMemberID(){return memberID;}
    public String getState(){return state;}
    public LocalDate getBorrowedDate(){return borrowedDate;}
    public LocalDate getDueDate(){return dueDate;}
    public boolean isReserved() {return reserved;}
    public String getReservedID() {return reservedID;}

    public void reserve(String userID) {this.reserved = true;this.reservedID = userID;}

    public void unreserved() {this.reserved = false;this.reservedID = "";}


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
                ", borrowedDate='" + borrowedDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", memberID='" + memberID + '\'' +
                ", reserved=" + reserved +
                ", reservedID='" + reservedID + '\'' +
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
