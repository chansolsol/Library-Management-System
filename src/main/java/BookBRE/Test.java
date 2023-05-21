package BookBRE;

import Res.LocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static final String DB_FILE_NAME = "books.json";

    public static void main(String[] args) throws IOException {

        BookState bookState = null;

        // LocalDate 어댑터를 사용해 Gson 인스턴스 생성
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        Gson gson = gsonBuilder.create();

        // books.json을 불러옴
        Path path = Paths.get(DB_FILE_NAME);
        String json = new String(Files.readAllBytes(path));
        List<BookBRE> books = gson.fromJson(json, new TypeToken<List<BookBRE>>(){}.getType());

        // 도서 검색
        Scanner scanner = new Scanner(System.in);
        System.out.println("도서 ID 검색: ");
        String id = scanner.nextLine();

        BookBRE book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (book == null) {
            System.out.println("해당 도서 ID를 찾지 못했습니다. : " + id);
            return;
        }

        // 액션 입력
        System.out.println("액션 입력 (borrow, extend, return) : ");
        String action = scanner.nextLine();

        switch (action) {
            case "borrow":
                bookState.borrow(book);
                System.out.println("대출 : " + book.getId());
                break;
            case "extend":
                bookState.extend(book);
                System.out.println("연장 : " + book.getId());
                break;
            case "return":
                bookState.returnBook(book);
                System.out.println("반납 : " + book.getId());
                break;
            default:
                System.out.println("유효하지 않은 액션 : " + action);
                break;
        }

        // books.json을 업데이트 함
        json = gson.toJson(books);
        Files.write(path, json.getBytes());

        scanner.close();
    }
}
