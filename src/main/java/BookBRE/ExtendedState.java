package BookBRE;

/** 연장한 상태 */
public class ExtendedState implements BookState {

    public void borrow(Book book) {
        System.out.println("이 책은 이미 대출되었습니다.");
    }
    public void returnBook(Book book) {
        book.setBorrowedDate(null);
        book.setDueDate(null); // 마감일 삭제
        book.setState(new AvailableState().toString());
    }
    public void extend(Book book) {
        System.out.println("이 책은 이미 연장되었습니다.");
    }
}