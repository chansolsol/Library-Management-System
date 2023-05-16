package BookReservation;

import BookCRUD.Book;

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
        book.unreserve();
        System.out.println(book.getTitle() + "이(가) 예약 취소되었습니다.");
    }
}
