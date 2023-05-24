package HopeBookRequest;

import java.util.Scanner;

/** 희망 도서 신청 수정 */
public class UpdateBookRequest extends BookRequest {
    @Override
    public void applicationCUD() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("수정할 희망 도서 제목 입력 : ");  //GUI 에선 버튼
        String bookTitle = scanner.nextLine();

        for (HopeBook book : books) {
            if (book.getTitle().equals(bookTitle)) {
                System.out.println("수정할 제목 입력 : ");
                String newTitle = scanner.nextLine();
                book.setTitle(newTitle);

                System.out.println("수정할 저자 입력 : ");
                String newAuthor = scanner.nextLine();
                book.setAuthor(newAuthor);

                System.out.println("수정할 출판사 입력 : ");
                String newPublisher = scanner.nextLine();
                book.setPublisher(newPublisher);

                System.out.println("수정할 년도 입력 : ");
                String newYear = scanner.nextLine();
                book.setYear(newYear);

                // 콘솔에서 입력된 마지막 개행문자를 소비
                scanner.nextLine();
            }
        }
    }
}
