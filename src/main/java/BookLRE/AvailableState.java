package BookLRE;

/** 대출 가능한 상태 */
public class AvailableState implements BookState {
    public void borrow(Book book) {
        book.setState(new BorrowedState());
    }
    public void returnBook(Book book) {
        System.out.println("이 책은 대출한 것이 아니므로 반납할 수 없습니다.");
    }
    public void extend(Book book) {
        System.out.println("이 책은 대출한 것이 아니므로 연장할 수 없습니다.");
    }
}