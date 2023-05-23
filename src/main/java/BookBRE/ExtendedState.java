package BookBRE;

/** 연장한 상태 */
public class ExtendedState implements BookState {

    @Override
    public void borrow(BookBRE book) {
        System.out.println("이 책은 이미 대출되었습니다.");
    }

    @Override
    public void returnBook(BookBRE book) {
        book.setBorrowedDate(null);
        book.setDueDate(null); // 마감일 삭제
        book.setState(new AvailableState());
    }

    @Override
    public void extend(BookBRE book) {
        System.out.println("이 책은 이미 연장되었습니다.");
    }

    @Override
    public String toString() {
        return "ExtendedState";
    }
}