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
//ReserveCommand와 UnreserveCommand 클래스는 Command 인터페이스를 구현합니다.
// 이 클래스들은 Book 객체를 인자로 받으며, execute() 메서드에서는 해당 도서 객체의 reserve() 또는 unreserve() 메서드를
// 호출하여 도서를 예약 또는 취소합니다. 또한 예약 또는 취소된 도서의 제목을 출력합니다.
