package BookReservation;

import BookCRUD.Book;

import javax.swing.*;

public class UnreserveCommand implements Command {
    private Book book;

    public UnreserveCommand(Book book) {
        this.book = book;
    }

    public interface Command {
        void execute();
    }


    @Override
    public void execute() {
        book.unreserved();
        System.out.println(book.getTitle() + "이(가) 예약 취소되었습니다.");
        JFrame alert = new JFrame();
        JOptionPane.showMessageDialog(alert, book.getTitle()+" 예약 취소 완료");

    }

}
