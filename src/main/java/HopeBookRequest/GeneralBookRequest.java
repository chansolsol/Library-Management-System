package HopeBookRequest;

import com.google.gson.Gson;
import java.util.Scanner;

/** 일반 사용자  */
public class GeneralBookRequest extends BookRequest {

    private static final String HOPE_BOOKS = "hopebooks.json";

    @Override
    public void writeApplication() {

            Scanner scanner = new Scanner(System.in);

            System.out.println("희망 도서 제목: ");
            String title = scanner.nextLine();

            System.out.println("희망 도서 저자: ");
            String author = scanner.nextLine();

            System.out.println("희망 도서 출판사: ");
            String publisher = scanner.nextLine();

            System.out.println("희망 도서 출판 년도: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            HopeBook hopeBook = new HopeBook(title, author, publisher, year);

            Gson gson = new Gson();

            // 리스트에 새 책 추가
            books.add(hopeBook);

            scanner.close();

    }
}

