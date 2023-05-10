package BookBRE;

/** 대출한 상태 */
public class BorrowedState implements BookState {

    public BorrowedState() {}   //JSON 역직렬화에 필요함

    public void borrow(Book book) {
        System.out.println("이 책은 이미 대출한 책입니다.");
    }
    public void returnBook(Book book) {
        book.setState(new AvailableState());
    }
    public void extend(Book book) {
        book.setState(new ExtendedState());
    }
}