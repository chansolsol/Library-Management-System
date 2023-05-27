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

