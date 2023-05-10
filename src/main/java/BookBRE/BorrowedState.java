package BookBRE;

/** 대출한 상태 */
public class BorrowedState implements BookState {

    public BorrowedState() {}   // JSON 역직렬화에 필요함

    public void borrow(Book book) {
        System.out.println("이 책은 이미 대출한 책입니다.");
    }
    public void returnBook(Book book) {
        book.setBorrowedDate(null);
        book.setDueDate(null);  // 마감일 삭제
        book.setState(new AvailableState().toString());    // 대출 가능한 상태로 변경
    }
    public void extend(Book book) {
        book.setDueDate(book.getDueDate().plusDays(7)); // 마감일 7일 연장
        book.setState(new ExtendedState().toString()); // 연장한 상태로 변경
    }
}