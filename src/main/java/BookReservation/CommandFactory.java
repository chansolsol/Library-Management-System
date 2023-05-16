package BookReservation;

import BookCRUD.Book;

public class CommandFactory {
    public static Command createCommand(String commandName, Book book) {
        if (commandName.equals("Reserve")) {
            return new ReserveCommand(book);
        } else if (commandName.equals("Unreserve")) {
            return new UnreserveCommand(book);
        } else {
            throw new IllegalArgumentException("Invalid command name.");
        }
    }
}
