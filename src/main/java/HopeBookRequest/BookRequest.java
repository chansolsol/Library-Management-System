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

public abstract class BookRequest {

    private static final String HOPE_BOOKS = "hopebooks.json";
    List<HopeBook> books;
    Gson gson = new Gson();

    /** 템플릿 메소드 */
    public final void requestBook() {
        checkBookInfo();
        writeApplication();
        saveBookInfo();
    }

    /** 희망 도서 정보 체크 */
    public void checkBookInfo() {

        try {
            Type bookListType = new TypeToken<List<HopeBook>>() {
            }.getType();

            // 희망 도서 json 읽어들이기
            FileReader reader = new FileReader(HOPE_BOOKS);
            books = gson.fromJson(reader, bookListType);
            reader.close();

            // 파일 비어 있으면 새 리스트 만들기
            if (books == null) {
                books = new ArrayList<>();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("희망 도서 json 불러오기");

    }

    /**
     * 신청서 작성, 서브클래스에서 구현
     * 게스트, 일반 사용자, 관리자에 맞게 오버라이딩
     */
    public abstract void writeApplication();


    /** 희망 도서 정보 저장 */
    public void saveBookInfo() {

        try {
            // 업데이트된 리스트를 파일에 다시 쓰기
            Writer writer = new FileWriter(HOPE_BOOKS);
            gson.toJson(books, writer);

            writer.close();

            System.out.println("json 파일 저장 완료");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
