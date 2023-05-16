package BookReservation;

import BookCRUD.Book;

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
        book.reserve();
        System.out.println(book.getTitle() + "이(가) 예약되었습니다.");
    }
}
