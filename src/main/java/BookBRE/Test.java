package BookBRE;

import Res.LocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.InstanceCreator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Test {
    private static final String DB_FILE_NAME = "books.json";

    public static void main(String[] args) throws IOException {

        // LocalDate 어댑터를 사용해 Gson 인스턴스 생성
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        Gson gson = gsonBuilder.create();
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.registerTypeAdapter(BookState.class, (InstanceCreator<BookState>) type -> new AvailableState());
//        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
//        Gson gson = gsonBuilder.create();

        // books.json을 불러옴
        String json = new String(Files.readAllBytes(Paths.get(DB_FILE_NAME)));
        List<Book> books = gson.fromJson(json, new TypeToken<List<Book>>(){}.getType());

        // 도서를 대출함 (test)
        Book book = books.get(0);   // json에서 1번째 책
        book.borrow();
        System.out.println("대출한 도서 : " + book.getTitle() + ", 대출 마감일 : " + book.getDueDate());

        // 도서를 연장함 (test)
        book.extend();
        System.out.println("연장한 도서 : " + book.getTitle() + ", 새로운 마감일: " + book.getDueDate());

        // books.json을 업데이트 함
        json = gson.toJson(books);
        Files.write(Paths.get(DB_FILE_NAME), json.getBytes());
    }
}
