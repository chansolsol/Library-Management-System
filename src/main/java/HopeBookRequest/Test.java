package HopeBookRequest;

public class Test {

    public static void main(String[] args) {

        DeleteBookRequest deleteBookRequest = new DeleteBookRequest();
        CreateBookRequest createBookRequest = new CreateBookRequest();
        UpdateBookRequest updateBookRequest = new UpdateBookRequest();

        createBookRequest.requestBook();
//        updateBookRequest.requestBook();
//        deleteBookRequest.requestBook();

    }
}
