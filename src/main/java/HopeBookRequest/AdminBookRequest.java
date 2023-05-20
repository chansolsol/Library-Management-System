package HopeBookRequest;

import java.util.Iterator;
import java.util.Scanner;

/** 도서 관리자 */
public class AdminBookRequest extends BookRequest {
    @Override
    public void writeApplication() {

        // 희망 도서 목록 출력
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ": " + books.get(i).getTitle() + " " + books.get(i).getAuthor() +
                    " " + books.get(i).getPublisher() + " " + books.get(i).getYear());
        }

        // 확인한 희망 도서 삭제하기
        Scanner scanner = new Scanner(System.in);
        System.out.println("확인이 끝난 희망 도서를 삭제합니다.");
        System.out.println("확인 또는 취소 입력: ");
        String input = scanner.nextLine();

        if ("취소".equalsIgnoreCase(input)) {
            System.out.println("작업 취소됨");
        }

        if ("확인".equalsIgnoreCase(input)) {
            // GUI 에서는 각각 희망 도서 옆에 있는 "삭제" 버튼 누를시 해당 희망 도서 삭제하는 방식으로 할 예정
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


