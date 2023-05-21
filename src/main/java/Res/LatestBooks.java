package Res;

import HopeBookRequest.HopeBook;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/** 최신 도서 현황 불러오기 */
public class LatestBooks {

    /** 메인 페이지 생성자에 넣어서 페이지 출력될때마다 실행되게 하기 */
    private static final String DB_FILE_NAME = "books.json";
    List<HopeBook> books;
    Gson gson = new Gson();

    public LatestBooks() {

        try {
            Type bookListType = new TypeToken<List<HopeBook>>() {
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

        // 희망 도서 목록 출력
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ": " + books.get(i).getTitle() + " " + books.get(i).getAuthor() +
                    " " + books.get(i).getPublisher() + " " + books.get(i).getYear());
        }

    }

    public static void main(String[] args) {
        new LatestBooks();
    }
}


