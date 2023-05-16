package HopeBookRequest;

import BookBRE.Book;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public abstract class BookRequestTemplate {

    private static final String DB_FILE_NAME = "book_request.json";
    Gson gson = new Gson();

    /**
     * 템플릿 메소드
     */
    public final void requestBook() {
        checkBookInfo();
        writeApplication();
        submitApplication();
    }

    public void checkBookInfo() {
//        try {
//            // 신청 도서 정보 불러오기
//            Type bookListType = new TypeToken<List<Book>>() {
//            }.getType();
//            FileReader reader = new FileReader(DB_FILE_NAME);
//            List<Book> books = gson.fromJson(reader, bookListType);
//            reader.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public abstract void writeApplication(); // 신청서 작성, 서브클래스에서 구현
    // 게스트, 일반, 관리자에 맞게 오버라이딩

    public void submitApplication() {
        // 신청서 제출
        System.out.println("신청서 제출 하기");
    }

//    class NewBook {
//        private String title;   //책 제목
//        private String author;  //책 저자
//        private String publisher; //책 출판사
//        private String year; //책 출판연도
//        private String id;  //책 고유 식별자
//        private String state = "available";   //책 상태
//        private boolean reserved; // 책 대여 여부
//
//        public NewBook(String title, String author, String publisher, String year, String id) {
//            this.title = title;
//            this.author = author;
//            this.publisher = publisher;
//            this.year = year;
//            this.id = id;
//            this.reserved = false;
//        }
//
//
//        // getter 및 setter ..
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public String getAuthor() {
//            return author;
//        }
//
//        public void setAuthor(String author) {
//            this.author = author;
//        }
//
//        public String getPublisher() {
//            return publisher;
//        }
//
//        public void setPublisher(String publisher) {
//            this.publisher = publisher;
//        }
//
//        public String getYear() {
//            return year;
//        }
//
//        public void setYear(String year) {
//            this.year = year;
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getState() {
//            return state;
//        }
//
//        public void setState(String state) {
//            this.state = state;
//        }
//
//        public boolean isReserved() {
//            return reserved;
//        }
//
//        public void setReserved(boolean reserved) {
//            this.reserved = reserved;
//        }
//    }
}
