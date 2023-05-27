package BookReservation;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import BookCRUD.Book;
import Res.LocalDateAdapter;
import java.time.LocalDate;

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
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
                Gson gson = gsonBuilder.create();
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
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            String json = gson.toJson(books);
            writer.write(json);
        }
    }
}


