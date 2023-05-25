package HopeBookRequest;

import Res.UserInfo;

import javax.swing.*;
import java.util.Scanner;

/**
 * 희망 도서 신청
 */
public class CreateBookRequest extends BookRequest {

    private static final String HOPE_BOOKS = "hopebooks.json";

    @Override
    public void applicationCUD(String title, String author, String publisher, String year) {

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("희망 도서를 신청합니다.");
//
//        System.out.println("희망 도서 제목: ");
//        String title = scanner.nextLine();
//
//        System.out.println("희망 도서 저자: ");
//        String author = scanner.nextLine();
//
//        System.out.println("희망 도서 출판사: ");
//        String publisher = scanner.nextLine();
//
//
//
//        System.out.println("희망 도서 출판 년도: ");
//        String year = scanner.nextLine();

        // 출판년도 값 문자열이면 오류 메시지박스 출력
        try {
            int value = Integer.parseInt(year);
        } catch (NumberFormatException ee) {
            System.out.println("오류");
            JOptionPane.showMessageDialog(null, "년도를 숫자로 입력해주세요.", "오류", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        scanner.nextLine();

        String userID = UserInfo.getInstance().getUserID();
        HopeBook hopeBook = new HopeBook(title, author, publisher, year, userID);
//        hopeBook.setHopeID(userID);  // 사용자 ID를 setHopeID 메서드에 전달합니다.
        // 리스트에 새 책 추가
        books.add(hopeBook);
        JFrame alert = new JFrame();
        JOptionPane.showMessageDialog(alert, title+" 생성 완료");

//        scanner.close();

    }
}

