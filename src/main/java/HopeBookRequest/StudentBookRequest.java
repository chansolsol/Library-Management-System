package HopeBookRequest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentBookRequest extends BookRequestTemplate {

    private static final String DB_FILE_NAME = "book_request.json";

    @Override
    public void writeApplication() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("title: ");
//        String title = scanner.nextLine();
//
//        System.out.println("author: ");
//        String author = scanner.nextLine();
//
//        System.out.println("publisher: ");
//        String publisher = scanner.nextLine();
//
//        System.out.println("year: ");
//        String year = scanner.nextLine();
//
//        String id = ""; //ID는 이후 관리자가 설정
//
//        NewBook newBook = new NewBook(title, author, publisher, year, id);
//
//        try {
//            Gson gson = new Gson();
//            Type bookListType = new TypeToken<List<NewBook>>() {
//            }.getType();
//
//            // 희망 도서 json 불러오기
//            FileReader reader = new FileReader(DB_FILE_NAME);
//            List<NewBook> books = gson.fromJson(reader, bookListType);
//            reader.close();
//
//            // 파일이 비었을시, 새로 생성
//            if (books == null) {
//                books = new ArrayList<>();
//            }
//
//            // 희망 도서 목록 추가
//            books.add(newBook);
//
//            // 업데이트 목록 다시 쓰기
//            Writer writer = new FileWriter(DB_FILE_NAME);
//            gson.toJson(books, writer);
//            writer.close();
//
//            System.out.println("도서 신청 성공!");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

