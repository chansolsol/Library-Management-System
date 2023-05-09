/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookCRUD;

/**
 *
 * @author cyc53
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BookDatabase {
    private final String fileName;
    private final Gson gson;
    private final Type listType;

 public BookDatabase(String fileName) {
    this.fileName = fileName;
    this.gson = new Gson();
    this.listType = new TypeToken<List<Book>>(){}.getType();
}

public List<Book> load() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    List<Book> books = gson.fromJson(reader, listType);
    reader.close();
    return books != null ? books : new ArrayList<>();
}

public void save(List<Book> books) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    gson.toJson(books, writer);
    writer.close();
}
}