package Res;

import BookCRUD.Book;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** 연체 확인 기능 */
public class Delinquency {
    private static final String DB_FILE_NAME = "books.json";
    List<Book> books;

    // 메인 페이지 생성자에 넣어서 페이지 출력될때마다 실행되게 하기
    public Delinquency() {

        // LocalDate 어댑터를 사용해 Gson 인스턴스 생성
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        Gson gson = gsonBuilder.create();

        try {
            Type bookListType = new TypeToken<List<Book>>() {
            }.getType();

            // 희망 도서 json 읽어들이기
            FileReader reader = new FileReader(DB_FILE_NAME);
            books = gson.fromJson(reader, bookListType);
            reader.close();

            // 파일 비어 있으면 새 리스트 만들기
            if (books == null) {
                books = new ArrayList<>();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDate date = LocalDate.now();

        // 연체된 도서 있는지 확인
        for (int i = 0; i < books.size(); i++) {
//            System.out.println((i + 1) + ": " + books.get(i).getBorrowedDate() +
//                    " " + books.get(i).getDueDate());
            try {
                if (date.isAfter(books.get(i).getDueDate())) {  // 현재 날짜가 도서 마감일을 지나면 true 반환
                    JOptionPane alert = new JOptionPane();
                    JOptionPane.showMessageDialog(null, "현재 연체된 도서가 있습니다!", "알림", JOptionPane.WARNING_MESSAGE);
                    break;
                }
            } catch (NullPointerException e) {
                System.out.println("");
            }
        }
    }

}
