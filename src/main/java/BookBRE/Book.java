package BookBRE;

/** 현재 상태를 유지하고 변경하는 클래스 */
public class Book {

    private String id;
    private String title;
    private BookState state;

    public Book() {
        this.state = new AvailableState(); // 디폴트 상태, JSON 역직렬화에 필요함
    }

    public Book(String id, String title, BookState state) {
        this.id = id;
        this.title = title;
        this.state = state;
    }

    public void borrow() {
        state.borrow(this);
    }

    public void returnBook() {
        state.returnBook(this);
    }

    public void extend() {
        state.extend(this);
    }

    public BookState getState() {
        return state;
    }

    public void setState(BookState state) {
        this.state = state;
    }
}
