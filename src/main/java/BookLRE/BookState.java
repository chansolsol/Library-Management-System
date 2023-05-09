package BookLRE;

public interface BookState {

    /** 대출하기 */
    void borrow(Book book);

    /** 반납하기 */
    void returnBook(Book book);

    /** 연장하기 */
    void extend(Book book);
}
