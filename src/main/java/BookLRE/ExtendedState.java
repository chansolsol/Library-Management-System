package BookLRE;

/** 연장한 상태 */
public class ExtendedState implements BookState {
    public void borrow(Book book) {
        System.out.println("이 책은 이미 대출되었습니다.");
    }
    public void returnBook(Book book) {
        book.setState(new AvailableState());
    }
    public void extend(Book book) {
        System.out.println("이 책은 이미 연장되었습니다.");
    }
}