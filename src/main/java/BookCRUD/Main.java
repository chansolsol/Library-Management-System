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
                    int year = scanner.nextInt();
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
                    int newYear = scanner.nextInt();
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

/*맞습니다. Builder 디자인 패턴이 BookBuilder 클래스에서 적용되었습니다.

Builder 패턴은 복잡한 객체의 생성 과정을 캡슐화하고, 객체의 생성 과정을 조립하여 다양한 객체를 만들어내는 방식입니다. Builder 패턴을 적용한 클래스는 객체 생성을 담당하는 빌더 클래스와 생성할 객체를 표현하는 클래스로 분리됩니다.

BookBuilder 클래스에서는 Book 객체를 생성하기 위해 setTitle(), setAuthor(), setId() 메소드를 제공하고, 마지막으로 build() 메소드를 호출하여 Book 객체를 생성합니다. 이렇게 하면 Book 객체를 생성하기 위해 필요한 매개변수들을 일일이 지정하지 않고도, 각 매개변수에 해당하는 메소드를 호출하여 쉽게 Book 객체를 생성할 수 있습니다.

따라서, BookBuilder 클래스는 Builder 디자인 패턴의 기본 원칙을 충실히 따르고 있습니다.*/