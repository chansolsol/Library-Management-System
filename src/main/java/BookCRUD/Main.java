/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookCRUD;

/**
 *
 * @author cyc53
 */


import java.io.IOException;
import java.util.List;
import java.util.Scanner;



public class Main {
    private static final String DB_FILE_NAME = "books.json";
    public static void main(String[] args) throws IOException {
        BookDatabase database = new BookDatabase(DB_FILE_NAME);
        BookController controller = new BookController();
        List<Book> books = database.load();
        controller.addAll(books);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. 도서 검색 search");
            System.out.println("2. 도서 추가 add");
            System.out.println("3. 도서 삭제 remove");
            System.out.println("4. 도서 수정 update");
            System.out.println("5. 종료 exit");
            System.out.print("선택(select)> ");

            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("검색어> ");
                    String keyword = scanner.nextLine();
                    List<Book> searchedBooks = controller.searchBooks(keyword);
                    for (Book book : searchedBooks) {
                        System.out.println(book);
                    }
                    break;
                case 2:
                    System.out.print("제목(title)> ");
                    String title = scanner.nextLine();
                    System.out.print("저자(author)> ");
                    String author = scanner.nextLine();
                    System.out.print("출판사(publisher)> ");
                    String publisher = scanner.nextLine();
                    System.out.print("출판연도(year)> ");
                    String year = scanner.nextLine();
                    System.out.print("관리번호(id)> ");
                    String id = scanner.nextLine();
                    Book newBook = new BookBuilder().setTitle(title).setAuthor(author).setPublisher(publisher).setYear(year).setId(id).build();
                    controller.addBook(newBook);
                    database.save(controller.getAllBooks());
                    System.out.println("도서 추가 완료(end)");
                    break;
                case 3:
                    System.out.print("관리번호(id)> ");
                    String deleteId = scanner.nextLine();
                    controller.removeBook(deleteId);
                    database.save(controller.getAllBooks());
                    System.out.println("도서 삭제 완료(end)");
                    break;
                case 4:
                    System.out.print("관리번호(id)> ");
                    String updateId = scanner.nextLine();
                    System.out.print("제목(title)> ");
                    String newTitle = scanner.nextLine();
                    System.out.print("저자(author)> ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("출판사(publisher)> ");
                    String newPublisher = scanner.nextLine();
                    System.out.print("저자(year)> ");
                    String newYear = scanner.nextLine();
                    controller.updateBook(updateId, newTitle, newAuthor, newPublisher, newYear);
                    database.save(controller.getAllBooks());
                    System.out.println("도서 수정 완료(end)");
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}
