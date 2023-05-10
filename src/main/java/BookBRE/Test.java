package BookBRE;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.InstanceCreator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/** 테스트 */
public class Test {
    private static final String DB_FILE_NAME = "books.json";

    public static void main(String[] args) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BookState.class, (InstanceCreator<BookState>) type -> new AvailableState());
        Gson gson = gsonBuilder.create();

        // 기존 books.json 을 읽어옴
        String json = new String(Files.readAllBytes(Paths.get(DB_FILE_NAME)));
        List<Book> books = gson.fromJson(json, new TypeToken<List<Book>>(){}.getType());

        // 책 ###을 대출함
        Book book = books.get(0);
        book.borrow();

//        // 책 ###을 반환함
//        book.returnBook();
//
//        // 책 ###을 연장함
//        book.borrow();  // 책을 연장하기전에 대출을 먼저 해야함
//        book.extend();

        // books.json을 업데이트
        json = gson.toJson(books);
        Files.write(Paths.get(DB_FILE_NAME), json.getBytes());
    }
}

