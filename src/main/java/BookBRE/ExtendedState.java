package BookBRE;

import javax.swing.*;

/** 연장한 상태 */
public class ExtendedState implements BookState {

    @Override
    public void borrow(BookBRE book) {
        JFrame alert = new JFrame();
        JOptionPane.showMessageDialog(alert, "이미 대출된 도서입니다.");
    }

    @Override
    public void returnBook(BookBRE book) {
        book.setBorrowedDate(null);
        book.setDueDate(null); // 마감일 삭제
        book.setMemberID(null);
        book.setState(new AvailableState());
    }

    @Override
    public void extend(BookBRE book) {
        JFrame alert = new JFrame();
        JOptionPane.showMessageDialog(alert, "연장은 1회만 가능합니다.");
    }

    @Override
    public String toString() {
        return "ExtendedState";
    }
}