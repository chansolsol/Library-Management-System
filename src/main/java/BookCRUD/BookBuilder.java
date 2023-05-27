
package BookCRUD;

public class BookBuilder {
    private String title;
    private String author;
    private String publisher;
    private String year;
    private String id;

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }
    public BookBuilder setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }
    public BookBuilder setYear(String year) {
        this.year = year;
        return this;
    }
    public BookBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public Book build() {
        return new Book(title, author, publisher , year, id);
    }
}
