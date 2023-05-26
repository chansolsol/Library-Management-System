package HopeBookRequest;

public class Test {

    public static void main(String[] args) {

        String title = "test2";
        String author = "1";
        String publisher = "2";
        String year = "3";

        DeleteBookRequest deleteBookRequest = new DeleteBookRequest();
        CreateBookRequest createBookRequest = new CreateBookRequest();
        UpdateBookRequest updateBookRequest = new UpdateBookRequest();

//        createBookRequest.requestBook(title, author, publisher, year);
        updateBookRequest.requestBook(title, author, publisher, year);
//        deleteBookRequest.requestBook(title, author, publisher, year, userID);

    }
}
