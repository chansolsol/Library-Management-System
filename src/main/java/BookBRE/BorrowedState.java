package BookBRE;

import javax.swing.*;

/** 대출한 상태 */
public class BorrowedState implements BookState {

    public BorrowedState() {}   // JSON 역직렬화에 필요함


    @Override
    public void borrow(BookBRE book) {
        JFrame alert = new JFrame();
        JOptionPane.showMessageDialog(alert, "이미 대출된 도서입니다.");
    }

    @Override
    public void returnBook(BookBRE book) {
        book.setBorrowedDate(null);
        book.setDueDate(null);  // 마감일 삭제
        book.setMemberID(null);
        book.setState(new AvailableState());    // 대출 가능한 상태로 변경
    }

    @Override
    public void extend(BookBRE book) {
        book.setDueDate(book.getDueDate().plusDays(7)); // 마감일 7일 연장
        book.setState(new ExtendedState()); // 연장한 상태로 변경
        JFrame alert = new JFrame();
        JOptionPane.showMessageDialog(alert, "연장 완료");
    }

    @Override
    public String toString() {
        return "BorrowedState";
    }
}