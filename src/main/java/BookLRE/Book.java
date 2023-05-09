package BookLRE;

/** 현재 상태를 유지하고 변경하는 클래스 */
public class Book {

    private BookState state;

    public Book() {
        state = new AvailableState();
    }

    public void setState(BookState state) {
        this.state = state;
    }

    public void loan() {
        state.borrow(this);
    }

    public void returnBook() {
        state.returnBook(this);
    }

    public void extend() {
        state.extend(this);
    }
}
