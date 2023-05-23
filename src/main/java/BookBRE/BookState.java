package BookBRE;

public interface BookState {

    /** 대출하기 */
    void borrow(BookBRE book);

    /** 반납하기 */
    void returnBook(BookBRE book);

    /** 연장하기 */
    void extend(BookBRE book);

    String toString();

}
