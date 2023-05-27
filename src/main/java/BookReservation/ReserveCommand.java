package BookReservation;

import BookCRUD.Book;
import Res.UserInfo;

import javax.swing.*;

public class ReserveCommand implements Command {
    private Book book;

    public ReserveCommand(Book book) {
        this.book = book;
    }

    public interface Command {
        void execute();
    }


    @Override
    public void execute() {
        String userID = UserInfo.getInstance().getUserID();
        book.reserve(userID);  // 사용자 ID를 reserve 메서드에 전달합니다.
        System.out.println(book.getTitle() + "이(가) 예약되었습니다.");
        JFrame alert = new JFrame();
        JOptionPane.showMessageDialog(alert, book.getTitle()+" 예약 완료");
    }
}
