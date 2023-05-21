package BookBRE;

import Res.UserInfo;

import java.time.LocalDate;

/** 현재 상태를 유지하고 변경하는 클래스 */
public class BookBRE {

    private String title;   // 책 제목
    private String author;  // 책 저자
    private String publisher; // 책 출판사
    private String year; // 책 출판연도
    private String id;  // 책 고유 식별자
    private String state;    // 책 상태
    private LocalDate borrowedDate; // 빌린 날짜
    private LocalDate dueDate;  // 만기 날짜
    private String memberID;    // 사용자 ID
    private boolean reserved; // 책 대여 여부

    public BookBRE() {
        this.state = new AvailableState().toString(); // 디폴트 상태, JSON 역직렬화에 필요함
    }

    public BookBRE(String title, String author, String publisher, String year, String id,
                   String state, LocalDate borrowedDate, LocalDate dueDate, String memberID) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.id = id;
        this.state = state;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.memberID = memberID;
        this.reserved = false;
    }

    public boolean borrow() {
        if ("available".equals(state)) {
            state = "borrowed";
            borrowedDate = LocalDate.now();
            dueDate = LocalDate.now().plusDays(7);
            memberID = UserInfo.getInstance().getUserID(); //유저 로그인 정보 싱글턴 반환
            return true;
        } else {
            System.out.println("이미 대출하였습니다.");
            return false;
        }
    }

    public boolean returnBook() {
        if ("borrowed".equals(state)) {
            state = "available";
            dueDate = null;
            return true;
        } else {
            System.out.println("대출하지 않은 책은 반납할 수 없습니다.");
            return false;
        }
    }

    public boolean extend() {
        if ("borrowed".equals(state)) {
            dueDate = dueDate.plusDays(7);
            return true;
        } else {
            System.out.println("대출하지 않은 책은 연장할 수 없습니다.");
            return false;
        }
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }
    public void setMemberID(String memberID){this.memberID = memberID;}
    public String getMemberID(){return memberID;}
}
