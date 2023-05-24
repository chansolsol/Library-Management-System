package HopeBookRequest;

import java.util.Iterator;
import java.util.Scanner;

/** 희망 도서 신청 삭제 */
public class DeleteBookRequest extends BookRequest {

    /**
     실제 적용 시 콘솔 명령어 빼고 적용
     * */
    @Override
    public void applicationCUD(String title, String author, String publisher, String year) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("희망 도서를 삭제합니다.");

            // GUI 에서는 "삭제" 버튼 누를시 해당 희망 도서 삭제하는 방식으로 할 예정
//            System.out.println("삭제할 도서 제목 입력 : ");
//            String title = scanner.nextLine();

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


