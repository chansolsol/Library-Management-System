package BookReservation;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import BookCRUD.Book;

import Res.LocalDateAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BookRepository {
    private List<Book> books;
    private String filePath;

    public BookRepository(String filePath) {
        this.books = new ArrayList<>();
        this.filePath = filePath;
    }

    public void load() throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                        .create();
                Book[] bookArray = gson.fromJson(reader, Book[].class);
                for (Book book : bookArray) {
                    books.add(book);
                }
            }
        }
    }
    public List<Book> getBooks() {
        return books;
    }


    public void save() throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .setPrettyPrinting().create();
            String json = gson.toJson(books);
            writer.write(json);
        }
    }
}
//BookRepository 클래스는 books라는 List를 가지고 있으며, 이 리스트는 도서관에서 관리되는 도서 목록을 담고 있습니다.
// 이 클래스는 load() 메서드와 save() 메서드를 가지고 있습니다.
// load() 메서드는 파일에서 JSON 형태로 저장된 도서 목록을 읽어와 books 리스트에 추가하고,
// save() 메서드는 books 리스트에 저장된 도서 목록을 JSON 형태로 파일에 저장합니다.