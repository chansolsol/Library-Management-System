package BookBRE;

/** 대출 가능한 상태 */
public class AvailableState implements BookState {

    public AvailableState() {}  //JSON 역직렬화에 필요함

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