package BookReservation;

import java.io.IOException;
import java.util.Scanner;
import BookCRUD.Book;

public class BookReservation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "books.json";  // 파일 경로
        BookRepository bookRepo = new BookRepository(filePath);

        try {
            bookRepo.load();  // 파일에서 책 목록 불러오기
        } catch (IOException e) {
            System.out.println("책 목록을 불러오는 데 실패했습니다.");
            return;
        }

        while (true) {
            System.out.println("====== 도서관 서비스 ======");
            System.out.println("1. 도서 목록");
            System.out.println("2. 도서 예약");
            System.out.println("3. 도서 예약 취소");
            System.out.println("4. 종료");
            System.out.print("선택> ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("====== 도서 목록 ======");
                    for (Book book : bookRepo.getBooks()) {
                        System.out.println(book);
                    }
                    break;

                case 2:
                    System.out.print("예약할 책 제목을 입력하세요: ");
                    String title = scanner.nextLine();

                    // 입력한 책 제목과 일치하는 책을 찾음
                    Book bookToReserve = null;
                    for (Book book : bookRepo.getBooks()) {
                        if (book.getTitle().equals(title)) {
                            bookToReserve = book;
                            break;
                        }
                    }

                    // 일치하는 책이 없는 경우
                    if (bookToReserve == null) {
                        System.out.println("해당하는 책이 없습니다.");
                        break;
                    }

                    // 책 예약
                    Command reserveCommand = CommandFactory.createCommand("Reserve", bookToReserve);
                    reserveCommand.execute();
                    try {
                        bookRepo.save();  // 변경 내용 저장
                    } catch (IOException e) {
                        System.out.println("책 목록을 저장하는 데 실패했습니다.");
                    }
                    break;

                case 3:
                    System.out.print("예약을 취소할 책 제목을 입력하세요: ");
                    title = scanner.nextLine();

                    // 입력한 책 제목과 일치하는 책을 찾음
                    Book bookToUnreserved = null;
                    for (Book book : bookRepo.getBooks()) {
                        if (book.getTitle().equals(title)) {
                            bookToUnreserved = book;
                            break;
                        }
                    }

                    // 일치하는 책이 없는 경우
                    if (bookToUnreserved == null) {
                        System.out.println("해당하는 책이 없습니다.");
                        break;
                    }

                    // 책 예약 취소
                    // 예약 취소하는 Command를 생성하고 실행함
                    Command unreserveCommand = CommandFactory.createCommand("Unreserved", bookToUnreserved);
                    unreserveCommand.execute();
                    try {
                        bookRepo.save(); // 변경 내용 저장
                    } catch (IOException e) {
                        System.out.println("책 목록을 저장하는 데 실패했습니다.");
                    }
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;

                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    break;
            }
        }
    }
}
//커맨드 패턴이 적용된 부분은 Command 인터페이스와 ReserveCommand, UnreserveCommand 클래스입니다.
// Command 인터페이스는 명령 객체들이 구현해야 하는 execute() 메서드를 선언합니다.
// ReserveCommand와 UnreserveCommand 클래스는 Command 인터페이스를 구현하여 execute() 메서드를 구현하고,
// 해당 도서 객체의 reserve() 또는 unreserve() 메서드를 호출합니다. 이를 통해 각각의 명령이 도서 객체에 적용되며,
// 명령 객체들은 도서 객체와 독립적으로 존재합니다. 이렇게 함으로써,
// 예약 시스템에 새로운 명령이 추가될 경우 명령 객체만 추가하면 되므로 코드의 확장성이 좋아집니다.

