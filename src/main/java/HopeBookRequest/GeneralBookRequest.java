package HopeBookRequest;

import com.google.gson.Gson;

import java.util.Iterator;
import java.util.Scanner;

/** 일반 사용자  */
public class GeneralBookRequest extends BookRequest {

    private static final String HOPE_BOOKS = "hopebooks.json";

    @Override
    public void writeApplication() {

            Scanner scanner = new Scanner(System.in);

        System.out.println("희망 도서를 신청 또는 삭제합니다.");
        System.out.println("신청 또는 삭제 입력: ");
        String input = scanner.nextLine();

        if ("신청".equalsIgnoreCase(input)) {
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

        if ("삭제".equalsIgnoreCase(input)) {
            // GUI 에서는 마이페이지 내의 희망 도서 신청 목록 옆에 있는 각각의 "삭제" 버튼 누를시 해당 희망 도서 삭제하는 방식으로 할 예정
            System.out.println("삭제할 도서 제목 입력 : ");
            String title = scanner.nextLine();

            Iterator<HopeBook> iterator = books.iterator();
            while (iterator.hasNext()) {
                HopeBook book = iterator.next();
                if (book.getTitle().equals(title)) {
                    iterator.remove();
                    System.out.println("삭제 완료");
                } else {
                    System.out.println("해당 도서를 찾을 수 없습니다.");
                }
            }
        }

    }
}

